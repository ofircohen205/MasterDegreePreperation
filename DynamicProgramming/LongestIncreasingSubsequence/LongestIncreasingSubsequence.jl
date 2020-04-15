module LIS

    export longestIncreasingSubsequence

    function longestIncreasingSubsequence(array::Array, size::Int)
        
        resultArray = ones(Int128, size)*-1
        lis = ones(Int128, size)
        for i in 2:size
            for j in 1:i
                # store the size of the longest increasing subSequence until index i
                # store the index of the last number in the subSequence
                if array[j] < array[i] && lis[i] < lis[j]+1
                    lis[i] = lis[j]+1
                    resultArray[i] = j
                end
            end
        end

        # get the index of the last element in the subSequence
        max, pos = 0, 0
        for i in 1:size
            if max < lis[i]
                max = lis[i]
                pos = i
            end
        end

        # restore the longest increasing subSequence
        subSequence = []
        while pos != -1
            push!(subSequence, array[pos])
            pos = resultArray[pos]
        end

        return reverse!(subSequence)
    end

end