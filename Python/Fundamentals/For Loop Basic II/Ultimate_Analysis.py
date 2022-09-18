def UltimateAnalysis(list):
    sum = 0
    min = list[0]
    max = list[0]
    leng = len(list)
    for value in list:
        sum += value
        avg = sum / len(list)
        if value < min:
            min = value
        if value > max:
            max = value

    dict = {'sumTotal':sum,'average':avg,'minimum':min,'maximum':max,'length':leng}
    return dict

print(UltimateAnalysis([37,2,1,-9]))