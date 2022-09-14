def ValuesGreaterThanSecond(list):
    if len(list) < 2:
        return False
    newlist = []
    for value in list:
        if value > list[1]:
            newlist.append(value)
    return newlist        

print(ValuesGreaterThanSecond([5,2,3,2,1,4]))
