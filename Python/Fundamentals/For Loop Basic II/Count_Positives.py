def CountPositives(list):
    count = 0
    for val in list:
        if val > 0:
            count +=1
        list [-1] = count
    return list

print(CountPositives([-1,1,1,1]))
print(CountPositives([1,6,-4,-2,-7,-2]))