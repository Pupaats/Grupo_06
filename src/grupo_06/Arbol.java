package grupo_06;

public class Arbol {
    //Este arbol es de tipo Binary Search Tree (BST), podiamos haber hecho un AVL pero como soy tonto elegi este.
   
    private NodoArbol raiz; 
    // Constructor del arbol vacio
    public Arbol(){
        this.raiz = null;
    }
    
    // Inserta recursivamente un reclamo usando su codigo unico con complejidad O(log n) promedio
    public void insertar(Reclamos reclamo){
        raiz = insertarRecursivo(raiz, reclamo);
    }
    private NodoArbol insertarRecursivo(NodoArbol nodo, Reclamos reclamo){
        //Caso base : que no tenga nada
        if (nodo == null){
            return new NodoArbol(reclamo);
        }
        //Aqui obtiene el valor numerico y compara
        char[] charNuevo = reclamo.getCodigoUnico().toCharArray();
        char[] charActual = nodo.reclamo.getCodigoUnico().toCharArray();
        
        if(comparandoAscii(charNuevo, charActual)){
            nodo.izquierda = insertarRecursivo(nodo.izquierda, reclamo);
            //Si es menor inserta en el lado izquierdo
        } else if (comparandoAscii(charActual, charNuevo)){
            nodo.derecha = insertarRecursivo(nodo.derecha, reclamo);
            //Si es mayor inserta en el derecho
        } else {
            System.out.println("Ya existe este reclamo" + reclamo.getCodigoUnico());
            // Si ninguno es menor que el otro asume que son iguales
            // y como ya hay uno igual entonces no permite que se repita

        }
        return nodo;
        }
    
    // Buscar tambien es O(log n) en caso promedio
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
    
    // Este tiene una complejidad dependiendo de la altura del arbol algo asi como O(h) si h fuera la altura. no estoy seguro si es lo mismo que O(N)
    private NodoArbol encontrarMinimo(NodoArbol nodo){
    while(nodo.izquierda != null){
        nodo = nodo.izquierda;
    }   
    return nodo;
    }
    
    // El metodo eliminar tiene una complejidad de O(log n) promedio, al igual que los otros 2
    public void eliminar (String codigoUnico){
        raiz = eliminarRecursivo(raiz, codigoUnico);
    }
    private NodoArbol eliminarRecursivo(NodoArbol nodo, String codigoUnico){
        if(nodo == null) return null; // Por si no encuentra
        //aqui convierte los Strings en arrays de caracteres para comparar con el Ascii
        char[] charCodigoBuscado = codigoUnico.toCharArray();
        char[]  charCodigoNodo = nodo.reclamo.getCodigoUnico().toCharArray();
        //luego evalua la direccion usando el Ascii
        if(comparandoAscii(charCodigoBuscado, charCodigoNodo)){
            // si es menor va para la izquierda
            nodo.izquierda = eliminarRecursivo(nodo.izquierda, codigoUnico);
        } else if (comparandoAscii(charCodigoNodo, charCodigoBuscado)){
            // si el codigo del nodo es mayor, va para la derecha
            nodo.derecha = eliminarRecursivo(nodo.derecha, codigoUnico);
        } else {
            //casos de eliminacion, caso 1 nodo hoja
            if(nodo.izquierda == null && nodo.derecha == null){
                return null; 
            }
            // caso 2 , solo tiene hijo derecho
            if(nodo.izquierda == null){
                return nodo.derecha;
            } 
            // caso 2.5, solo tiene hijo izquierdo
            if(nodo.derecha == null){
                return nodo.izquierda;
            }
            // caso 3, tiene 2 hijos , busca el siguiente en inorden 
            NodoArbol siguiente = encontrarMinimo(nodo.derecha);
            nodo.reclamo = siguiente.reclamo; // aqui copia los datos del siguiente
            //Elimina el siguiente del arbol derecho
            nodo.derecha = eliminarRecursivo(nodo.derecha,
                    siguiente.reclamo.getCodigoUnico());
        }
        return nodo;
    }
    
    //Ordenamientos InOrden, PreOrden, PostOrden, estos tienen todos una complejidad de O(n)
    //Ya que pasara por todos los nodos si o si
    
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
    
    
    public int calcularAltura(){
        return alturaRec(raiz);
    }
    
    private int alturaRec(NodoArbol nodo){
        if (nodo == null) return 0; // Si es nulo el arbol esta vacio
        int altIzq = alturaRec(nodo.izquierda); // Llama recursivamente para obtener la altura de la izquierda
        int altDer = alturaRec(nodo.derecha); // Lo mismo pero a la derecha
        return 1 + Math.max(altIzq, altDer); // La altura del nodo actual es 1, mas la altura de sus subarboles
    }
    
    
    public boolean estaVacio(){
        return raiz == null;
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
        while(valor1 == valor2 &&
                posicion < cadena.length && posicion < comparando.length){
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