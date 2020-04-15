module MatrixChain

    using OffsetArrays

    export multMatrices, matrixChainOrder

    function multMatrices(vectorP::Array, size::Int)
        M = zeros(Int, size, size)
        S = zeros(Int, size, size)
        
        size -= 1
        OM = fill!(OffsetArray(M, 0:size, 0:size), typemax(Int))
        OS = OffsetArray(S, 0:size, 0:size)
        OVectorP = OffsetArray(vectorP, 0:size)

        for i in 0:size
            OM[i,i] = 0
        end

        for l in 2:size
            for i in 1:(size-l+1)
                j = i + l - 1
                OM[i,j] = typemax(Int)
                for k in i:j-1
                    q = OM[i,k] + OM[k+1, j] + OVectorP[i-1]*OVectorP[k]*OVectorP[j]
                    if q < OM[i,j]
                        OM[i,j] = q
                        OS[i,j] = k
                    end
                end
            end
        end
        return OM[1,size], OS
    end

    function matrixChainOrder(OS, i, j)
        if i == j
            print("A", i)
            return
        end

        print("(")
        matrixChainOrder(OS, i, OS[i,j])
        matrixChainOrder(OS, OS[i,j]+1, j)
        print(")")
    end
end