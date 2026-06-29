package grupo_06;
// Eliminamos el codigoAscii ya que nos daba problemas  :(
// Usamos trim() y equalsIgnoreCase() para evitar errores por espacios invisibles
public class Arbol {
   
    private NodoArbol raiz;
    public Arbol(){
        this.raiz = null;
    }
    
    // Inserta un reclamo usando su nivel de prioridad
    public void insertar(Reclamos reclamo){
        raiz = insertarRecursivo(raiz, reclamo);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, Reclamos reclamo){
        //Caso base que no tenga nada
        if (nodo == null){
            return new NodoArbol(reclamo);
        }
        // Si el nuevo reclamo tiene mayor prioridad se va a la izquierda
        if(reclamo.getNivelPrioridad() > nodo.reclamo.getNivelPrioridad()){
            nodo.izquierda = insertarRecursivo(nodo.izquierda, reclamo);
        } 
        // Si tiene menor o igual prioridad, va a la derecha permite prioridades repetidas
        else {
            nodo.derecha = insertarRecursivo(nodo.derecha, reclamo);
        }
        
        return nodo;
    }
    //Buscar ahora busca usando prioridad
    public Reclamos buscar(int nivelPrioridad) {
        return buscarRecursivo(raiz, nivelPrioridad);
    }

    private Reclamos buscarRecursivo(NodoArbol nodo, int nivelPrioridad) {
        if (nodo == null) {
            return null;
        }
        
        if (nivelPrioridad == nodo.reclamo.getNivelPrioridad()) {
            return nodo.reclamo;
        }
        
        //si la prioridad que busca es mayor, está a la izquierda
        if (nivelPrioridad > nodo.reclamo.getNivelPrioridad()) {
            return buscarRecursivo(nodo.izquierda, nivelPrioridad);
        } else {
            return buscarRecursivo(nodo.derecha, nivelPrioridad);
        }
    }
        
    public void eliminar(int nivelPrioridad) {
        raiz = eliminarRecursivo(raiz, nivelPrioridad);
    }

    private NodoArbol eliminarRecursivo(NodoArbol nodo, int nivelPrioridad) {
        if (nodo == null) { // Revisa si esta vacio
            return null;
        }
        // aqui lo de siempre si es mayor a la izquierda si es menor a la derecha
        if (nivelPrioridad > nodo.reclamo.getNivelPrioridad()) {
            nodo.izquierda = eliminarRecursivo(nodo.izquierda, nivelPrioridad);
        } else if (nivelPrioridad < nodo.reclamo.getNivelPrioridad()) {
            nodo.derecha = eliminarRecursivo(nodo.derecha, nivelPrioridad);
        } else {
            //encontramos el nodo con la prioridad
            
            //caso 1 Nodo hoja o con un solo hijo
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }

            //caso 2 nodo con dos hijos 
            nodo.reclamo = encontrarMaximo(nodo.derecha);
            nodo.derecha = eliminarRecursivo(nodo.derecha, nodo.reclamo.getNivelPrioridad());
        }
        return nodo;
    }
    //busca el que tenga mayor prioridad
    private Reclamos encontrarMaximo(NodoArbol nodo) {
        NodoArbol actual = nodo;
        //vamos a la izquierda porque ahí están los mayores
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual.reclamo;
    }
    //este busca el que tenga prioridad mas baja. aunque no se use ahi lo dejo porsiaca saiuhgufiaf
    private Reclamos encontrarMinimo(NodoArbol nodo) {
        NodoArbol actual = nodo;
        //nos vamos a la derecha porque ahí están los menores
        while (actual.derecha != null) {
            actual = actual.derecha;
        }
        return actual.reclamo;
    }
    
    /*Ordenamientos InOrden, PreOrden, PostOrden*/
    
    //Inorden = Izquierda, Raiz, Derecha
    private void InOrden(NodoArbol nodo){
        if(nodo != null){ 
            InOrden(nodo.getIzquierda());
            // Imprimimos mostrando la prioridad para que se note el orden
            System.out.println("Prioridad: " + nodo.reclamo.getNivelPrioridad() + " | Código: " + nodo.reclamo.getCodigoUnico() + " | Nombre: " + nodo.reclamo.getNombre());
            InOrden(nodo.getDerecha());
        }
    }
    public void MostrarInOrden(){
        if(raiz==null){ 
            System.out.println("No existen reclamos");
        } else {
            InOrden(raiz);
        }
    }
    
    //PreOrden = Raiz, Izquierda, Derecha
    private void PreOrden(NodoArbol nodo){
        if(nodo!=null){ 
            System.out.println("Prioridad: " + nodo.reclamo.getNivelPrioridad() + " | Código: " + nodo.reclamo.getCodigoUnico());
            PreOrden(nodo.getIzquierda());
            PreOrden(nodo.getDerecha());
        }
    }
    public void MostrarPreOrden(){
        if(raiz==null){
            System.out.println("No existen reclamos");
        } else {
            PreOrden(raiz);
        }
    }
    
    //PostOrden = Izquierda, Derecha, Raiz
    private void PostOrden(NodoArbol nodo){
        if(nodo!=null){
            PostOrden(nodo.getIzquierda());
            PostOrden(nodo.getDerecha());
            System.out.println("Prioridad: " + nodo.reclamo.getNivelPrioridad() + " | Código: " + nodo.reclamo.getCodigoUnico());
        }
    }
    public void MostrarPostOrden(){
        if(raiz==null){
            System.out.println("No existen reclamos");
        } else {
            PostOrden(raiz);
        }
    }
    
    //Extras o Auxiliares
    
    public int calcularAltura(){
        return alturaRec(raiz);
    }
    
    private int alturaRec(NodoArbol nodo){
        if (nodo == null) return 0; // Si es nulo el arbol esta vacio
        int altIzq = alturaRec(nodo.izquierda); // Llama recursivamente
        int altDer = alturaRec(nodo.derecha); 
        return 1 + Math.max(altIzq, altDer); 
    }
    
    public boolean estaVacio(){
        return raiz == null;
    }
}