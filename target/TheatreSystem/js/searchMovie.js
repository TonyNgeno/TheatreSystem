document.getElementById("search-movie-button").addEventListener('click', event => {
    event.preventDefault();
    console.log("button clicked")

    var searchValue = document.getElementById('search-movie-input').value;

    console.log("search value ="+searchValue)

    TheatreSysLib.showGrid.call({
        dataUrl:'movies/findMovieByName/'+searchValue,
        gridStyle:'datatable table table-hover table-center mb-0',
        dataHref:'',
        gridColumns:[{
            header:'Id',
            dataIndex:'id'
        },{
            header:'Movie name',
            dataIndex:'movieName'
        },{
            header:'Description',
            dataIndex:'description'
        },{
            header: 'Movie Length(in mins)',
            dataIndex: 'movieLength'
        }]
    });

    $(document).ready(function($) {
        $(".table-row").click(function() {
            window.document.location = $(this).data("href");
        });
    });



});



