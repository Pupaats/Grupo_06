package grupo_06;

public class ListaReclamos {
    private NodoLista iniciolista;
    private NodoLista finallista;
    private int contador;

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
        contador ++;
    }
    
    
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
   
    public int obtenerTamaño(){
        return contador; // cambio para que sea o(1)
    }
    
    // Extra
    public void mostrarCodigos(){
        NodoLista NodoActual = iniciolista;
        
        while(NodoActual != null){
            System.out.println("Codigo: [" + NodoActual.reclamo.getCodigoUnico() + "]");
            NodoActual = NodoActual.siguiente;
        }
        
    }    
    
}