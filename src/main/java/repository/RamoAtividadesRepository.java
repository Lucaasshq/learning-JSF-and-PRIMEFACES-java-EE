package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.lucas.model.RamoAtividade;

public class RamoAtividadesRepository implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager manager;
	
	RamoAtividadesRepository() {
		
	}

	public RamoAtividadesRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	
	public List<RamoAtividade> pesquisa(String descricao) {
		return null;
	}
	
	

}
