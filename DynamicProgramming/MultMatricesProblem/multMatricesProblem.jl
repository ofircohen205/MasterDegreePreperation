function multMatrices(vectorP::Vector, size::Int)
    M = zeros(size, size)
    S = zeros(size, size)
    for i in 1:size, j in 1:size
        M[i,j] = Inf
    end

    for i in 1:size
        M[i,i] = 0
    end

    for l in 2:size
        for i in 1:(size-l+1)
            j = i + l - 1
            for k in i:j-1
                q = M[i,k] + M[k+1, j] + vectorP[i]*vectorP[k]*vectorP[j]
                if q < M[i,j]
                    M[i,j] = q
                    S[i,j] = k
                end
            end
        end
    end

    display(M)
    println()
    display(S)
    println()
end

vector = [30,35,15,5,10,20,25]
multMatrices(vector, length(vector))