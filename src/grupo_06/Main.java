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
        
        Reclamos test1 = new Reclamos(123, "Señor Wylie", "12.345.678-9", "Salud", "Esta enfermo", "21/06/2026", "Pendiente", 2, "01/07/2026");
        arbolito.insertar(test1);
        colita.InsertarEnlaCola(test1);
        listita.registrarReclamo(test1);
        pilita.registrarCambios(test1.getCodigoUnico(), "Reclamo registrado");
        
        Reclamos test2 = new Reclamos(666, "Juan Fuentes", "98.765.432-1", "Seguridad", "Lo asaltaron :v", "21/06/2026", "Pendiente", 1, "01/07/2026");
        arbolito.insertar(test2);
        colita.InsertarEnlaCola(test2);
        listita.registrarReclamo(test2);        
        pilita.registrarCambios(test2.getCodigoUnico(), "Reclamo registrado");
        
        int opcion;
        
        do{
            
            System.out.println("\n==== Gestión de reclamos de San Rafael ====");
            System.out.println("1. Registrar reclamo");
            System.out.println("2. Modificar reclamo ");
            System.out.println("3. Eliminar reclamo");
            System.out.println("4. Consultar reclamos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEnteroSeguro(sc);
        
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
        if(arbolito.estaVacio()){
            System.out.println("[Error] No existen reclamos.");
            return;
        }        
        
        System.out.println("\n== Menu Eliminar =="); 
        System.out.println("Reclamos activos: ");
        listita.mostrarCodigos();        
        
        System.out.println("Ingrese el código del reclamo que quiere eliminar: ");
        int codigoReclamo = leerEnteroSeguro(sc);
        
        Reclamos reclamo = listita.buscarReclamo(codigoReclamo);
        
        if(reclamo == null){
            System.out.println("[Error] No existe un reclamo con ese código.");
            return;
        }
        
        System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] eliminado.");
        arbolito.eliminar(reclamo.getNivelPrioridad());
        listita.eliminarReclamo(codigoReclamo);              
       
    }
    
    private static void modificarReclamo(Scanner sc, Arbol arbolito, ListaReclamos listita){
        if(arbolito.estaVacio()){
            System.out.println("[Error] No existen reclamos.");
            return;
        }
        
        System.out.println("\n== Menú Modificar ==");            
        System.out.println("Reclamos activos: ");
        listita.mostrarCodigos();       
        
        System.out.println("Ingrese el código del reclamo que quiere modificar: ");
        int codigoReclamo = leerEnteroSeguro(sc);
        Reclamos reclamo = listita.buscarReclamo(codigoReclamo);
              
            if(reclamo == null){
                System.out.println("[Error] No existe un reclamo con ese código.");
                return;
        }
        

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
        int opcionModificar = leerEnteroSeguro(sc);

        switch(opcionModificar){
            case 1:
                // codigo unico
                System.out.println("Codigo único actual: " + reclamo.getCodigoUnico());
                System.out.println("Ingrese nuevo codigo único: ");
                reclamo.setCodigoUnico(leerEnteroSeguro(sc));    
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                break;
            case 2:
                System.out.println("Nombre actual: " + reclamo.getNombre());
                System.out.println("Ingrese nuevo nombre: ");
                reclamo.setNombre(sc.nextLine());    
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                break;
            case 3:
                System.out.println("RUT actual: " + reclamo.getRut());
                System.out.println("Ingrese nuevo RUT: ");
                reclamo.setRut(sc.nextLine());             
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                break;
            case 4:
                System.out.println("Tipo de reclamo actual: " + reclamo.getTipoReclamo());
                System.out.println("Ingrese nuevo tipo de reclamo: ");
                reclamo.setTipoReclamo(sc.nextLine());   
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                break;
            case 5:
                System.out.println("Descripción actual: " + reclamo.getDescripcion());
                System.out.println("Ingrese nueva descripción: ");
                reclamo.setDescripcion(sc.nextLine());    
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                break;
            case 6:
                System.out.println("Estado actual: " + reclamo.getEstadoReclamo());
                System.out.println("Ingrese nuevo estado: ");
                reclamo.setEstadoReclamo(sc.nextLine());           
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                break;
            case 7:
                System.out.println("Nivel de prioridad actual: " + reclamo.getNivelPrioridad());
                System.out.println("Ingrese nuevo nivel de prioridad: ");
                reclamo.setNivelPrioridad(leerEnteroSeguro(sc));                  
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                break;
            case 8:
                System.out.println("Fecha límite actual: " + reclamo.getFechaLimite());
                System.out.println("Ingrese nueva fecha límite: ");
                reclamo.setFechaLimite(sc.nextLine());                
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                break;
            case 9:
                System.out.println("Regresando...");
                break;
            default:
                System.out.println("[Error] Opción inválida.");
        }
        
    }
    
    private static void consultarReclamos(Scanner sc, Arbol arbolito, ListaReclamos listita, Pila pilita){
        if(arbolito.estaVacio()){
            System.out.println("[Error] No existen reclamos.");
            return;
        }


        System.out.println("\n== Menú Consultas ==");
        System.out.println("1. Mostrar todos");
        System.out.println("2. Mostrar el último ingresado");            
        System.out.println("3. Ordenar por vencimiento (FALTA)");
        System.out.println("4. Ordenar por tipo (FALTA)");
        System.out.println("5. Buscar reclamo con código");
        System.out.println("6. Mostrar reclamos próximos a vencer");
        System.out.println("7. Regresar");
        System.out.println("Seleccione una opción: ");
        int opcionConsultar = leerEnteroSeguro(sc);

        switch(opcionConsultar){
            case 1: 
                listita.consultarReclamos();
                break;
            case 2:
                pilita.VerCambioMasReciente();
                break;
            case 3:
                // ORDENAR POR VENCIMIENTO (HACER)
                break;
            case 4:
                // ORDENAR POR TIPO (HACER)
                break;
            case 5:
                System.out.println("Ingrese el código del reclamo: ");
                Reclamos reclamo = listita.buscarReclamo(leerEnteroSeguro(sc));
                if(reclamo != null){
                    reclamo.mostrarInfo();
                }else{
                    System.out.println("[Error] No existe un reclamo con ese código.");
                }
                break;               
            case 6:
                System.out.println("Ingrese la fecha de hoy (DD/MM/AAAA): ");
                String fechaHoy = sc.nextLine();
                listita.MostrarReclamosAvencer(fechaHoy);
                break;
            case 7:
                System.out.println("Regresando...");
                break;
            default:
                System.out.println("[Error] Opción inválida.");
        }
      
    }
    
    
    private static void registrarReclamo(Scanner sc, Arbol arbolito, Cola colita, ListaReclamos listita, Pila pilita){
        System.out.println("\n== Menú Registrar ==");

        System.out.println("Ingrese código único: ");
        int codigoUnico = leerEnteroSeguro(sc);
        
        // Verificar que el código sea único
        while(arbolito.buscar(codigoUnico) != null){
            System.out.println("[Error] Ese código ya existe. Ingrese uno distinto: ");
            codigoUnico = leerEnteroSeguro(sc);
        }
            
        System.out.println("Ingrese nombre del ciudadano: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese RUT del ciudadano: ");
        String rut = sc.nextLine();

        System.out.println("Ingrese tipo de reclamo: ");
        String tipoReclamo = sc.nextLine();

        System.out.println("Ingrese una descripción: ");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese fecha de ingreso (DD/MM/AAAA): ");
        String fechaIngreso = sc.nextLine();
        
        System.out.println("Ingrese estado del reclamo: ");
        String estadoReclamo = sc.nextLine();

        System.out.println("Ingrese nivel de prioridad: ");
        int nivelPrioridad = leerEnteroSeguro(sc);
        
        System.out.println("Ingrese fecha límite (DD/MM/AAAA): ");
        String fechaLimite = sc.nextLine();
        
        
        Reclamos nuevoReclamo = new Reclamos(codigoUnico, nombre, rut, tipoReclamo, descripcion,
                fechaIngreso, estadoReclamo, nivelPrioridad, fechaLimite);
        
        arbolito.insertar(nuevoReclamo);
        colita.InsertarEnlaCola(nuevoReclamo);
        listita.registrarReclamo(nuevoReclamo);
        pilita.registrarCambios(nuevoReclamo.getCodigoUnico(), "Reclamo registrado");
    }
    
    //metodo para que no se rompa si ingresan strings en los ints
    private static int leerEnteroSeguro(Scanner sc) {
    while (true) {
        try {
            //lee la entrada como String y la convierte a int
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("[Error] Entrada inválida. Ingrese únicamente números enteros: ");
        }
    }
}
    
}