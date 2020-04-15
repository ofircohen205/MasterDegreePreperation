module MatrixChain

    export multMatrices

    function multMatrices(vectorP::Array, size::Int)
        M = zeros(Int128, size, size)
        S = zeros(Int128, size, size)
        for i in 1:size, j in 1:size
            M[i,j] = Inf
        end

        for i in 1:size
            M[i,i] = 0
        end

        for l in 2:size
            for i in 2:(size-l+1)
                j = i + l - 1
                for k in i:j-1
                    q = M[i,k] + M[k+1, j] + vectorP[i-1]*vectorP[k]*vectorP[j]
                    if q < M[i,j]
                        M[i,j] = q
                        S[i,j] = k
                    end
                end
            end
        end
        return M, S
    end
end