package com.nt.RepositoryLayer;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nt.ProductModel.Product;

/*@Repository	
public interface ProductRepository extends JpaRepository<Product, Long>
{
	List<Product> findAll(Sort sort);
}*/


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

	
}
