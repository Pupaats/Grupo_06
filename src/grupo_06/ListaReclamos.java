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
    /*
    TODO: hacer la bsuqueda binaria, me la hago mañana que ahora toy cansado
    */
    
    /* No se porque esta esto aca xd
    public void consultarReclamos(){
        NodoLista NodoActual = iniciolista;
        
        if(NodoActual == null){
            System.out.println("Aún no hay reclamos registrados.");
        }else{
            System.out.println("Reclamos registrados: ");
            while(NodoActual != null){
                NodoActual.reclamo.mostrarInfo();
                NodoActual = NodoActual.siguiente;
            }
        }        
    }
   */
    
    
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
    
}