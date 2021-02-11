package com.empresa.demo.interfaz;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.demo.model.Categoria;
import com.empresa.demo.model.Plato;

@Repository
public interface IPlato extends CrudRepository<Plato, String>{

	//Plato findFirstById(String id);
	 
	@Transactional
	@Modifying
	@Query(value="{CALL REGISTRAR_PLATO(:id_categoriaIn,:nombreIn,:precioIn,:descripcionIn,:stockIn,:imagenIn)}",nativeQuery=true)
	void saveProcedure(
			@Param("id_categoriaIn")Categoria id_categoriaIn,
			@Param("nombreIn")String nombreIn,
			@Param("precioIn")double precioIn,
			@Param("descripcionIn")String descripcionIn,
			@Param("stockIn")int stockIn,
			@Param("imagenIn")String imagenIn
			);
	
}
