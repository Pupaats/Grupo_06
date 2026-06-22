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
        
        Reclamos test1 = new Reclamos("123", "Señor Wylie", "12.345.678-9", "Salud", "Esta enfermo", "21/06/2026", "Pendiente", 1, "01/07/2026");
        arbolito.insertar(test1);
        colita.InsertarEnlaCola(test1);
        listita.registrarReclamo(test1);
        
        Reclamos test2 = new Reclamos("666", "Juan Fuentes", "98.765.432-1", "Seguridad", "Lo asaltaron :v", "21/06/2026", "Pendiente", 9, "01/07/2026");
        arbolito.insertar(test2);
        colita.InsertarEnlaCola(test2);
        listita.registrarReclamo(test2);        
        
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
                    modificarReclamo(sc, listita);
                    break;
                   
                case 3:
                    // Eliminar reclamos
                    eliminarReclamo(sc, listita);
                    break;
                    
                case 4:
                    // Consultar reclamos
                    consultarReclamos(sc, listita);
                    break;
                    
                case 5:
                    System.out.println("Finalizando sistema...");
                    break;
                    
                default:
                    System.out.println("[Error] Opción inválida.");
           
            }
        }while(opcion != 5);
             
    }
    

    private static void eliminarReclamo(Scanner sc, ListaReclamos listita){
        System.out.println("\n-> Eliminando reclamo"); 
        
        System.out.println("Reclamos activos: ");
        listita.mostrarCodigos();        
        
        
        System.out.println("Ingrese el código del reclamo que quiere eliminar: ");
        String codigoReclamo = sc.nextLine();
        
        Reclamos reclamo = listita.buscarReclamo(codigoReclamo);
        System.out.println("Reclamo ["+ reclamo.getCodigoUnico() + "] eliminado.");
        
        listita.eliminarReclamo(codigoReclamo);
        
    }
    
    private static void modificarReclamo(Scanner sc, ListaReclamos listita){
        System.out.println("\n-> Modificando reclamo"); 
        
        System.out.println("Reclamos activos: ");
        listita.mostrarCodigos();       
        
        System.out.println("Ingrese el código del reclamo que quiere modificar: ");
        String codigoReclamo = sc.nextLine();
        
        Reclamos reclamo = listita.buscarReclamo(codigoReclamo);
        
        int opcionModificar;
        do{
            
            System.out.println("Seleccione lo que desea modificar: ");            
            System.out.println("1. Código único");
            System.out.println("2. Nombre del ciudadano");
            System.out.println("3. RUT del ciudadano");
            System.out.println("4. Tipo de reclamo");
            System.out.println("5. Descripción");
            System.out.println("6. Estado del reclamo");
            System.out.println("7. Nivel de prioridad");
            System.out.println("8. Fecha límite");
            System.out.println("9. Regresar");
            opcionModificar = sc.nextInt();
            
            sc.nextLine(); // limpiar
            
            switch(opcionModificar){
                case 1:
                    // codigo unico
                    System.out.println("Codigo único actual: " + reclamo.getCodigoUnico());
                    System.out.println("Ingrese nuevo codigo único: ");
                    reclamo.setCodigoUnico(sc.nextLine());    
                    System.out.println("Reclamo actualizado correctamente.");
                    break;
                case 2:
                    System.out.println("Nombre actual: " + reclamo.getNombre());
                    System.out.println("Ingrese nuevo nombre: ");
                    reclamo.setNombre(sc.nextLine());    
                    System.out.println("Reclamo actualizado correctamente.");
                    break;
                case 3:
                    System.out.println("RUT actual: " + reclamo.getRut());
                    System.out.println("Ingrese nuevo RUT: ");
                    reclamo.setRut(sc.nextLine());             
                    System.out.println("Reclamo actualizado correctamente.");
                    break;
                case 4:
                    System.out.println("Tipo de reclamo actual: " + reclamo.getTipoReclamo());
                    System.out.println("Ingrese nuevo tipo de reclamo: ");
                    reclamo.setTipoReclamo(sc.nextLine());   
                    System.out.println("Reclamo actualizado correctamente.");
                    break;
                case 5:
                    System.out.println("Descripción actual: " + reclamo.getDescripcion());
                    System.out.println("Ingrese nueva descripción: ");
                    reclamo.setDescripcion(sc.nextLine());    
                    System.out.println("Reclamo actualizado correctamente.");
                    break;
                case 6:
                    System.out.println("Estado actual: " + reclamo.getEstadoReclamo());
                    System.out.println("Ingrese nuevo estado: ");
                    reclamo.setEstadoReclamo(sc.nextLine());           
                    System.out.println("Reclamo actualizado correctamente.");
                    break;
                case 7:
                    System.out.println("Nivel de prioridad actual: " + reclamo.getNivelPrioridad());
                    System.out.println("Ingrese nuevo nivel de prioridad: ");
                    reclamo.setNivelPrioridad(sc.nextInt());                  
                    System.out.println("Reclamo actualizado correctamente.");
                    break;
                case 8:
                    System.out.println("Fecha límite actual: " + reclamo.getFechaLimite());
                    System.out.println("Ingrese nueva fecha límite: ");
                    reclamo.setFechaLimite(sc.nextLine());                
                    System.out.println("Reclamo actualizado correctamente.");
                    break;
                case 9:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("[Error] Opción inválida.");
            }
            
        }while(opcionModificar != 9);
        
    }
    
    private static void consultarReclamos(Scanner sc, ListaReclamos listita){
        System.out.println("\n-> Consultando reclamos");
        
        System.out.println("Reclamos activos: ");
        listita.mostrarCodigos();
        
        
        System.out.println("Ingrese el código del reclamo que quiere consultar: ");
        String codigoReclamo = sc.nextLine();
        
        Reclamos reclamo = listita.buscarReclamo(codigoReclamo);
        
        if(reclamo != null){
            reclamo.mostrarInfo();
        }else{
            System.out.println("[Error] No existe un reclamo con el código " + codigoReclamo + ".");
        }
        
    
    }
    
    
    private static void registrarReclamo(Scanner sc, Arbol arbolito, Cola colita, ListaReclamos listita){
        System.out.println("\n-> Registrando reclamo");
        
        System.out.println("Código único: ");
        String codigoUnico = sc.nextLine();
        
        // Verificar que el código sea único
        while(listita.buscarReclamo(codigoUnico) != null){
            System.out.println("[Error] Ese código ya existe. Ingrese uno distinto: ");
            codigoUnico = sc.nextLine();
        }
            

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