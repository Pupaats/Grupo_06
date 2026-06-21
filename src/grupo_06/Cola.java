package grupo_06;

public class Cola  
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
        System.out.println("el reclamo identificado con el codigo: " + reclamo.getCodigoUnico()+ "Se ha ingresado al sistema");
        }

    public Reclamos RetirarDeLaCola(){
        if(LaColaEstaVacia()){
            System.out.println("No hay reclamos por resolver.");
            return null;
        }
        
        Reclamos reclamofiniquitado=elfrente.reclamo;
        elfrente=elfrente.siguiente;

        if(elfrente==null){
            elfinal=null;
        }

        tamanio--;

        System.out.println("El reclamo identificado con el codigo: "+ reclamofiniquitado.getCodigoUnico() + "ha sido atendido.");

        return reclamofiniquitado;
    } 

    public Reclamos verSiguiente() {
        if (LaColaEstaVacia()) {
            System.out.println("No hay reclamos pendientes en la cola.");
            return null;
        }
        System.out.println("Próximo reclamo a atender: #" + elfrente.reclamo.getCodigoUnico()
                + " - " + elfrente.reclamo.getNombre());
        return elfrente.reclamo;
    }

    public int getTamanio(){
        return tamanio;
    }


    public boolean LaColaEstaVacia(){
        return elfrente==null;
    }


    public void MostrarColaSistema(){
        if(LaColaEstaVacia()){
            System.out.println("ya no quedan reclamos en el sistema.");
            return;
        }
   
        System.out.println(" Los reclamos pendientes por atender son: " + tamanio);
        
        NodoLista Dato=elfrente;
        for(int i=1; i<=tamanio; i++){
            System.out.println("Reclamo numero: "+i +
            "Codigo del reclamo: "+ Dato.reclamo.getCodigoUnico()+
            "Nombre del reclamante: "+ Dato.reclamo.getNombre()+
            "Estado Actual del reclamo: "+ Dato.reclamo.getEstadoReclamo()+
            "El nivel de prioridad del reclamo: "+ Dato.reclamo.getNivelPrioridad());
        
            Dato=Dato.siguiente;
        }
        
       
    }


}