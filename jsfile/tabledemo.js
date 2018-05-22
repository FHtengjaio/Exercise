var name;
onload = function (ev) {
    var oTabNode = document.getElementById("tabid");
    var oTrNodes = oTabNode.rows;
    var oTdNodes;
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
