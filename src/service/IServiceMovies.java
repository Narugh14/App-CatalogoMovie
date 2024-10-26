package service;

import dominio.Movie;

public interface IServiceMovies {
    public void listarPelicula();

    public void addMovie(Movie movie);

    public void searchMovie(Movie movie);
}
