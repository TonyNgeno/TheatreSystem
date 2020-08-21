(function(){
    TheatreJsLib.showGrid.call({
        dataUrl: 'rooms',
        gridStyle: 'rooms',
        componentId: 'room',
        gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'Room No',
            dataIndex: 'roomNo'
        }],
        gridButtons: [{
            label: 'Add Room',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'room-addButton',
        },{
            label: 'Edit Room',
            cssClass: 'editButton',
            handler: 'editButton',
            id: 'room-editButton',
        },{
            label: 'Delete Room',
            cssClass: 'deleteButton',
            handler: 'deleteButton',
            id: 'room-deleteButton',
        }],
        formField: [{
            label: 'Room Name',
            name: 'name',
            type: 'text',
            id: 'room-name'
        },{
            label: 'Room No',
            name: 'address',
            type: 'text',
            id: 'room-no'
        }]
    });
})();