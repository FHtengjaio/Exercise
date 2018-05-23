var name;
onload = function (ev) {
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
        oTrNodes[i].cells[0].get = function () {
            for(var j=1; j<oTrNodes.length; j++){
                if(!oTrNodes[j].cells[0].checked){
                    flag = false;
                }
            }
            if(flag)
                oTrNodes[0].cells[0].checked = true;
        }
    }
};

function check() {
    var inputs = document.getElementsByTagName("input");
    for(var i=1; i<inputs.length; i++){
        inputs[i].onclick = function (ev) {
            for(var j=0; j<)
        };
    }
}

function selectAll(){
    var inputs = document.getElementsByTagName("input");
    for(var i=0; i<inputs.length; i++){
        inputs[i].checked = true;
    }
}

function cancleAll(){
    var inputs = document.getElementsByTagName("input");
    for(var i=0; i<inputs.length; i++){
        inputs[i].checked = false;
    }
}

function oppositeAll() {
    var inputs = document.getElementsByTagName("input");
    for(var i=1; i<inputs.length; i++){
        inputs[i].checked = inputs[i].checked?false:true;
    }
}