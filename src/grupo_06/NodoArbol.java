package grupo_06;

//La idea es que al lado izquierdo vayan los reclamos con codigo menor y la der los mayores.

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
    //Getters
    public Reclamos getReclamo() {
        return reclamo;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }
    
    //Setters
    public void setReclamo(Reclamos reclamo) {
        this.reclamo = reclamo;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
    
    @Override
    public String toString() {
        return reclamo.getNombre();
    }    
    
    
}