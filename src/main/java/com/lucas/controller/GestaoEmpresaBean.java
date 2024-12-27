package com.lucas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.lucas.model.Empresa;
import com.lucas.model.TipoEmpresa;

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
	
	private Empresa empresa = new Empresa();
	
	public void salvar() {
		System.out.println("Razão Social:" + empresa.getRazaoSocial());
		System.out.println("Nome Fantasia:" + empresa.getNomeFantasia());
		System.out.println("CNPJ:" + empresa.getCnpj());
		System.out.println("Tipo Empresa:" + empresa.getTipo());
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

}
