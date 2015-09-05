package negocio.interfaces;

import javax.ejb.Local;

@Local
public interface IControladorUsuarioLocal {
	
	public boolean existeUsuario(String nick);
	
	public boolean credencialesCorrectas(String nick, String pass);
	
}
