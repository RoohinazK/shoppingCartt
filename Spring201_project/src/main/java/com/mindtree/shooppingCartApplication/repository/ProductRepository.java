package com.mindtree.shooppingCartApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.shooppingCartApplication.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value = "select * from product where productId in :ids", nativeQuery = true)
	List<Product> getProduct(@Param("ids") List<Integer> ids);
	
}