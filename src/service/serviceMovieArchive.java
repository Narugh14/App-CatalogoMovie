package service;

import dominio.Movie;

import javax.xml.namespace.QName;
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
            String linea;
            linea = buff.readLine();
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
        boolean anexar = false;
        File archivo = new File(NAME_ARCHIVE);

        try{
            //Revisamos el archivo
            anexar = archivo.exists();
            PrintWriter Escribir = new PrintWriter(new FileWriter(archivo, anexar));
            Escribir.println(movie);
            Escribir.close();
            System.out.println("Se agrego el archivo: "+ movie);

        }catch (Exception e){
            System.out.println("Ocurrio un error: "+ e.getMessage());
        }
    }

    @Override
    public void searchMovie(Movie movie) {
        File archivo = new File(NAME_ARCHIVE);
        try{
            BufferedReader buff = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = buff.readLine();
            int indice = 1;
            boolean encontrar = false;
            String movieSearch = movie.getName();

            while(linea != null){
                if(movieSearch != null && movieSearch.equalsIgnoreCase(linea)){
                    encontrar = true;
                    break;
                }
                linea = buff.readLine();
                indice++;
            }//fin while
            if(encontrar)
                System.out.println("Pelicula esta en id: " + indice );
            else
                System.out.println("No se encontro la pelicula: " + movie.getName());
            //Cerrar archivo
            buff.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error: "+ e.getMessage());
        }
    }
}
