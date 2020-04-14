function gasStationProblem(gasStationLocation::Array, fuelTankSize::Int)
    currentLocation = 1
    endLocation = length(gasStationLocation)
    result = [gasStationLocation[currentLocation]]

    while currentLocation < endLocation
        lastLocation = currentLocation
        while currentLocation < endLocation && gasStationLocation[currentLocation+1] - gasStationLocation[lastLocation] <= fuelTankSize
            currentLocation = currentLocation+1
        end
        if currentLocation < endLocation
            push!(result, gasStationLocation[currentLocation])
        end
    end
    push!(result, gasStationLocation[endLocation])
    return result
end


retVal = gasStationProblem([0,7,9,16,17,20], 10)
println(retVal)