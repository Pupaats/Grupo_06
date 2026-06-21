package grupo_06;

public class ListaReclamos {
    private NodoLista iniciolista;
    private NodoLista finallista;

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
   
    public Reclamos buscarReclamo(String codigoUnico){
        NodoLista NodoActual = iniciolista;
 
        while(NodoActual != null){
            if(NodoActual.reclamo.getCodigoUnico().equals(codigoUnico)){
                return NodoActual.reclamo;
            }
            NodoActual = NodoActual.siguiente;
        }
        System.out.println("No se encontró ningún reclamo con el codigo: " + codigoUnico);
        return null;
    }
 
   public boolean eliminarReclamo(int codigoUnico){
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
                return true;
            }
            NodoAnterior = NodoActual;
            NodoActual = NodoActual.siguiente;
        }
 
        System.out.println("Hubo un error, hay coincidencias con el código: " + codigoUnico);
        return false;
    }
 
    public int obtenerTamaño(){
        NodoLista NodoActual = iniciolista;
        int Tamañodelalista = 0;
 
        while(NodoActual != null){
            Tamañodelalista++;
            NodoActual = NodoActual.siguiente;
        }
        return Tamañodelalista;
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