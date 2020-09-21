package com.theatre.ws.soap;

import com.theatre.bean.MovieBeanI;
import com.theatre.logic.interfaces.MovieLogicI;
import com.theatre.model.Message;
import com.theatre.model.Movie;
import com.theatre.model.UserDetail;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "MovieSoapApi")
@Stateless()
public class MovieSoapApi {

    @EJB
    private MovieBeanI movieBean;

    @EJB
    private MovieLogicI movieLogic;

    @WebMethod(operationName = "listAllMovies")
    public List<Movie> listMovies(){
        return movieBean.list();
    }

    @WebMethod(operationName = "getMovieByName")
    public Movie getMovieByName(@WebParam(name = "name") String name) {
        return movieLogic.getMovieByName(name);
    }

    @WebMethod(operationName = "addMovie")
    public Message addMovie(@WebParam(name = "movie") Movie movie){
        return movieLogic.addMovie(movie);
    }

    @WebMethod(operationName = "removeMovieById")
    public Message removeMovieById(@WebParam(name = "id") int id){
        return movieLogic.removeMovieByid(id);
    }

    @WebMethod(operationName = "saveMovie")
    public String saveMovie(Movie movie){
        try {
            movieBean.add(movie);
        } catch (Exception ex) {

            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";

        }
        return "{\"SUCCESS\":\"OK\"}";
    }

}
