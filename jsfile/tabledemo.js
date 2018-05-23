var name;
onload = function (ev) {
    var oTabNode = document.getElementById("tabid");
    var oTrNodes = oTabNode.rows;
    for(var i=1; i<oTrNodes.length;i++){
        if(i % 2){
            oTrNodes[i].className = "odd";
        }
        else{
            oTrNodes[i].className = "even"
        }
        oTrNodes[i].onmouseover = function () {
            name = this.className;
            this.className = "over";
        };
        oTrNodes[i].onmouseout = function () {
            this.className = name;
        }
    }

};
var flag = true;
function sortTab() {
    var oTabNode = document.getElementById("tabid");
    var oTrNodes = oTabNode.rows;

    if(flag){
        swap(oTrNodes);
        flag = false;
    }else{
        swap1(oTrNodes);
        flag = true;
    }
}

function swap(arr) {
    var collTempTrs = new Array(3);
    for(var i=1; i<arr.length-1; i++) {
        for (var j = i + 1; j < arr.length; j++) {
            if (arr[i].cells[1].innerHTML > arr[j].cells[1].innerHTML) {
                for (var k = 0; k < arr[i].cells.length; k++) {
                    collTempTrs[k] = arr[i].cells[k].innerHTML;
                    arr[i].cells[k].innerHTML = arr[j].cells[k].innerHTML;
                    arr[j].cells[k].innerHTML = collTempTrs[k];
                }
            }
        }
    }
}
function swap1(arr) {
    var collTempTrs = new Array(3);
    for(var i=1; i<arr.length-1; i++) {
        for (var j = i + 1; j < arr.length; j++) {
            if (arr[i].cells[1].innerHTML < arr[j].cells[1].innerHTML) {
                for (var k = 0; k < arr[i].cells.length; k++) {
                    collTempTrs[k] = arr[i].cells[k].innerHTML;
                    arr[i].cells[k].innerHTML = arr[j].cells[k].innerHTML;
                    arr[j].cells[k].innerHTML = collTempTrs[k];
                }
            }
        }
    }
}
