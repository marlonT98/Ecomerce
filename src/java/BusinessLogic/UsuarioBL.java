
package BusinessLogic;

import BusinessEntity.UsuarioEntity;
import DataAccessObject.UsuarioDao;
import java.util.List;


public class UsuarioBL {

    //listar
    public List<UsuarioEntity> listar() {

        UsuarioDao DAO = new UsuarioDao();

        return DAO.readAll();

    }
    
    //buscar por id
    public UsuarioEntity  bucarPorId( String id  ) {

      

        return new UsuarioDao().readByCodigo(id);

    }
    
    //eliminar
    public boolean  delete ( String id   ){
        
        return new UsuarioDao().delete(id);
        
    }
    
    //insertar
    public boolean insertar( UsuarioEntity usuario ){
        
        return new UsuarioDao().insert(usuario);
        
    }
    
    
    
        //actualizar
    public boolean actualizar( UsuarioEntity usuario ){
        
        return new UsuarioDao().update(usuario);
        
    }
    
    
    

}
