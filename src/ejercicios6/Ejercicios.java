/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios6;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Ejercicios {
    static void guardar(String nombre_archivo, ArrayList<Pelicula> peliculas)
    {
        try
        {
            PrintWriter peli = new PrintWriter(nombre_archivo);

            for(Pelicula p : peliculas)
            {
                peli.println(p.nombre + " " + p.descripcion+" "+ p.duracion);
            }

            peli.close();
        }catch (Exception e)
        {
            System.out.println("Ocurrio un error al guardar.");
        }
    }


    static ArrayList<Pelicula> abrir(String nombre_archivo)
    {
       ArrayList<Pelicula> pelic= new ArrayList<>(); 
        try
        {
            Scanner scanner = new Scanner(new File(nombre_archivo));
            while(scanner.hasNext())
            {
                String nombre = scanner.next();
                String descripcion = scanner.next();
                int duracion = scanner.nextInt();
                pelic.add (new Pelicula(nombre, descripcion, duracion) );
            }
            scanner.close();
        }catch(Exception e)
        {
            System.out.print("Error al leer el archivo");
        }
        return pelic;
    }
}