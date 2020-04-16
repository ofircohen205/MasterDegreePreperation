include("./LongestCommonSubstring/longestCommonSubstring.jl")
include("./MultMatricesProblem/multMatricesProblem.jl")
include("./LongestIncreasingSubsequence/LongestIncreasingSubsequence.jl")
include("./SubsetSum/subsetSum.jl")
using .LCS, .MatrixChain, .LIS, .subsetSum

# X = "abcda"
# Y = "bcabd"
# m, n = length(X), length(Y)
# sequenceSizeMatrix, arrowMatrix = longestCommonSubstring(X,Y, m+1, n+1)
# printLongestCommonSubstring(arrowMatrix, X, m+1, n+1)

# println("\n---------------------------------------------------------")

# # vector = [30,35,15,5,10,20,25]
# vector1 = [1, 5, 25, 30, 100, 70, 2, 1, 100, 250, 1, 1000, 2]
# numOfActions, OS = multMatrices(vector1, length(vector1))
# println("Num of actions: ", numOfActions)
# matrixChainOrder(OS, 1, length(vector1)-1)
# println("\n---------------------------------------------------------")

vector = [30,35,15,5,10,20,25]
# subSequence = longestIncreasingSubsequence(vector, length(vector))
# println(subSequence)
# println("size: ", length(subSequence))
# println("\n---------------------------------------------------------")

subset = isSubsetSum(vector, 17, length(vector))
display(subset)
println("\n---------------------------------------------------------")
