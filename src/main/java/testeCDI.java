import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class testeCDI {
	
	private String mensagem = "CDI funcionando";

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
