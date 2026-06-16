package grupo_06;

public class Arbol {
    private NodoArbol raiz;
    
    public Arbol(){
        this.raiz = null;
    }
    
    private NodoArbol insertarRecursivo(NodoArbol nodo, Reclamos reclamo){
        //Caso base : que no tenga nada
        if (nodo == null){
            return new NodoArbol(reclamo);
        }
        //Aqui obtiene el valor numerico y compara
        int codigoNuevo = reclamo.getCodigoUnico();
        int codigoActual = nodo.reclamo.getCodigoUnico();
        
        if(codigoNuevo < codigoActual){
            nodo.izquierda = insertarRecursivo(nodo.izquierda, reclamo);
            //Si es menor inserta en el lado izquierdo
        } else if (codigoNuevo > codigoActual){
            nodo.derecha = insertarRecursivo(nodo.derecha, reclamo);
            //Si es mayor inserta en el derecho
        } else {
            System.out.println("Ya existe este reclamo" + reclamo.getCodigoUnico());
            //Si ya habia un reclamo, no permite que se repita
        }
        return nodo;
    }
}
