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
    
    // Buscar revisa todo el árbol porque está ordenado por prioridad, no por código
    public Reclamos buscar(String codigoUnico) {
        return buscarRecursivo(raiz, codigoUnico);
    }

    private Reclamos buscarRecursivo(NodoArbol nodo, String codigoUnico) {
        if (nodo == null) {
            return null;
        }
        if (nodo.reclamo.getCodigoUnico().trim().equalsIgnoreCase(codigoUnico.trim())) {
            return nodo.getReclamo();
        }
        
        // Busca por la izquierda
        Reclamos encontradoIzq = buscarRecursivo(nodo.izquierda, codigoUnico);
        if (encontradoIzq != null) {
            return encontradoIzq;
        }
        
        // Si no estaba en la izquierda, busca en la derecha
        return buscarRecursivo(nodo.derecha, codigoUnico);
    }
    
    private NodoArbol encontrarReemplazo(NodoArbol nodo){
        // Va todo a la izquierda para encontrar el valor de reemplazo
        while(nodo.izquierda != null){
            nodo = nodo.izquierda;
        }   
        return nodo;
    }
    
    // Eliminar busca por todo el árbol y luego borra
    public void eliminar (String codigoUnico){
        raiz = eliminarRecursivo(raiz, codigoUnico);
    }

    private NodoArbol eliminarRecursivo(NodoArbol nodo, String codigoUnico){
        if(nodo == null) return null; // Por si no encuentra
        if(nodo.reclamo.getCodigoUnico().trim().equalsIgnoreCase(codigoUnico.trim())){
            // caso 1 nodo hoja
            if(nodo.izquierda == null && nodo.derecha == null){
                return null; 
            }
            // caso 2 que solo tiene hijo derecho
            if(nodo.izquierda == null){
                return nodo.derecha;
            } 
            // caso 3 cuando solo tiene hijo izquierdo
            if(nodo.derecha == null){
                return nodo.izquierda;
            }
            // caso 4 si tiene 2 hijos
            NodoArbol siguiente = encontrarReemplazo(nodo.derecha);
            nodo.reclamo = siguiente.reclamo; // copia los datos
            // Elimina el duplicado
            nodo.derecha = eliminarRecursivo(nodo.derecha, siguiente.reclamo.getCodigoUnico());
            return nodo;
        }
        
        // Si no es este nodo, seguimos buscando en ambos lados
        nodo.izquierda = eliminarRecursivo(nodo.izquierda, codigoUnico);
        nodo.derecha = eliminarRecursivo(nodo.derecha, codigoUnico);
        
        return nodo;
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