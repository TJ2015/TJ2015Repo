package persistencia.implementacion;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import dominio.Usuario;
import persistencia.interfaces.IUsuarioDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioDAO implements IUsuarioDAO {
	
	@javax.persistence.PersistenceContext(unitName="Practico01")
	private javax.persistence.EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean altaUsuario(Usuario usuario) {
		boolean seRegistro = false;
		try {
			//Persiste un usuario a la base de datos
			em.persist(usuario);
			seRegistro = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seRegistro;
	}

	@Override
	public Usuario buscarUsuario(String nick) {
		Usuario usuario = null;
		try {
			//Se busca el usuario en la base 
			usuario = em.find(Usuario.class, nick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public boolean actualizarUsuario(Usuario usuario) {
		boolean seActualizo = false;
		try {
			//Actualiza el en la base de datos.
			em.merge(usuario);
			seActualizo = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seActualizo;
	}

}
