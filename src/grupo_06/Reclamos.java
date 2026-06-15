package grupo_06;

public class Reclamos {
    
public class Reclamo { // no se si estan deacuerdo con los nombres de las variables, si encuentran que esta muy corto lo cambian nomas
    private String codigoUnico; 
    private String Nombre;
    private String Rut;
    private String tipoReclamo;
    private String descripcion; 
    private String fechaIngreso; 
    private String estadoReclamo; 
    private int nivelPrioridad;
    private String fechaLimite;

    // Constructor
    public Reclamo(String codigoUnico, String nombreCiudadano, String rutCiudadano, 
                   String tipoReclamo, String descripcion, String fechaIngreso, 
                   String estadoReclamo, int nivelPrioridad, String fechaLimite) {
        this.codigoUnico = codigoUnico;
        this.Nombre = Nombre;
        this.Rut = Rut;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.estadoReclamo = estadoReclamo;
        this.nivelPrioridad = nivelPrioridad;
        this.fechaLimite = fechaLimite;
    }
// Getters

        public String getCodigoUnico() {
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

        public void setCodigoUnico(String codigoUnico) {
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
        
        
    
}




}
