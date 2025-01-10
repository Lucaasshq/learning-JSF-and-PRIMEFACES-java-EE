package com.lucas.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.lucas.model.Empresa;
import com.lucas.model.RamoAtividade;
import com.lucas.model.TipoEmpresa;
import com.lucas.repository.EmpresasRepository;
import com.lucas.repository.RamoAtividadesRepository;
import com.lucas.service.CadastroEmpresaService;
import com.lucas.util.FacesMessages;

//@RequestScoped:

//Cria uma nova instância para cada requisição HTTP.
//Bom para operações curtas e leves.
//@SessionScoped:

//Mantém o bean vivo durante a sessão do usuário.
//Ideal para informações relacionadas ao usuário que devem persistir enquanto ele está conectado.
//@ApplicationScoped:

//Cria uma única instância compartilhada entre todos os usuários da aplicação.
//Útil para dados globais, como configurações.
//@ViewScoped:

//Mantém o bean vivo enquanto o usuário estiver interagindo com a mesma página JSF.
//Ótimo para páginas com formulários complexos.

@Named
@ViewScoped
public class GestaoEmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresasRepository empresasRepository;

	@Inject
	private FacesMessages messages;

	@Inject
	private CadastroEmpresaService cadastroEmpresaService;

	@Inject
	private RamoAtividadesRepository ramoAtividadeRepository;

	private RamoAtividadeConverter ramoAtividadeConverter;

	private List<Empresa> listarEmpresas;

	private Empresa empresa;

	private String termoPesquisa;

	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}

	public void salvarEmpresa() {
		cadastroEmpresaService.salvar(empresa);

		if (jaHouvePesquisa()) {
			pesquisar();
		} else {
			todasEmpresas();
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa salva com sucesso", null));
		PrimeFaces.current().ajax().update(Arrays.asList("frm:empresasDataTable", "frm:mensagem-info"));

	}

	public void pesquisar() {
		listarEmpresas = empresasRepository.pesquisar(termoPesquisa);
		if (listarEmpresas.isEmpty()) {
			messages.info("Sua pesquisa não retornou registros!");

		}
		System.out.println(listarEmpresas.toString());
	}

	public void todasEmpresas() {
		listarEmpresas = empresasRepository.todas();

	}

	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> listaRamoAtividade = ramoAtividadeRepository.pesquisa(termo);

		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividade);

		return listaRamoAtividade;
	}

	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}

	public List<Empresa> getListaEmpresas() {
		return listarEmpresas;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();

	}

	public RamoAtividadeConverter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}

	public void setRamoAtividadeConverter(RamoAtividadeConverter ramoAtividadeConverter) {
		this.ramoAtividadeConverter = ramoAtividadeConverter;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
