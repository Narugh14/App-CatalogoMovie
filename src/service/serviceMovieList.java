package service;

import dominio.Movie;

import java.util.ArrayList;
import java.util.List;

public class serviceMovieList implements IServiceMovies{
    private final List<Movie> movieslist;

    public serviceMovieList(){
        this.movieslist = new ArrayList<>();
    }

    @Override
    public void listarPelicula() {
        System.out.println("Listado de pelicula son:");
        movieslist.forEach(System.out::println);
    }

    @Override
    public void addMovie(Movie movie) {
        movieslist.add(movie);
    }

    @Override
    public void searchMovie(Movie movie) {
        //Regresa id
        int id = movieslist.indexOf(movie);
        if(id == (-1))
            System.out.println("La pelicula no existe en el catalogo");
        else
            System.out.println("El id es: "+ id);
    }

    public static void main(String[] args) {
        //Objetos de tipo movie
        Movie movie1 = new Movie("Superman");
        Movie movie2 = new Movie("Supergirl");

        //Creamos el servicio
        //Patron de diseño service
        IServiceMovies iServiceMovies = new serviceMovieList();
        //Agregamos la pelicula de prueba
        iServiceMovies.addMovie(movie1);
        //Para mostrar toda la lista de peliculas
        iServiceMovies.listarPelicula();
        //mostramos el id de la pelicula buscada
        iServiceMovies.searchMovie(movie2);
    }
}
