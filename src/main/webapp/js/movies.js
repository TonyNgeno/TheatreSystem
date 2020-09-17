(function(){
    SystechSkulJsLib.showGrid.call({
        dataUrl: 'addMovie',
        gridStyle: 'customers',
        componentId: 'movie',
        gridColumns:[{
            header: 'Movie Name',
            dataIndex: 'movieName'
        },{
            header: 'Description',
            dataIndex: 'description'
        },{
            header: 'Description',
            dataIndex: 'description'
        }],
        gridButtons: [{
            label: 'Add Movie',
            cssClass: 'action-btn',
            fontAwesomeIcon: 'fa-plus',
            handler: 'addButton',
            id: 'movie-addButton',
        }],
        formField: [{
            label: 'Movie Name',
            name: 'movieName',
            type: 'text',
            id: 'movie-id',
            storeModel: {
                url: 'organization',
                dataBinding: {
                    display : 'name',
                    id: 'id'
                }
            }
        },{
            label: 'Description Name',
            name: 'description',
            type: 'text',
            id: 'faculty-description'
        }]
    });
})();