(function(){
    TheatreSysLib.showGrid.call({
        dataUrl: 'roomapi/list',
        gridStyle: 'datatable table table-hover table-center mb-0',
        componentId: 'rooms',
        gridColumns:[{
            header: 'Id',
            dataIndex: 'id'
        },{
            header: 'Room Name',
            dataIndex: 'name'
        },{
            header: 'No of Seats',
            dataIndex: 'noOfSeats'
        },{
            header: 'Room Picture',
            dataIndex: 'roomPic'
        }],
        gridButtons: [{
            linkToJsp:'./addroom.jsp',
            label: 'Add a Room',
            cssClass: 'btn btn-info add-new',
            fontAwesomeIcon: 'fa-plus',
            handler: 'addButton',
            id: 'movie-addButton',
        }],
        formField: [{
            label: 'Enter Room Name',
            name: 'name',
            type: 'text',
            id: 'name'
        },{
            label: 'Enter No Of Seats',
            name: 'noOfSeats',
            type: 'text',
            id: 'noOfSeats'
        }]
    });
})();