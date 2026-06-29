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
        pilita.registrarCambios(test1.getCodigoUnico(), "Se registró el reclamo");
        
        Reclamos test2 = new Reclamos(666, "Juan Fuentes", "98.765.432-1", "Seguridad", "Lo asaltaron :v", "21/06/2026", "Pendiente", 1, "01/07/2026");
        arbolito.insertar(test2);
        colita.InsertarEnlaCola(test2);
        listita.registrarReclamo(test2);        
        pilita.registrarCambios(test2.getCodigoUnico(), "Se registró el reclamo");
        
        Reclamos test3 = new Reclamos(712, "Pedro Pro", "98.765.432-1", "Otro", "Descripcion pepe", "21/06/2026", "Pendiente", 3, "12/08/2026");
        arbolito.insertar(test3);
        colita.InsertarEnlaCola(test3);
        listita.registrarReclamo(test3);        
        pilita.registrarCambios(test3.getCodigoUnico(), "Se registró el reclamo");       
        
        int opcion;
        
        do{
            
            System.out.println("\n==== Gestión de reclamos de San Rafael ====");
            System.out.println("1. Registrar reclamo");
            System.out.println("2. Modificar reclamo ");
            System.out.println("3. Eliminar reclamo");
            System.out.println("4. Consultar reclamos");
            System.out.println("5. Mostrar historial de cambios");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEnteroSeguro(sc);
        
            switch(opcion){
                case 1:
                    registrarReclamo(sc, arbolito, colita, listita, pilita);
                    break;
                    
                case 2:
                    // Modificar reclamo
                    modificarReclamo(sc, arbolito, listita, pilita);
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
                    pilita.MostrarHistorialDeCambios();
                    break;                    
                case 6:
                    System.out.println("Finalizando sistema...");
                    break;
                    
                default:
                    System.out.println("[Error] Opción inválida.");
           
            }
        }while(opcion != 6);
             
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
        arbolito.eliminar(codigoReclamo);
        listita.eliminarReclamo(codigoReclamo);              
       
    }
    
    private static void modificarReclamo(Scanner sc, Arbol arbolito, ListaReclamos listita, Pila pilita){
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
        System.out.println("Seleccione una opción: ");
        int opcionModificar = leerEnteroSeguro(sc);

        switch(opcionModificar){
            case 1:
                // codigo unico
                System.out.println("Codigo único actual: " + reclamo.getCodigoUnico());
                System.out.println("Ingrese nuevo codigo único: ");
                int nuevoCodigo = leerEnteroSeguro(sc);
                reclamo.setCodigoUnico(nuevoCodigo);
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                pilita.registrarCambios(reclamo.getCodigoUnico(), "Se modificó el codigo único a:  " + nuevoCodigo);
                break;
            case 2:
                System.out.println("Nombre actual: " + reclamo.getNombre());
                System.out.println("Ingrese nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                reclamo.setNombre(nuevoNombre);
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                pilita.registrarCambios(reclamo.getCodigoUnico(), "Se modificó el nombre a: " + nuevoNombre);
                break;
            case 3:
                System.out.println("RUT actual: " + reclamo.getRut());
                System.out.println("Ingrese nuevo RUT: ");
                String nuevoRut = sc.nextLine();
                reclamo.setRut(nuevoRut);             
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                pilita.registrarCambios(reclamo.getCodigoUnico(), "Se modificó el rut a: " + nuevoRut);
                break;
            case 4:
                // CAMBIAR
                System.out.println("Tipo de reclamo actual: " + reclamo.getTipoReclamo());
                System.out.println("Ingrese nuevo tipo de reclamo: ");
                String nuevoTipo = sc.nextLine();
                reclamo.setTipoReclamo(nuevoTipo);   
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                pilita.registrarCambios(reclamo.getCodigoUnico(), "Se modificó el tipo de reclamo a: " + nuevoTipo);
                break;
            case 5:
                System.out.println("Descripción actual: " + reclamo.getDescripcion());
                System.out.println("Ingrese nueva descripción: ");
                String nuevaDescripcion = sc.nextLine();
                reclamo.setDescripcion(nuevaDescripcion);    
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                pilita.registrarCambios(reclamo.getCodigoUnico(), "Se modificó la descripción a: " + nuevaDescripcion);
                break;
            case 6:
                // CAMBIAR
                System.out.println("Estado actual: " + reclamo.getEstadoReclamo());
                System.out.println("Ingrese nuevo estado: ");
                String nuevoEstado = sc.nextLine();
                reclamo.setEstadoReclamo(nuevoEstado);           
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                pilita.registrarCambios(reclamo.getCodigoUnico(), "Se modificó el estado a: " + nuevoEstado);
                break;
            case 7:
                System.out.println("Nivel de prioridad actual: " + reclamo.getNivelPrioridad());
                System.out.println("Ingrese nuevo nivel de prioridad: ");
                int nuevaPrioridad = sc.nextInt();
                sc.nextLine();
                reclamo.setNivelPrioridad(nuevaPrioridad);                  
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                pilita.registrarCambios(reclamo.getCodigoUnico(), "Se modificó el nivel de prioridad a: " + nuevaPrioridad);
                break;
            case 8:
                System.out.println("Fecha límite actual: " + reclamo.getFechaLimite());
                System.out.println("Ingrese nueva fecha límite: ");
                String nuevaFechaLimite = sc.nextLine(); 
                reclamo.setFechaLimite(nuevaFechaLimite);                
                System.out.println("-> Reclamo ["+ reclamo.getCodigoUnico() + "] modificado con éxito.");
                pilita.registrarCambios(reclamo.getCodigoUnico(), "Se modificó la fecha límite a: " + nuevaFechaLimite);
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
        System.out.println("1. Mostrar todos (Ordenado por prioridad)");
        System.out.println("2. Mostrar reclamos próximos a vencer");
        System.out.println("3. Filtrar por tipo de reclamo");
        System.out.println("4. Buscar reclamo por código único");
        System.out.println("5. Regresar");
        System.out.println("Seleccione una opción: ");
        int opcionConsultar = leerEnteroSeguro(sc);

        switch(opcionConsultar){
            case 1: 
                listita.consultarReclamos();
                break;
            case 2:
                System.out.println("Ingrese la fecha de hoy (DD/MM/AAAA): ");
                String fechaHoy = sc.nextLine();
                listita.MostrarReclamosAvencer(fechaHoy);
                break;
            case 3:
                buscarPorTipo(sc, listita);
                break;
            case 4:
                System.out.println("Ingrese el código del reclamo: ");
                Reclamos reclamo = listita.buscarReclamo(leerEnteroSeguro(sc));
                if(reclamo != null){
                    reclamo.mostrarInfo();
                }else{
                    System.out.println("[Error] No existe un reclamo con ese código.");
                }
                break;               
            default:
                System.out.println("[Error] Opción inválida.");
        }
      
    }

    private static void buscarPorTipo(Scanner sc, ListaReclamos listita){

        System.out.println("Tipos de reclamo a consultar: ");
        System.out.println("1. Salud\n2. Seguridad\n3. Educación\n4. Emergencia\n5. Otro\nSeleccione tipo de reclamo: ");        
        
        int tipoFiltrado = leerEnteroSeguro(sc);
        
        if(tipoFiltrado < 1 || tipoFiltrado > 5){
            System.out.println("[Error] Opción inválida."); 
            return;
        }
        
        String tipoMostrado;
        
        if(tipoFiltrado == 1){
        tipoMostrado = "Salud";
        }else if(tipoFiltrado == 2){
        tipoMostrado = "Seguridad";
        }else if(tipoFiltrado == 3){
        tipoMostrado = "Educación";
        }else if(tipoFiltrado == 4){
        tipoMostrado = "Emergencia";
        }else{
        tipoMostrado = "Otro";
        }        
        
        System.out.println("-> Mostrando los reclamos de tipo [" + tipoMostrado + "]");
        listita.mostrarPorTipoReclamo(tipoMostrado);
        
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

        System.out.println("Tipos de reclamo: ");
        System.out.println("1. Salud\n2. Seguridad\n3. Educación\n4. Emergencia\n5. Otro\nSeleccione tipo de reclamo: ");
        
        int tipoElegido = leerEnteroSeguro(sc);
        
        if(tipoElegido < 1 || tipoElegido > 5){
            System.out.println("[Error] Opción inválida."); 
            return;
        }
        
        String tipoReclamo;
        
        if(tipoElegido == 1){
        tipoReclamo = "Salud";
        }else if(tipoElegido == 2){
        tipoReclamo = "Seguridad";
        }else if(tipoElegido == 3){
        tipoReclamo = "Educación";
        }else if(tipoElegido == 4){
        tipoReclamo = "Emergencia";
        }else{
        tipoReclamo = "Otro";
        }
        

        System.out.println("Ingrese una descripción: ");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese fecha de ingreso (DD/MM/AAAA): ");
        String fechaIngreso = sc.nextLine();
        listita.MostrarReclamosAvencer(fechaIngreso);        
        
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