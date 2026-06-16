package grupo_06;

//La idea es que al lado izquierdo vayan los reclamos con codigo menor y la der los mayores

public class NodoArbol {
    Reclamos reclamo;
    NodoArbol izquierda;
    NodoArbol derecha;

    
    //Constructor para crear una hoja
    public NodoArbol(Reclamos reclamo){
        this.reclamo = reclamo;
        this.izquierda = null;
        this.derecha = null;
    }
}
