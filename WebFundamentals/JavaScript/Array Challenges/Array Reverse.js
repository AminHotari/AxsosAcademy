var arr1 = [];
function reverse(arr) {
    for(i=arr.length-1;i>=0;i--){
        arr1.push(arr[i])
        
    }
    
    return arr1;
}
   
var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); 
