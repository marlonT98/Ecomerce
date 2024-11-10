package DataAccessObject;

import BusinessEntity.UsuarioEntity;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends ConexionMySQL {

    public UsuarioDao() {
    }

    //metodo para listar
    public List<UsuarioEntity> readAll() {

        List<UsuarioEntity> lstUsuarios = null;

        try {

            String SQL = "SELECT * FROM xetbuser";
            Statement st = getConexion().createStatement();
            ResultSet rs = st.executeQuery(SQL);
            lstUsuarios = new ArrayList<>();

            while (rs.next()) {

                UsuarioEntity item = new UsuarioEntity();
                item.setUsu_codigo(rs.getString("usu_codigo"));
                item.setUsu_login(rs.getString("usu_login"));
                item.setUsu_descri(rs.getString("usu_descri"));

                lstUsuarios.add(item);

            }

        } catch (SQLException e) {

            System.out.println("Error a listar los usuarios :" + e.getMessage());
        }

        return lstUsuarios;

    }

    // Método para listar un usuario por código
    public UsuarioEntity readByCodigo(String c) {
        UsuarioEntity item = null; // Inicia como null para manejar cuando no se encuentre un usuario

        String sql = "SELECT * FROM xetbuser WHERE usu_codigo=?";
        try (PreparedStatement pst = getConexion().prepareStatement(sql)) {
            pst.setString(1, c);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) { // Si se encuentra un resultado
                    item = new UsuarioEntity();
                    item.setUsu_codigo(rs.getString("usu_codigo"));
                    item.setUsu_login(rs.getString("usu_login"));
                    item.setUsu_descri(rs.getString("usu_descri"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar el usuario: " + e.getMessage());
        }

        return item; // Devuelve null si no se encuentra el usuario
    }

    //Metodo eliminar
    public boolean delete(String c) {
        boolean result = false;

        try {
            PreparedStatement pst = getConexion().prepareStatement("DELETE FROM xetbuser where usu_codigo=?");
            pst.setString(1, c);

            result = pst.execute();

        } catch (SQLException ex) {
            System.out.println("ex = " + ex);
        }

        return result;
    }

    //actualizar el usuario
    public boolean update(UsuarioEntity item) {
        boolean result = false;

        String sql = "UPDATE xetbuser SET usu_descri=?, usu_apepat=? WHERE usu_codigo=?";
        try (PreparedStatement pst = getConexion().prepareStatement(sql)) {
            pst.setString(1, item.getUsu_descri());
            pst.setString(2, item.getUsu_apepat());
            pst.setString(3, item.getUsu_codigo());

            // Usamos executeUpdate() y verificamos si se actualizó al menos una fila
            result = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }

        return result;
    }

    //metodo para registrar o crear
    public boolean insert(UsuarioEntity item) {

        boolean result = false;

        try {
            String sql = "INSERT  xetbuser (usu_codigo ,usu_descri ,usu_login , usu_apepat,  usu_accniv) VALUE (?,?,?,?,?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, item.getUsu_codigo());
            pst.setString(2, item.getUsu_descri());
            pst.setString(3, item.getUsu_login());
            pst.setString(4, item.getUsu_apepat());
            pst.setString(5, "G");

            // Usamos executeUpdate() para las operaciones de INSERT y verificamos si afecta al menos una fila
            result = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario: " + e.getMessage());
            System.out.println("Parametros: " + item.getUsu_codigo() + ", " + item.getUsu_descri() + ", " + item.getUsu_login() + ", " + item.getUsu_apepat());
        }
    

    return result ;

}

//probando
public static void main(String[] args) {

        UsuarioDao dao = new UsuarioDao();

        //elimnar-------------------------------
        //eliminado = gian valdivia
        // boolean respeusta =  dao.delete("5d956eaf-34fd-4a1c-a952-55ddb3bae3ab");
        //actualizar-----------------------------
        UsuarioEntity user = new UsuarioEntity();
        user.setUsu_apepat("bazan");
        user.setUsu_descri("jhon doe");
        user.setUsu_codigo("ae8017cf-bc8d-4bb8-9530-579555fcd0a5");
        // boolean respeusta = dao.update(user);

        //registrar---------(creando un nuevo usuario)--------------
        UsuarioEntity newUser = new UsuarioEntity();

        newUser.setUsu_codigo("5d956eaf-34fd-4a1c-a952-55ddb3bae3a");
        newUser.setUsu_apepat("tarrillo");
        newUser.setUsu_descri("Jhon doe");
        newUser.setUsu_login("root");

        dao.insert(user);

        //boolean respeusta2 = dao.insert(newUser);
        //listar-------------------------------------
        List<UsuarioEntity> lst = dao.readAll();
        for (UsuarioEntity usuario : lst) {

            System.out.println(usuario.getUsu_codigo() + " /" + usuario.getUsu_descri());
        }

    }

}
