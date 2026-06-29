package grupo_06;

public class ListaReclamos {
    private NodoLista iniciolista;
    private NodoLista finallista;
    private int cantidadReclamos;

    public ListaReclamos(){
        this.iniciolista = null;
        this.finallista = null;
        this.cantidadReclamos = 0;
    }
    
    //creo que tiene una complejidad de 0(1), ya que inserta al final con el puntero
    public void registrarReclamo(Reclamos reclamo){
        NodoLista nuevoNodo = new NodoLista(reclamo);
        
        if(iniciolista == null){
            iniciolista = nuevoNodo;
            finallista = nuevoNodo;
        }else{
            finallista.siguiente = nuevoNodo;
            finallista = nuevoNodo;
        }
        cantidadReclamos ++;
    }
    //Busqueda Sequencial
    /* cuando usariamos la busqueda secuencial ? cuando la lista no esta ordenada o cuando se busca
    una sola vez, cuando no requiere ordenamiento previo o cuando las listas son pequeñas
    tiene de complejidad O(n) porque en el peor de los casos se tendria que recorrer la lista completa  
    */
    
    public Reclamos buscarReclamo(int codigoUnico){
        NodoLista actual = iniciolista;
        while(actual != null){
            if(actual.reclamo.getCodigoUnico() == codigoUnico){
                return actual.reclamo;
            }
            actual = actual.siguiente;
        }
        return null; // no lo encontro
    } 
    
    //Busqueda Binaria
    public Reclamos busquedaBinariaPorPrioridad(int prioridadBuscada) {
        if (iniciolista == null) return null;

        //pasa los elementos de la lista enlazada a un array temporal
        Reclamos[] arreglo = new Reclamos[cantidadReclamos];
        NodoLista actual = iniciolista;
        int i = 0;
        while (actual != null) {
            arreglo[i] = actual.reclamo;
            actual = actual.siguiente;
            i++;
        }
        Ordenamiento.QuickSortReclamos(arreglo, 0, arreglo.length - 1);

        //aplicamos busqueda binaria sobre el arreglo ya ordenado
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int prioridadMedio = arreglo[medio].getNivelPrioridad();

            if (prioridadMedio == prioridadBuscada) {
                return arreglo[medio]; 
            }

            if (prioridadMedio < prioridadBuscada) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null; 
    }
    
    
   public boolean eliminarReclamo(int codigoUnico){
        NodoLista NodoActual = iniciolista;
        NodoLista NodoAnterior = null;
 
        while(NodoActual != null){
            if(NodoActual.reclamo.getCodigoUnico() == codigoUnico){
                if(NodoAnterior == null && NodoActual == finallista){
                    iniciolista = null;
                    finallista = null;
                }else if(NodoAnterior == null){
                    iniciolista = NodoActual.siguiente;
                }else if(NodoActual == finallista){
                    NodoAnterior.siguiente = null;
                    finallista = NodoAnterior;
                }else{
                    NodoAnterior.siguiente = NodoActual.siguiente;
                }
                cantidadReclamos--;
                return true;
            }
            NodoAnterior = NodoActual;
            NodoActual = NodoActual.siguiente;
        }
 
        System.out.println("Hubo un error, hay coincidencias con el código: " + codigoUnico);
        return false;
    }    
    
    //Muestra todos los reclamos ordenados por prioridad usando el InsertionSort
    // tiene de complejidad el O(n^2) por el ordenamiento cuadratico
    public void consultarReclamos(){
        NodoLista NodoActual = iniciolista;
        
        if(NodoActual == null){
            System.out.println("Aún no hay reclamos registrados.");
        }else{
            System.out.println("Reclamos registrados: ");
            while(NodoActual != null){
                NodoActual.reclamo.mostrarInfo();
                NodoActual = NodoActual.siguiente;
            }
        }        
    }
    
    public int obtenerTamaño(){
        return cantidadReclamos; // cambio para que sea o(1)
    }
    
    // Extra ---> Eliminar luego
    public void mostrarCodigos(){
        NodoLista NodoActual = iniciolista;
        
        while(NodoActual != null){
            System.out.println("Codigo: [" + NodoActual.reclamo.getCodigoUnico() + "]");
            NodoActual = NodoActual.siguiente;
        }
        
    }    

