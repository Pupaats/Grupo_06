package grupo_06;

public class ListaReclamos {
    private NodoLista iniciolista;
    private NodoLista finallista;
    private int cantidadReclamos = 0;

    public ListaReclamos() {
        this.iniciolista = null;
        this.finallista = null;
    }
    
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
    
    /*
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

            // Ordenamos el arreglo según el nivel de prioridad utilizando Insertion
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