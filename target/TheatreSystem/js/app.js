var TheatreJsLib = TheatreJsLib || {};

TheatreJsLib.showTable = function(){
    var me = this;

    var tableContent = `<table id="rooms"><tr><th>Name</th><th>Room No</th></tr>`;
    me.data.forEach(row => {
        tableContent += `<tr><td>${row.name}</td><td>${row.roomNo}</td></tr>`;
    });
    tableContent += `</table>`;

    document.getElementById('content').innerHTML = tableContent;

}

TheatreJsLib.loadData = function(){
    var me = this;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState == XMLHttpRequest.DONE){
            if (xhr.status == 200){
               TheatreJsLib.data = eval('(' + xhr.responseText + ')');
               TheatreJsLib.showTable();
            }
        }
    }

    xhr.open('get', me.dataUrl, true);
    xhr.send();

}