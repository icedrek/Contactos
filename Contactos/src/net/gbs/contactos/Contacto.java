package net.gbs.contactos;

public class Contacto {
	private String nombre;
    private String email;
    private String telefono;
 
    public Contacto(){        
    }
    
    public Contacto(String nombre, String email, String telefono){
        nombre = this.nombre;
        email = this.email;
        telefono = this.telefono;
    }
 
    public String getNombre(){
        return nombre;
    }
 
    public String getEmail(){
        return email;
    }
    
    public String getTelefono(){
        return telefono;
    }

}
