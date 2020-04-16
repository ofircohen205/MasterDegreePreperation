module subsetSum

    using OffsetArrays
    export isSubsetSum

    function isSubsetSum(set, sum, size)
        oset = OffsetArray(set, 0:size-1)
        subset = falses(sum+1, size+1)
        osubset = OffsetArray(subset, 0:sum, 0:size)

        for i in 0:size
            osubset[0,i] = true
        end

        for i in 0:sum
            osubset[i,0] = false
        end

        for i in 1:sum
            for j in 1:size
                osubset[i,j] = osubset[i, j-1]

                if i >= oset[j-1]
                    osubset[i,j] = osubset[i,j] || osubset[i-oset[j-1], j-1]
                end
            end
        end

        return osubset[sum, size]
    end

end