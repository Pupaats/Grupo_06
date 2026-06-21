package grupo_06;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        // La linea de arriba permite que en el output se vean las tildes
        
        Arbol arbolito = new Arbol();
        Cola colita = new Cola();
        ListaReclamos listita = new ListaReclamos();
        
        
        int opcion;
        
        do{
            
            System.out.println("=== Gestión de reclamos de San Rafael ==");
            System.out.println("1. Registrar reclamo");
            System.out.println("2. Modificar reclamo ");
            System.out.println("3. Eliminar reclamo");
            System.out.println("4. Consultar reclamos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
        
            switch(opcion){
                case 1:
                    registrarReclamo(sc, arbolito, colita, listita);
                    break;
                    
                case 2:
                    // Modificar reclamo
                    break;
                    
                default:
                    System.out.println("Error: Opción inválida.");
            
            }
        }while(opcion != 5);
             
    }

    private static void registrarReclamo(Scanner sc, Arbol arbolito, Cola colita, ListaReclamos listita){
        System.out.println("\n-> Registrando reclamo");
        
        System.out.println("Código único: ");
        String codigoUnico = sc.nextLine();

        System.out.println("Nombre del ciudadano: ");
        String nombre = sc.nextLine();

        System.out.println("RUT del ciudadano: ");
        String rut = sc.nextLine();

        System.out.println("Tipo de reclamo: ");
        String tipoReclamo = sc.nextLine();

        System.out.println("Descripción: ");
        String descripcion = sc.nextLine();

        System.out.println("Estado del reclamo: ");
        String estadoReclamo = sc.nextLine();

        System.out.println("Nivel de prioridad: ");
        int nivelPrioridad = sc.nextInt();

        System.out.println("Fecha limite: ");
        String fechaLimite = sc.nextLine();
        
        sc.nextLine();
        
        Reclamos nuevoReclamo = new Reclamos(codigoUnico, nombre, rut, tipoReclamo, descripcion, fechaLimite,
                estadoReclamo, nivelPrioridad, fechaLimite);
        
        arbolito.insertar(nuevoReclamo);
        colita.InsertarEnlaCola(nuevoReclamo);
        listita.registrarReclamo(nuevoReclamo);
        
    }
    
    
}