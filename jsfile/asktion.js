function showContent(node) {
    var oContent = document.getElementById("content");
    if(node.value === "yes"){
        oContent.className = "open";
    }
    else
        oContent.className = "close";
}