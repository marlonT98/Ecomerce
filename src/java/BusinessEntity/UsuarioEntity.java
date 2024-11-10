package BusinessEntity;

public class UsuarioEntity {

    private String usu_codigo;
    private String usu_login;
    private String usu_passwd;
    private String usu_descri;
    private String usu_apepat;

    public UsuarioEntity() {
    }

    public String getUsu_apepat() {
        return usu_apepat;
    }

    public void setUsu_apepat(String usu_apepat) {
        this.usu_apepat = usu_apepat;
    }

    public String getUsu_codigo() {
        return usu_codigo;
    }

    public void setUsu_codigo(String usu_codigo) {
        this.usu_codigo = usu_codigo;
    }

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_passwd() {
        return usu_passwd;
    }

    public void setUsu_passwd(String usu_passwd) {
        this.usu_passwd = usu_passwd;
    }

    public String getUsu_descri() {
        return usu_descri;
    }

    public void setUsu_descri(String usu_descri) {
        this.usu_descri = usu_descri;
    }

}
