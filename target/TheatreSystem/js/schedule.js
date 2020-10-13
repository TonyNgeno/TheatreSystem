(function(){
    TheatreSysLib.showGrid.call({
        dataUrl: 'schedules/list',
        gridStyle: 'datatable table table-hover table-center mb-0',
        componentId: 'schedules',
        gridColumns:[{
            header: 'Id',
            dataIndex: 'id'
        },{
            header: 'Movie Name',
            dataIndex: 'movieName'
        },{
            header: 'Start Time',
            dataIndex: 'startTime'
        },
        {
            header: 'End Time',
            dataIndex: 'endTime'
        },{
            header: 'Date Showing',
            dataIndex: 'date'
        },{
            header: 'Cinema Room',
            dataIndex: 'cinemaRoomName'
        }],
        gridButtons: [{
            linkToJsp:'./addschedule.jsp',
            label: 'Add a Schedule',
            cssClass: 'btn btn-info add-new',
            fontAwesomeIcon: 'fa-plus',
            handler: 'addButton',
            id: 'movie-addButton',
        }],
        formField: [{
            label: 'Enter Movie Name',
            name: 'movieName',
            type: 'text',
            id: 'movieName'
        },{
            label: 'Enter Description',
            name: 'description',
            type: 'text',
            id: 'description'
        },{
            label: 'Movie Length',
            name: 'movieLength',
            type: 'text',
            id: 'movieLength'
        }]
    });
})();