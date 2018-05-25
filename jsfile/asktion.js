function showContent(node) {
    var oContent = document.getElementById("content");
    if(node.value === "yes"){
        oContent.className = "open";
    }
    else
        oContent.className = "close";
}

function showResult() {
    var flag = false;
    var oLiNodes = document.getElementsByName("no1");
    var oRes1 = document.getElementById("res_1");
    var oRes2 = document.getElementById("res_2");
    var oResSpan = document.getElementById("pompt");
    var res;
    for(var i=0; i<oLiNodes.length; i++){
        if(oLiNodes[i].checked === true){
            res = oLiNodes[i].value;
            flag = true;
            break;
        }
    }
    if(!flag){
        oResSpan.className = "open";
        return;
    }
    if(res>=1 && res<=3){
        oResSpan.className = "close";
        oRes1.className = "open";
        oRes2.className = "close";
    }
    else{
        oResSpan.className = "close";
        oRes1.className = "close";
        oRes2.className = "open";
    }
}