     public void mostrarPorTipoReclamo(String tipo){
        NodoLista NodoActual = iniciolista;
        boolean encontrado = false;
        
        while(NodoActual != null){
            if(NodoActual.reclamo.getTipoReclamo().equalsIgnoreCase(tipo)){
                NodoActual.reclamo.mostrarInfo();
                encontrado = true;
            }
            NodoActual = NodoActual.siguiente;
        }
        
        // Si no se encontraron reclamos
        if(encontrado == false){
            System.out.println("No existen reclamos de este tipo.");
        }
    }

    
    public void MostrarReclamosAvencer(String fechaActual){
        if(iniciolista==null){
            return;
        }

        int diaslimitereclamo=31; // 7
        int aniosistema=2026;


        //Se almacenan los datos de la fecha en indices para luego trabajar con ellos como enteros para finalmente evaluar su validez.
        String[] divisor_mes_dia_anio=fechaActual.split("/");
        int diaactual=Integer.parseInt(divisor_mes_dia_anio[0]);
        int mesactual=Integer.parseInt(divisor_mes_dia_anio[1]);
        int anioactual=Integer.parseInt(divisor_mes_dia_anio[2]);

         if(anioactual != aniosistema){
            System.out.println("No es posible agregar el reclamo, La fecha ingresada no corresponde al anio actual (" + aniosistema + ").");
            return;
        }

        NodoLista NodoActual=iniciolista;
         while(NodoActual != null){
            Reclamos reclamoActual = NodoActual.reclamo;
            
            // Se separa la fecha que el usuario ingresa (si se respeta el formato solicitado XD) con split y trabajar con ellos como en datos aparte
            String[] almacenadordedatos = reclamoActual.getFechaLimite().split("/");
            int diasmaximos= Integer.parseInt(almacenadordedatos[0]);
            int mesmaximo = Integer.parseInt(almacenadordedatos[1]);
            int aniomaximo= Integer.parseInt(almacenadordedatos[2]);
        

            //Si el año es diferente al actual, evita el ingreso del reclamo
            if(aniomaximo != aniosistema){
                //System.out.println("Lo sentimos, el reclamo con el codigo: " + reclamoActual.getCodigoUnico() + ", no podra ser evaluado debido a que es diferente al anio actual: " + aniosistema );
                NodoActual = NodoActual.siguiente;
                continue; //se usa continue porque los siguientes reclamos podrian  ser validos
            }
            
            //Evalua que la resta de los meses (mes reclamo del usuario menos el mes actual ejemplo hoy 28/06/26) no hayan pasado el mes actual o lo hayan superado por mas 1 mes
            if(mesmaximo - mesactual < 0 || mesmaximo - mesactual > 1){
                //System.out.println("Este reclamo no sera evaluado: "+ reclamoActual.getCodigoUnico() + ". Debido a que excede la fecha limite de mas de 1 mes de diferencia.");
                NodoActual = NodoActual.siguiente;
                continue; //se usa continue porque los siguientes reclamos podrian ser validos
            }
            
            int diasRestantes;
            if(mesmaximo == mesactual){
                diasRestantes = diasmaximos - diaactual;
            }else{
                /*
                    Basicamente esto es un caso en donde si la fecha limite cae en el mes posterior: se adcionan los dias del mes actual mas los del posterior
                 */
                diasRestantes = (31 - diaactual) + diasmaximos; // 30
            }
            
            //si diasrestantes es menor a 0, se imprime el dia eliminando el signo
            if(diasRestantes <=diaslimitereclamo){
                reclamoActual.mostrarInfo();
                
                if(diasRestantes < 0){
                    System.out.println("El reclamo ha vencido hace: " + Math.abs(diasRestantes));
                }else if(diasRestantes == 0){
                    System.out.println("URGENTE, este reclamo finaliza el dia de hoy. ATENDER PRONTO");
                }else{
                    System.out.println("El reclamo vence en los siguientes dias: "+diasRestantes);
                }
            }
            
            NodoActual = NodoActual.siguiente;
        }
        
    
                
    }
    
}