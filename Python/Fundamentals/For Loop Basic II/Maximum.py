def Maximum(list):
    if len(list) > 0:
        max = list[0]
        for x in list:
            if x > max:
                max = x
    else:
        return False        
    return max

print(Maximum([37,2,1,-9]))
print(Maximum([]))