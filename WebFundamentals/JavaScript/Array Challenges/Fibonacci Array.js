function fibonacciArray(n) {
   
    var fibArr = [0, 1];
    for(i=2; i < n;i++){
        fibArr[i]=fibArr[i-2]+fibArr[i-1];    
    
    }
    return fibArr;
}
   
var result = fibonacciArray(10);
console.log(result); 