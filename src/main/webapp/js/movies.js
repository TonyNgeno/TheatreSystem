
(function(){
    TheatreSysLib.showGrid.call({
        dataUrl: 'movies/list',
        gridStyle: 'datatable table table-hover table-center mb-0',
        componentId: 'movies',
        gridColumns:[{
            header: 'Id',
            dataIndex: 'id'
        },{
            header: 'Movie Name',
            dataIndex: 'movieName'
        },{
            header: 'Description',
            dataIndex: 'description'
        },{
            header: 'Movie Length(in mins)',
            dataIndex: 'movieLength'
        }],
        gridButtons: [{
            linkToJsp:'./addmovie.jsp',
            label: 'Add a Movie',
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