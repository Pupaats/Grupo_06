package grupo_06;


// Falta el eliminar reclamo y la busqueda binaria, lo vemos despues
public class ListaReclamos {
    private NodoLista iniciolista;
    private NodoLista finallista;
    private int cantidadReclamos;

    public ListaReclamos(){
        this.iniciolista = null;
        this.finallista = null;
        this.cantidadReclamos = 0;
    }
    
    //creo que tiene una complejidad de 0(1), ya que inserta al final con el puntero
    public void registrarReclamo(Reclamos reclamo){
        NodoLista nuevoNodo = new NodoLista(reclamo);
        
        if(iniciolista == null){
            iniciolista = nuevoNodo;
            finallista = nuevoNodo;
        }else{
            finallista.siguiente = nuevoNodo;
            finallista = nuevoNodo;
        }
        cantidadReclamos ++;
    }
    //Busqueda Sequencial
    /* cuando usariamos la busqueda secuencial ? cuando la lista no esta ordenada o cuando se busca
    una sola vez, cuando no requiere ordenamiento previo o cuando las listas son pequeñas
    tiene de complejidad O(n) porque en el peor de los casos se tendria que recorrer la lista completa  
    */
    
    public Reclamos buscarReclamo(String codigoUnico){
        NodoLista actual = iniciolista;
        while(actual != null){
            if(actual.reclamo.getCodigoUnico().equals(codigoUnico)){
                return actual.reclamo;
            }
            actual = actual.siguiente;
        }
        return null; // no lo encontro
    } 
    
//Busqueda Binaria
    public Reclamos busquedaBinaria(String codigoUnico) {
        if (iniciolista == null) {
            System.out.println("No hay reclamos.");
            return null;
        }

        Reclamos[] arreglo = new Reclamos[cantidadReclamos];
        NodoLista nodoActual = iniciolista;

        for(int i = 0; i < cantidadReclamos; i++){
            arreglo[i] = nodoActual.reclamo;
            nodoActual = nodoActual.siguiente;
        }

        // Ordenamos el arreglo por código único con Bubble Sort O(n^2)
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j].getCodigoUnico().compareTo(arreglo[j+1].getCodigoUnico()) > 0) {
                    Reclamos temp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temp;
                }
            }
        }

        // 3. Ahora sí la busqueda binaria O(log n) - descarta mitad a mitad
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int comparacion = arreglo[medio].getCodigoUnico().compareTo(codigoUnico);

            if (comparacion == 0) {
                System.out.println("  [Búsqueda Binaria] Reclamo encontrado en posición " + medio + " del arreglo ordenado.");
                return arreglo[medio];
            } else if (comparacion < 0) {
                izquierda = medio + 1; // el buscado está en la mitad derecha
            } else {
                derecha = medio - 1;   // el buscado está en la mitad izquierda
            }
        }

        System.out.println("No se encontró reclamo con código: " + codigoUnico);
        return null;
    }
    
    
   public boolean eliminarReclamo(String codigoUnico){
        NodoLista NodoActual = iniciolista;
        NodoLista NodoAnterior = null;
 
        while(NodoActual != null){
            if(NodoActual.reclamo.getCodigoUnico().equals(codigoUnico)){
                if(NodoAnterior == null && NodoActual == finallista){
                    iniciolista = null;
                    finallista = null;
                }else if(NodoAnterior == null){
                    iniciolista = NodoActual.siguiente;
                }else if(NodoActual == finallista){
                    NodoAnterior.siguiente = null;
                    finallista = NodoAnterior;
                }else{
                    NodoAnterior.siguiente = NodoActual.siguiente;
                }
                cantidadReclamos--;
                return true;
            }
            NodoAnterior = NodoActual;
            NodoActual = NodoActual.siguiente;
        }
 
        System.out.println("Hubo un error, hay coincidencias con el código: " + codigoUnico);
        return false;
    }    
    
    //Muestra todos los reclamos ordenados por prioridad usando el InsertionSort
    // tiene de complejidad el O(n^2) por el ordenamiento cuadratico
    public void consultarReclamos(){
        
        if(iniciolista == null){
            System.out.println("Aún no hay reclamos registrados.");
        }else{
            NodoLista NodoActual = iniciolista;

            Reclamos[] arreglo = new Reclamos[cantidadReclamos];

            // Agregamos en cada indice un reclamo
            for(int i=0; i<cantidadReclamos; i++){
                arreglo[i] = NodoActual.reclamo;
                NodoActual = NodoActual.siguiente;
            }
 
            // Ordenamos el arreglo según el nivel de prioridad utilizando Insertion O(n^2) en el peor caso
            // y O(n) si ya esta ordenado
            int n = arreglo.length;
            for(int i=1; i<n; i++){
                Reclamos key = arreglo[i];
                int j = i-1;

                while(j >= 0 && arreglo[j].getNivelPrioridad() > key.getNivelPrioridad()){
                    arreglo[j+1] = arreglo[j];
                    j--;
                }
                arreglo[j+1] = key;
            }     

            System.out.println("Reclamos registrados: ");
            for(Reclamos reclamo : arreglo){
                reclamo.mostrarInfo();
            }
        }
    }
    
    public int obtenerTamaño(){
        return cantidadReclamos; // cambio para que sea o(1)
    }
    
    // Extra ---> Eliminar luego
    public void mostrarCodigos(){
        NodoLista NodoActual = iniciolista;
        
        while(NodoActual != null){
            System.out.println("Codigo: [" + NodoActual.reclamo.getCodigoUnico() + "]");
            NodoActual = NodoActual.siguiente;
        }
        
    }    
        
    public void mostrarPorTipoReclamo(String tipo){
        NodoLista NodoActual = iniciolista;
        boolean encontrado = false;
        
        while(NodoActual != null){
            if(NodoActual.reclamo.getTipoReclamo().equalsIgnoreCase(tipo)){
                NodoActual.reclamo.mostrarInfo();
                encontrado = true;
            }
            NodoActual = NodoActual.siguiente;
        }
        
        // Si no se encontraron reclamos
        if(encontrado == false){
            System.out.println("No existen reclamos de este tipo.");
        }
    }
    
    // Nuevo de Aaron
     public void MostrarReclamosAvencer(String fechaActual){
        if(iniciolista==null){
            return;
        }

        int diaslimitereclamo=7;

        String[] divisor_mes_dia=fechaActual.split("/");
        int diaactual=Integer.parseInt(divisor_mes_dia[0]);
        int mesactual=Integer.parseInt(divisor_mes_dia[1]);

        NodoLista NodoActual=iniciolista;
         while(NodoActual != null){
            Reclamos reclamoActual = NodoActual.reclamo;
            
            // Se separa la fecha que el usuario ingresa (si se respeta el formato solicitado XD) con split y trabajar con ellos como en datos aparte
            String[] almacenadordedatos = reclamoActual.getFechaLimite().split("/");
            int diasmaximos= Integer.parseInt(almacenadordedatos[0]);
            int mesmaximo = Integer.parseInt(almacenadordedatos[1]);
            
            int diasRestantes;
            if(mesmaximo == mesactual){
                diasRestantes = diasmaximos - diaactual;
            }else{
                /*
                    Basicamente esto es un caso en donde si la fecha limite cae en el mes posterior: se adcionan los dias del mes actual mas los del posterior
                 */
                diasRestantes = (30 - diaactual) + diasmaximos;
            }
            
            //si diasrestantes es menor a 0, se imprime el dia eliminando el signo
            if(diasRestantes <=diaslimitereclamo){
                reclamoActual.mostrarInfo();
                
                if(diasRestantes < 0){
                    System.out.println("El reclamo ha vencido hace: " + Math.abs(diasRestantes));
                }else if(diasRestantes == 0){
                    System.out.println("URGENTE, este reclamo finaliza el dia de hoy. ATENDER PRONTO");
                }else{
                    System.out.println("El reclamo vence en los siguientes dias: "+diasRestantes);
                }
            }
            
            NodoActual = NodoActual.siguiente;
        }


    }

    
}