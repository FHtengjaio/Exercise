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

    }
    check();
};

function check() {
    var flag = true;
    var inputs = document.getElementsByTagName("input");
    for(var i=1; i<inputs.length; i++){
        inputs[i].onclick = function (ev) {
            for(var j=1; j<inputs.length; j++){
                if(inputs[j].checked){
                    flag = false;
                }
            }
            if(flag)
                inputs[0].checked = true;
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