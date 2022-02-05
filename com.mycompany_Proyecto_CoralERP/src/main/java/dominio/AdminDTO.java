
package dominio;


public class AdminDTO {
    private int id_admin;
    private String usuario;
    private String clave;

    public AdminDTO() {
    }

    public AdminDTO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public AdminDTO(int id_admin, String usuario, String clave) {
        this.id_admin = id_admin;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "AdminDTO{" + "id_admin=" + id_admin + ", usuario=" + usuario + ", clave=" + clave + '}';
    }
    
    
}
