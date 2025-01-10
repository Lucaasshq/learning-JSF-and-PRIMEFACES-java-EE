package com.lucas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lucas.model.Empresa;

@Named
@javax.enterprise.context.RequestScoped
public class EmpresasRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;


	public EmpresasRepository() {

	}

	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
		TypedQuery<Empresa> query = manager.createQuery("from Empresa where razaoSocial like :razaoSocial",
				Empresa.class);
		query.setParameter("razaoSocial", nome + "%");

		return query.getResultList();
	}
	


	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}

	public List<Empresa> todas() {
		List<Empresa> emp = manager.createQuery("from Empresa", Empresa.class).getResultList();
		 return emp;
	}

}
