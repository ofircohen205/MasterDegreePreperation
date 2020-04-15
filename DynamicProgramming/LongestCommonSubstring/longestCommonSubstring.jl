function longestCommonSubstring(stringX::String, stringY:: String, m::Integer, n::Integer)
    C = zeros(m,n)
    B = Array{Union{Nothing, String}}(nothing, m, n)

    for i in 2:m
        for j in 2:n
            if stringX[i-1] == stringY[j-1]
                C[i,j] = C[i-1,j-1]+1
                B[i,j] = "Diagonal"
            else
                if C[i,j-1] >= C[i-1,j]
                    C[i,j] = C[i,j-1]
                    B[i,j] = "Left"
                else
                    C[i,j] = C[i-1,j]
                    B[i,j] = "Up"
                end
            end
        end
    end
    return C,B
end

function printLongestCommonSubstring(arrowMatrix, stringX, i, j)
    if i == 1 || j == 1
        return
    end

    if arrowMatrix[i,j] == "Diagonal"
        printLongestCommonSubstring(arrowMatrix, stringX, i-1, j-1)
        print(stringX[i-1])
    else
        if arrowMatrix[i,j] == "Left"
            printLongestCommonSubstring(arrowMatrix, stringX, i, j-1)
        elseif arrowMatrix[i,j] == "Up"
            printLongestCommonSubstring(arrowMatrix, stringX, i-1, j)
        end
    end
end


X = "abcda"
Y = "bcabd"
m, n = length(X), length(Y)
sequenceSizeMatrix, arrowMatrix = longestCommonSubstring(X,Y, m+1, n+1)
printLongestCommonSubstring(arrowMatrix, X, m+1, n+1)