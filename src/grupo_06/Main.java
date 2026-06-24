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
        Pila pilita = new Pila();
        
        Reclamos test1 = new Reclamos("123", "Señor Wylie", "12.345.678-9", "Salud", "Esta enfermo", "21/06/2026", "Pendiente", 2, "01/07/2026");
        arbolito.insertar(test1);
        colita.InsertarEnlaCola(test1);
        listita.registrarReclamo(test1);
        pilita.InsertarCambioReclamo(test1);
        
        Reclamos test2 = new Reclamos("666", "Juan Fuentes", "98.765.432-1", "Seguridad", "Lo asaltaron :v", "21/06/2026", "Pendiente", 1, "01/07/2026");
        arbolito.insertar(test2);
        colita.InsertarEnlaCola(test2);
        listita.registrarReclamo(test2);        
        pilita.InsertarCambioReclamo(test2);
        
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
                    registrarReclamo(sc, arbolito, colita, listita, pilita);
                    break;
                    
                case 2:
                    // Modificar reclamo
                    modificarReclamo(sc, arbolito, listita);
                    break;
                   
                case 3:
                    // Eliminar reclamos
                    eliminarReclamo(sc, arbolito, listita);
                    break;
                    
                case 4:
                    // Consultar reclamos
                    consultarReclamos(sc, arbolito, listita, pilita);
                    break;
                    
                case 5:
                    System.out.println("Finalizando sistema...");
                    break;
                    
                default:
                    System.out.println("[Error] Opción inválida.");
           
            }
        }while(opcion != 5);
             
    }
    

    private static void eliminarReclamo(Scanner sc, Arbol arbolito, ListaReclamos listita){
        System.out.println("\n-> Eliminando reclamo"); 
        
        System.out.println("Reclamos activos: ");
        listita.mostrarCodigos();        
        
        
        System.out.println("Ingrese el código del reclamo que quiere eliminar: ");
        String codigoReclamo = sc.nextLine();
        
        Reclamos reclamo = arbolito.buscar(codigoReclamo);
        
        if(reclamo != null){
        System.out.println("Reclamo ["+ reclamo.getCodigoUnico() + "] eliminado.");
        arbolito.eliminar(codigoReclamo);
        listita.eliminarReclamo(codigoReclamo);            
        }else{
            System.out.println("[Error] No existe un reclamo con ese código.");
        }
  
        
    }
    
    private static void modificarReclamo(Scanner sc, Arbol arbolito, ListaReclamos listita){
        System.out.println("\n-> Modificando reclamo"); 
        
        System.out.println("Reclamos activos: ");
        listita.mostrarCodigos();       
        
        System.out.println("Ingrese el código del reclamo que quiere modificar: ");
        String codigoReclamo = sc.nextLine();
        
        Reclamos reclamo = arbolito.buscar(codigoReclamo);
        
        int opcionModificar;
        do{
            
            System.out.println("\n== Menú Modificar ==");            
            System.out.println("1. Código único");
            System.out.println("2. Nombre del ciudadano");
            System.out.println("3. RUT del ciudadano");
            System.out.println("4. Tipo de reclamo");
            System.out.println("5. Descripción");
            System.out.println("6. Estado del reclamo");
            System.out.println("7. Nivel de prioridad");
            System.out.println("8. Fecha límite");
            System.out.println("9. Regresar");
            System.out.println("Seleccione una opción: ");
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
    
    // FALTA ADAPTARLO
    private static void consultarReclamos(Scanner sc, Arbol arbolito, ListaReclamos listita, Pila pilita){
        // PRIMERO VER SI NO HAY RECLAMOS PARA  CONSULTAR
        
        
        int opcionConsultar;
        
        do{
            System.out.println("\n== Menú Consultas ==");
            System.out.println("1. Mostrar todos");
            System.out.println("2. Mostrar el último ingresado");            
            System.out.println("3. Ordenar por vencimiento");
            System.out.println("4. Ordenar por tipo");
            System.out.println("5. Buscar reclamo con código");
            System.out.println("6. Regresar");
            System.out.println("Seleccione una opción: ");
            opcionConsultar = sc.nextInt();
            sc.nextLine();
            
            switch(opcionConsultar){
                case 1: 
                    listita.consultarReclamos();
                    break;
                case 2:
                    if(!pilita.PilaVacia()){
                        pilita.verCambioMasReciente();
                    }else{
                        System.out.println("Pila vacia texto");
                    }
                    break;
                case 3:
                    // ORDENAR POR VENCIMIENTO (HACER)
                    break;
                case 4:
                    // ORDENAR POR TIPO (HACER)
                    break;
                case 5:
                    System.out.println("Ingrese el código del reclamo: ");
                    Reclamos reclamo = arbolito.buscar(sc.nextLine());
                    if(reclamo != null){
                        reclamo.mostrarInfo();
                    }else{
                        System.out.println("[Error] No existe un reclamo con ese código.");
                    }
                    break;               
                case 6:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("[Error] Opción inválida.");
            }
            
        }while(opcionConsultar != 6);
    
    }
    
    
    private static void registrarReclamo(Scanner sc, Arbol arbolito, Cola colita, ListaReclamos listita, Pila pilita){
        System.out.println("\n== Menú Registrar ==");

        System.out.println("Código único: ");
        String codigoUnico = sc.nextLine();
        
        // Verificar que el código sea único
        while(arbolito.buscar(codigoUnico) != null){
            System.out.println("[Error] Ese código ya existe. Ingrese uno distinto: ");
            codigoUnico = sc.nextLine();
        }
            
        System.out.println("Ingrese nombre del ciudadano: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese RUT del ciudadano: ");
        String rut = sc.nextLine();

        System.out.println("Ingrese el tipo de reclamo: ");
        String tipoReclamo = sc.nextLine();

        System.out.println("Ingrese una descripción: ");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese fecha de ingreso (DD/MM/AAAA): ");
        String fechaIngreso = sc.nextLine();
        
        System.out.println("Ingrese estado del reclamo: ");
        String estadoReclamo = sc.nextLine();

        System.out.println("Ingrese nivel de prioridad: ");
        int nivelPrioridad = sc.nextInt();
        
        System.out.println("Ingrese fecha límite (DD/MM/AAAA): ");
        String fechaLimite = sc.nextLine();
        
        sc.nextLine();
        
        Reclamos nuevoReclamo = new Reclamos(codigoUnico, nombre, rut, tipoReclamo, descripcion,
                fechaIngreso, estadoReclamo, nivelPrioridad, fechaLimite);
        
        arbolito.insertar(nuevoReclamo);
        colita.InsertarEnlaCola(nuevoReclamo);
        listita.registrarReclamo(nuevoReclamo);
        pilita.InsertarCambioReclamo(nuevoReclamo);
    }
    
    
}