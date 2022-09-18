def Minimum(list):
    if len(list) > 0:
        min = list[0]
        for i in range(len(list)):
            if list[i] < min:
                min = list[i]
    else:
        return False

    return min
print(Minimum([37,2,1,-9]))
print(Minimum([]))