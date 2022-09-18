def BiggieSize(list):
    for val in range(0,len(list),1):
        if list[val] > 0:
            list[val] = "big"
    return list
print(BiggieSize([-1,3,5,-5]))