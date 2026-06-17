package grupo_06;

import java.util.Stack;

public class Pila {
    private Stack<Reclamos> pilita;

    public Pila() {
        this.pilita = new Stack<>();
    }

    public void InsertarCambioReclamo(Reclamos reclamos) {
        pilita.push(reclamos);
    }

    public Reclamos eliminarCambioReclamo() {
        if(pilita.isEmpty()){
            return null;
        } else{
            System.out.println("Se ha eliminado el siguiente cambio: "+ pilita.pop());
            return pilita.pop();
        }
    }

    public Reclamos verCambioMasReciente() {
        Reclamos tope = pilita.peek();
            System.out.println("El ultimo cambio que se ha ingresado es: "+ tope);
        return tope;
    }

    public boolean PilaVacia() {
        return pilita.isEmpty();
    }

    public void mostrarHistorialCambios() {
        if (pilita.isEmpty()) {
            System.out.println("No hubo cambios en los reclamos.");
        }else{
            System.out.println("Los cambios que se han hecho son: ");
            for(Reclamos reclamo:pilita){
                System.out.println(reclamo);
            }
        }
    }

    public int NumeroCambiosReclamos(){
            System.out.println("La cantidad de cambios que se han hecho a los reclamos es:"+ pilita.size());
        return pilita.size();
    }

}  

