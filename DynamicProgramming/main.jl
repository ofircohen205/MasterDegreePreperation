include("./LongestCommonSubstring/longestCommonSubstring.jl")
include("./MultMatricesProblem/multMatricesProblem.jl")
include("./LongestIncreasingSubsequence/LongestIncreasingSubsequence.jl")
using .LCS, .MatrixChain, .LIS

# X = "abcda"
# Y = "bcabd"
# m, n = length(X), length(Y)
# sequenceSizeMatrix, arrowMatrix = longestCommonSubstring(X,Y, m+1, n+1)
# printLongestCommonSubstring(arrowMatrix, X, m+1, n+1)

# println("\n---------------------------------------------------------")

# vector = [30,35,15,5,10,20,25]
# M,S = multMatrices(vector, length(vector))
# display(M)
# println()
# display(S)
# println("\n---------------------------------------------------------")

vector = [30,35,15,5,10,20,25]
subSequence = longestIncreasingSubsequence(vector, length(vector))
println(subSequence)
println("size: ", length(subSequence))