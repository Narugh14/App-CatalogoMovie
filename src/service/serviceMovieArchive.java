package service;

import dominio.Movie;

import java.io.*;

public class serviceMovieArchive implements IServiceMovies{

    private final String NAME_ARCHIVE = "archiveMovie.txt";

    public serviceMovieArchive(){
        File archivo = new File(NAME_ARCHIVE);

        try{
            //Si ya existe el archivo, No se vuelve a crear
            if(archivo.exists()){
                System.out.println("Archivo existente");
            }else {
                //Si no existe, creamos uno nuevo
                PrintWriter exit = new PrintWriter(new FileWriter(archivo));
                exit.close();
                System.out.println("Se a creado el archivo");
            }

        }catch (Exception e){
            System.out.println("Ocurrio un error en el archivo: "
                    + e.getMessage());
        }
    }

    @Override
    public void listarPelicula() {
        File archivo = new File(NAME_ARCHIVE);
        try{
            System.out.println("Lista de archivo");
            BufferedReader buff = new BufferedReader(new FileReader(archivo));
            //Leemos el archivo
            String linea = buff.readLine();
            //Leemos todas las lineas
            while(linea != null){
                Movie movie = new Movie(linea);
                System.out.println(movie);
                linea = buff.readLine();
            }//fin while
            buff.close();

        } catch (IOException e) {
            System.out.println("Ocurrior un error: "+ e.getMessage());
        }
    }

    @Override
    public void addMovie(Movie movie) {

    }

    @Override
    public void searchMovie(Movie movie) {

    }
}
