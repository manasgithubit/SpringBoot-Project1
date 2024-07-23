package com.nt.ControllerLayer;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Handling.ProductSpecifications;
import com.nt.ProductModel.Product;
import com.nt.ServiceLayer.ProductService;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts(@RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean inStock,
            @RequestParam(defaultValue = "createdAt") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder)
	{
		return productService.getFilteredAndSortedProducts(category, minPrice, maxPrice, inStock, sortField, sortOrder);
	}
}
