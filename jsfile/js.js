
var arr = [32,63,76,18,45,23,84];

function getMaxValue(arr) {
    var max = arr[0];
    for(var i=1; i<arr.length; i++){
        if (arr[i] > max){
            max = arr[i]
        }
    }
    return max;
}

/*
* 选择排序
* */
function sortArr(arr){
    for(var i=0; i<arr.length-1; i++){
        for(var j=i+1; j<arr.length; j++){
            if(arr[i]>arr[j]){
                swap(arr, i, j);
            }
        }
    }
}

/*
* 冒泡排序
* */
function sortArr2(arr) {
    for(var i=0; i<arr.length-1; i++){
        for(var j=0; i<arr.length-1-i; j++){
            if(arr[j]>arr[j+1]){
                swap2(arr, j, (j+1));
            }
        }
    }
}

/*
* 交换位置1
* */
function swap(arr, i, j){
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

/*
* 交换位置2
* */
function swap2(arr, i, j){
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[j] ^ arr[i];
    arr[i] = arr[i] ^ arr[j];
}

/*
* 二分查找
* */
function binarySearch(arr, target){
    var maxIndex = arr.length-1;
    var minIndex = 0;
    var midIndex = Math.floor((maxIndex + minIndex) / 2);
    // if(target < arr[minIndex] || target > arr[maxIndex]){
    //     return -1;
    // }
    for(;minIndex<=maxIndex;){
        if(arr[midIndex] > target){
            maxIndex = midIndex - 1;
        }else if(arr[midIndex] < target){
            minIndex = midIndex + 1;
        }
        else{
            return midIndex;
        }
        midIndex = Math.floor((maxIndex + minIndex) / 2);
    }
    return -1-midIndex;
}

// 排序后arr:18,23,32,45,63,76,84
document.write("排序前arr:"+arr+"<br />");
sortArr(arr);
document.write("排序后arr:"+arr+"<br />");
var target = 64;
document.write(target+"在数组中的位置是:"+binarySearch(arr, target));
// alert(getMaxValue(arr));