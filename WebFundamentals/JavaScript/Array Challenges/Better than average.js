function betterThanAverage(arr) {
    var sum = 0;
    var avg = 0;
    var count = 0;
    for(i=0; i <arr.length; i++){
        sum += arr[i];
        avg= sum/arr.length;
       

    }
    for(i=0; i<arr.length;i++){
        if (arr[i] >avg){
            count++;
        }
    }

    
    return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); 