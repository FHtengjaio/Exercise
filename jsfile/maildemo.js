var name;
onload = function (ev) {
    trColor();
};

function checkAll(node){
    var oCheckboxes = document.getElementsByName("item");
    for(var i=0; i<oCheckboxes.length; i++){
        oCheckboxes[i].checked = node.checked;
    }
}

function trColor() {
    var oTabNode = document.getElementById("tabid");
    var oTrNodes = oTabNode.rows;
    for (var i=1; i<oTrNodes.length; i++){
        if(i % 2)
            oTrNodes[i].className = "odd";
        else
            oTrNodes[i].className = "even";
        oTrNodes[i].onmouseover = function () {
            name = this.className;
            this.className = "over";
        };
        oTrNodes[i].onmouseout = function () {
            this.className = name;
        };
    }
}

function setCheckboxByButton(number){
    var inputs = document.getElementsByTagName("input");
    for(var i=0; i<inputs.length; i++){
        if(number>1)
            inputs[i].checked = !inputs[i].checked;
        else
            inputs[i].checked = number;
    }
}

function delMail() {
    var inputs = document.getElementsByTagName("input");
    for(var i=0; i<inputs.length; i++){
        if(!inputs[i].checked)
            continue;
        var trNode = inputs[i].parentNode.parentNode;
        trNode.parentNode.removeChild(trNode);
        i--;
        trColor();
    }
}

function delMail2(){
    var index = 0;
    var inputs = document.getElementsByTagName("input");
    var arr = [];
    for(var i=0; i<inputs.length; i++){
        if(inputs[i].checked)
            arr[index++] = inputs[i].parentNode.parentNode;
    }
    for(var j=0; j<arr.length; j++){
        arr[j].parentNode.removeChild(arr[j]);
    }
    trColor();
}