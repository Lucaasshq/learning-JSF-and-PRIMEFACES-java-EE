package com.lucas.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lucas.model.Empresa;
import com.lucas.model.RamoAtividade;
import com.lucas.model.TipoEmpresa;

public class camadaPersistencia {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Curso-JSF");
		
		EntityManager em = emf.createEntityManager();
		
		//Iniciando transacao 
		em.getTransaction().begin();
		
		//Declarando os repositorios
		RamoAtividadesRepository ramoRepository = new RamoAtividadesRepository(em);
		EmpresasRepository empresasRepository = new EmpresasRepository(em);
		
		//Buscando as informacoes no banco 
		List<RamoAtividade> listaRamoAtividades = ramoRepository.pesquisa("");
		List<Empresa> listaEmpresas = empresasRepository.pesquisar("");
		System.out.println(listaEmpresas);
		System.out.println(listaRamoAtividades);
		
		
		//Criando uma empresa
		Empresa empresa1 = new Empresa();
		empresa1.setNomeFantasia("Lucas Henrique");
		empresa1.setCnpj("41.952.555/0001-57");
		empresa1.setRazaoSocial("Lucas Henrique 41952555000157");
		empresa1.setTipo(TipoEmpresa.MEI);
		empresa1.setDataFundacao(new Date());
		empresa1.setRamoAtividade(listaRamoAtividades.get(0));
		
		//Salvando a empresa
		empresasRepository.guardar(empresa1);
		
		em.getTransaction().commit();
		
		//Verificando se a insercao funcionou
		List<Empresa> listaDeEmpresa2 = empresasRepository.pesquisar("");
		System.out.println(listaDeEmpresa2);
		
		em.close();
		emf.close();
	}

}
