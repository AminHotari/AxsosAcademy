def ReverseList(list):
    y= []
    for i in range(len(list)-1,-1,-1):
        y.append(list[i])
    return y
print(ReverseList([37,2,1,-9]))


def ReverseList(list):
    list = list[::-1]
    return list

print(ReverseList([37,2,1,-9]))


