package py.gov.setics.asistente.view;

import java.util.List;

import javax.inject.Inject;

import py.gov.setics.asistente.business.RolBC;
import py.gov.setics.asistente.business.UsuarioBC;
import py.gov.setics.asistente.domain.Rol;
import py.gov.setics.asistente.domain.Usuario;
import py.gov.setics.asistente.util.HashUtils;

import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;

@ViewController
@PreviousView("/admin/usuario_list.xhtml")
public class UsuarioEditMB extends AbstractEditPageBean<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioBC usuarioBC;
	
	@Inject 
	private RolBC rolBC;

	protected List<Rol> getTiposRoles(){
		return rolBC.findAll();
	}

	@Override
	@Transactional
	public String delete() {
		this.usuarioBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		Usuario usuario = getBean();
		usuario.setPwd(HashUtils.md5(usuario.getPwd()));
		this.usuarioBC.insert(usuario);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.usuarioBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.usuarioBC.load(getId()));
	}
	
}
