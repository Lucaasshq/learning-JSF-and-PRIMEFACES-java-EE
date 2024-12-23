package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.lucas.model.RamoAtividade;

public class RamoAtividadesRepository implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private EntityManager manager;
	
	RamoAtividadesRepository() {
		
	}

	public RamoAtividadesRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	
	public List<RamoAtividade> pesquisa(String descricao) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		//Equivalente ao JPQL
		CriteriaQuery<RamoAtividade> criterialQuery = criteriaBuilder.createQuery(RamoAtividade.class);
		Root<RamoAtividade> root = criterialQuery.from(RamoAtividade.class);
		criterialQuery.select(root);
		criterialQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
		
		TypedQuery<RamoAtividade> query = manager.createQuery(criterialQuery);
		return query.getResultList();
	}
	
	

}
