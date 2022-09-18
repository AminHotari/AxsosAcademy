def Average (list):
    sum = 0
    for value in range(len(list)):
        sum += list[value]
        avrg = sum/len(list)

    return avrg

print(Average ([1,2,3,4]))

def Average (list):
    sum = 0
    for value in list:
        sum += value
        avrg = sum/len(list)

    return avrg

print(Average ([1,2,3,4]))