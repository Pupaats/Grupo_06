package grupo_06;

import java.util.Stack;

public class Pila {
    private Stack<Reclamos> pilita;

    public Pila() {
        this.pilita = new Stack<>();
    }

    public void insertar(Reclamos reclamos) {
        pilita.push(reclamos);
    }

    public Reclamos eliminar() {
        if(pilita.isEmpty()){
            return null;
        } else{
            System.out.println("Se ha eliminado este reclamo: "+ pilita.peek());
            return pilita.pop();
        }
    }

    public Reclamos verTope() {
        Reclamos tope = pilita.peek();
            System.out.println("El ultiimo reclamo que se ha ingresado es: "+ tope);
        return tope;
    }

    public boolean estaVacia() {
        return pilita.isEmpty();
    }

    public void mostrarPila() {
        if (pilita.isEmpty()) {
            System.out.println("La pila se encuentra vacía.");
        }else{
            System.out.println("Los reclamos presentes son: ");
            for(Reclamos reclamo:pilita){
                System.out.println(reclamo);
            }
        }
    }

    public int NumeroReclamos(){
            System.out.println("La cantidad reclamos existentes es:"+ pilita.size());
        return pilita.size();
    }

}  

