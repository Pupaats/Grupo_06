package grupo_06;

public class Arbol {
    private NodoArbol raiz;
    
    public Arbol(){
        this.raiz = null;
    }
    public void insertar(Reclamos reclamo){
        raiz = insertarRecursivo(raiz, reclamo);
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
    

    public Reclamos buscar(String Nombre){
        if(raiz == null){
            System.out.println("No existe el reclamo");
            //Si la raíz es nula, el árbol está vacío y no hay nada que buscar
        }
        NodoArbol actual = raiz; //Nodo auxiliar para empezar a recorrer el árbol desde la raiz
        while(actual != null){ //loop para navegar el árbol mientras queden nodos por revisar
            if(actual.getReclamo().getNombre().equals(Nombre)){
                return actual.getReclamo();
            //Si el nombre buscado es exactamente igual al del nodo actual retorna correctamente
            }
            char[] aux = actual.reclamo.getNombre().toCharArray(); //Si no es igual preparamos la conversion a char
            // Si comparandoAscii devuelve true, significa que el nombre buscado es menor
            if(comparandoAscii(Nombre.toCharArray(), aux)){
                actual = actual.getIzquierda();// Baja por el subárbol izquierdo
            } else {
                actual = actual.getDerecha();// Baja por el subárbol derecho
            }
        }
        System.out.println("No se encontro el reclamo");
        return null;
    }
    
    //Ordenamientos InOrden, PreOrden, PostOrden
    
    private void InOrden(NodoArbol nodo){
        if(nodo != null){ 
            InOrden(nodo.getIzquierda());
            System.out.println(nodo);
            InOrden(nodo.getDerecha());
        }
    }
    public void MostrarInOrden(){
        if(raiz==null){ // Si es nulo, no hay elementos 
            System.out.println("No existen reclamos");
        } else {
            InOrden(raiz);
        }
    }
    
    
    private void PreOrden(NodoArbol nodo){
        if(nodo!=null){ 
            System.out.println(nodo);
            PreOrden(nodo.getDerecha());
            PreOrden(nodo.getIzquierda());
        }
    }
    public void MostrarPreOrden(){
        if(raiz==null){ // Si es nulo, no hay elementos  x2
            System.out.println("No existen reclamos");
        } else {
            PreOrden(raiz);
        }
    }
    
    
    private void PostOrden(NodoArbol nodo){
        if(nodo!=null){
            PostOrden(nodo.getIzquierda());
            PostOrden(nodo.getDerecha());
            System.out.println(nodo);
        }
    }
    public void MostrarPostOrden(){
        if(raiz==null){  // Si es nulo, no hay elementos  x3
            System.out.println("No existen reclamos");
        } else {
            PostOrden(raiz);
        }
    }
    
    
    
    public static boolean comparandoAscii(char [] cadena, char[] comparando){
        //Esto sirve para comparar 2 caracteres basandose en su valor Ascii
        //Elige la que va primero en orden alfabetico
        int valor1 = 0;
        int valor2 = 0;
        int posicion = 0;
        /*Avanza palabra por palabra, si ambas son iguales sigue avanzando
        si no, compara directamente o cuando llegue al final de la palabra
        para evitar un desbordamiento
        */
        while(valor1 == valor2 && posicion < cadena.length && posicion < comparando.length){
            valor1 = (int)cadena[posicion]; //convierte el caracter de la palabra a Ascii
            valor2 = (int)comparando[posicion];
            posicion++; //Avanzar a la siguiente posicion
        }
        //Aqui evalua, la palabra con menor valor numerico va a la izquierda
        // y la con mayor valor numerico a la derecha.
        if(valor1 < valor2){
            return true;
        }else{
            return false;
        }
    }
}
