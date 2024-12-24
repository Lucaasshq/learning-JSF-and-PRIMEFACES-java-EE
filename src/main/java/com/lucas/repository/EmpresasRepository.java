package com.lucas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lucas.model.Empresa;

public class EmpresasRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public EmpresasRepository(EntityManager manager) {
		this.manager = manager;
	}

	public EmpresasRepository() {

	}

	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
		TypedQuery<Empresa> query = manager.createQuery("from Empresa where nomeFantasia like :nomeFantasia",
				Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");

		return query.getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}

}