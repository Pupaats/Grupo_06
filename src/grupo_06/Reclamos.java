package grupo_06;

public class Reclamos { 
    private int codigoUnico; 
    private String Nombre;
    private String Rut;
    private String tipoReclamo;
    private String descripcion; 
    private String fechaIngreso; 
    private String estadoReclamo; 
    private int nivelPrioridad;
    private String fechaLimite;

    // Constructor
    public Reclamos(int codigoUnico, String nombreCiudadano, String rutCiudadano, 
                   String tipoReclamo, String descripcion, String fechaIngreso, 
                   String estadoReclamo, int nivelPrioridad, String fechaLimite) {
        this.codigoUnico = codigoUnico;
        this.Nombre = nombreCiudadano;
        this.Rut = rutCiudadano;   
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.estadoReclamo = "Pendiente";
        this.nivelPrioridad = nivelPrioridad;
        this.fechaLimite = fechaLimite;
    }
// Getters

        public int getCodigoUnico() {
            return codigoUnico;
        }

        public String getNombre() {
            return Nombre;
        }

        public String getRut() {
            return Rut;
        }

        public String getTipoReclamo() {
            return tipoReclamo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getFechaIngreso() {
            return fechaIngreso;
        }

        public String getEstadoReclamo() {
            return estadoReclamo;
        }

        public int getNivelPrioridad() {
            return nivelPrioridad;
        }

        public String getFechaLimite() {
            return fechaLimite;
        }
 
// Setters

        public void setCodigoUnico(int codigoUnico) {
            this.codigoUnico = codigoUnico;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public void setRut(String Rut) {
            this.Rut = Rut;
        }

        public void setTipoReclamo(String tipoReclamo) {
            this.tipoReclamo = tipoReclamo;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setFechaIngreso(String fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
        }

        public void setEstadoReclamo(String estadoReclamo) {
            this.estadoReclamo = estadoReclamo;
        }

        public void setNivelPrioridad(int nivelPrioridad) {
            this.nivelPrioridad = nivelPrioridad;
        }

        public void setFechaLimite(String fechaLimite) {
            this.fechaLimite = fechaLimite;
        }
        
        
    
        public void mostrarInfo(){
            System.out.println("\n===================================");
            System.out.println("INFORMACIÓN DEL RECLAMO CÓDIGO [" + getCodigoUnico() + "]");
            System.out.println("--------------ATENCIÓN-------------");    
            System.out.println("ESTADO: " + estadoReclamo);    
            System.out.println("PRIORIDAD: " + nivelPrioridad);    
            System.out.println("---------------DATOS---------------");    
            System.out.println("NOMBRE: " + Nombre);
            System.out.println("RUT: " + Rut);           
            System.out.println("TIPO: " + tipoReclamo);
            System.out.println("DESCRIPCION: " + descripcion);
            System.out.println("FECHA DE INGRESO: " + fechaIngreso);
            System.out.println("FECHA LÍMITE: " + fechaLimite + "\n");
        }
        
        // Sobrecarga para mostrar si esta próximo a vencer
        public void mostrarInfo(int diasRestantes){
            System.out.println("\n===================================");
            System.out.println("INFORMACIÓN DEL RECLAMO CÓDIGO [" + getCodigoUnico() + "]");
            System.out.println("--------------ATENCIÓN-------------");    
            
            if(diasRestantes<0){
                System.out.println("VENCIDO HACE: " + Math.abs(diasRestantes) + " DÍAS");
            }else if(diasRestantes==0){
                System.out.println("VENCE HOY");
            }else{
                System.out.println("VENCE EN: " + diasRestantes + " días");
            }
            
            System.out.println("ESTADO: " + estadoReclamo);    
            System.out.println("PRIORIDAD: " + nivelPrioridad);    
            System.out.println("---------------DATOS---------------");    
            System.out.println("NOMBRE: " + Nombre);
            System.out.println("RUT: " + Rut);           
            System.out.println("TIPO: " + tipoReclamo);
            System.out.println("DESCRIPCION: " + descripcion);
            System.out.println("FECHA DE INGRESO: " + fechaIngreso);
            System.out.println("FECHA LÍMITE: " + fechaLimite + "\n");
        }
        
}
