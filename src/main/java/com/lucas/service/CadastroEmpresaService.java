package com.lucas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.lucas.model.Empresa;
import com.lucas.repository.EmpresasRepository;
import com.lucas.util.Transacional;

public class CadastroEmpresaService implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Inject
	EmpresasRepository empresaRepository;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresaRepository.guardar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresaRepository.remover(empresa);
	}
	

}
