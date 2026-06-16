package grupo_06;


//Esta clase la vamos a usar para la listareclamos y la colareclamos y creo que tambien para el historial
// cada nodo almacena un reclamo y referencia al siguiente nodo
public class NodoLista {
    Reclamos reclamo;
    NodoLista siguiente;

    public NodoLista(Reclamos reclamo){
        this.reclamo = reclamo;
        this.siguiente = null;
    }
}
