import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class consumirBean {

	@Inject
	private testeCDI teste;

	public String exibir() {
		return teste.getMensagem();
	}

}
