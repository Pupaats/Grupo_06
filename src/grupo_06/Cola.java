package grupo_06;

public class Cola {
    private NodoLista elfrente;
    private NodoLista elfinal;
    private int tamanio;


    public Cola(){
        this.elfrente = null;
        this.elfinal = null;
        this.tamanio = 0;
    }

   

    public void InsertarEnlaCola(Reclamos reclamo){
        NodoLista nuevoNodo = new NodoLista(reclamo);
        if (elfinal == null){
            elfrente = nuevoNodo;
            elfinal = nuevoNodo;
        } else {
            elfinal.siguiente = nuevoNodo;
            elfinal = nuevoNodo;
        }
        tamanio++;
        System.out.println("el reclamo identificado con el codigo: " + reclamo.getCodigoUnico()+ "Se ingreso al sistema");
        }

    public Reclamos RetirarDeLaCola(){
        if(estaVacia()){
            System.out.println("No hay reclamos por resolver.");
            return null;
        }
        
        Reclamos reclamofiniquitado=elfrente.reclamo;
        elfrente=elfrente.siguiente;

        if(elfrente==null){
            elfinal=null;
        }
        
        tamanio--;
        System.out.println("El reclamo identificado con el codigo: "+ reclamofiniquitado.getCodigoUnico()+ "ha sido atendido.");

        return reclamofiniquitado;
    } 

    public boolean estaVacia(){
        return elfrente==null;
    }

    /*AUN QUEDA POR TERMINAR EL LA PILA... */



}