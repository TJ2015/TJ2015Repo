package negocio.implementacion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dominio.Usuario;
import negocio.interfaces.IControladorUsuarioLocal;
import persistencia.interfaces.IUsuarioDAO;

/**
 * Session Bean implementation class ControladorUsuarioLocal
 */
@Stateless
@LocalBean
public class ControladorUsuarioLocal implements IControladorUsuarioLocal {

	@EJB
	private IUsuarioDAO usuarioDAO;
	
    /**
     * Default constructor. 
     */
    public ControladorUsuarioLocal() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public boolean existeUsuario(String nick) {
		boolean existe = false;
		try {
			//Si nos devuelve un usuario, existe es igual a true 
			existe = (this.usuarioDAO.buscarUsuario(nick) != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public boolean credencialesCorrectas(String nick, String pass) {
		boolean correcto = false;
		try {
			Usuario usuario = usuarioDAO.buscarUsuario(nick);
			correcto = (usuario != null && usuario.getPassword().equals(pass));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return correcto;
	}

}
