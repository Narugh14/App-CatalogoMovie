package Presentation;

import dominio.Movie;
import service.IServiceMovies;
import service.serviceMovieArchive;
import service.serviceMovieList;

import java.util.Scanner;

public class CatalogoMovieApp {
    public static void main(String[] args) {
        boolean salir = false;
        Scanner sca = new Scanner(System.in);

        //Se utiliza la interfaces con una lista temporal
        //IServiceMovies serviceMovies = new serviceMovieList();

        //Se utiliza la interface con un archivo guardado en la pc
        IServiceMovies serviceMovies = new serviceMovieArchive();

        while (!salir){
            try{
                viewMenu();
                salir = opcionSelect(sca, serviceMovies);


            }catch (Exception e){
                System.out.println("El error fue: "+ e.getMessage());
            }

            System.out.println();
        }//fin while


    }

    private static boolean opcionSelect(Scanner sca,
                                        IServiceMovies serviceMovies) {
        int opcion = Integer.parseInt(sca.nextLine());
        boolean salir = false;
        switch (opcion){
            case 1 ->{//Agregar pelicula
                System.out.print("Introduce el nombre de la pelicula: ");
                String nameMovie = sca.nextLine();
                serviceMovies.addMovie(new Movie(nameMovie));
            }
            case 2 ->{//Mostrar pelicula
                serviceMovies.listarPelicula();}

            case 3 ->{//Buscar pelicula en la lista
                System.out.println("Introduce el nombre de la pelicula");
                String nameMovieSearch = sca.nextLine();
                serviceMovies.searchMovie(new Movie(nameMovieSearch));
            }
            case 4 -> {
                System.out.println("Saliendo...");
                salir = true;
            }
            default -> System.out.println("Opcion incorrecta: "+ opcion);
        }
        return salir;
    }

    private static void viewMenu() {
        System.out.print("""
                ***Catalogo de pelicula
                1. Agregar pelicula
                2. Mostrar lista de pelicula
                3. Buscar pelicula en la lista
                4. Salir
                Elige una opcion: 
                """);
    }
}