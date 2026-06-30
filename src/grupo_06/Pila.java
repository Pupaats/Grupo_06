package grupo_06;

import java.util.Stack;

public class Pila {
    private Stack<String> historialdecambios;

    public Pila() {
        this.historialdecambios = new Stack<>();
    }

    public void registrarCambios(int Codigo, String Estado){
   
        System.out.println(" El codigo del reclamo: " + Codigo + " y el cambio: " + Estado);
        String registro = "El registro reclamo con el codigo: "+ "[" + Codigo + "]: " + Estado;
        historialdecambios.push(registro);
    }

    public void VerCambioMasReciente(){
    if(historialdecambios.isEmpty()){
        System.out.println("No hay cambios registrados...");
    }else{
       System.out.println("Ultimo reclamo registrado: "+  historialdecambios.peek());
    }
    }

    public void MostrarHistorialDeCambios(){
        if(historialdecambios.isEmpty()){
            System.out.println("No existen cambios...");
        }else{
            System.out.println("Estos son los cambios: ");
            for (String Historialito : historialdecambios) {
                System.out.println(Historialito);
            }
        }
    }
}