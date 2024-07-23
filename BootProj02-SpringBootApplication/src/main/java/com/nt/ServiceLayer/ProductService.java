package com.nt.ServiceLayer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.ProductModel.Product;
import com.nt.RepositoryLayer.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder) {
	    List<Product> products = productRepository.findAll();
	    
	    // Filtering
	    if (category != null) {
	        products = products.stream()
	            .filter(p -> p.getCategory().equalsIgnoreCase(category))
	            .collect(Collectors.toList());
	    }
	    
	    if (minPrice != null && maxPrice != null) {
	        products = products.stream()
	            .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
	            .collect(Collectors.toList());
	    }
	    
	    if (inStock != null) {
	        products = products.stream()
	            .filter(p -> p.getInStock().equals(inStock))
	            .collect(Collectors.toList());
	    }
	    
	    // Sorting
	    if (sortField != null && sortOrder != null) {
	        Comparator<Product> comparator = getComparator(sortField);
	        
	        if ("desc".equalsIgnoreCase(sortOrder)) {
	            comparator = comparator.reversed();
	        }
	        
	        products = products.stream()
	            .sorted(comparator)
	            .collect(Collectors.toList());
	    }
	    
	    return products;
	}
	
	private Comparator<Product> getComparator(String sortField) {
	    switch (sortField) {
	        case "price":
	            return Comparator.comparing(Product::getPrice);
	        case "rating":
	            return Comparator.comparing(Product::getRating);
	        case "createdAt":
	            return Comparator.comparing(Product::getCreatedAt);
	        default:
	            return Comparator.comparing(Product::getId); // Default sorting by ID if no valid field is provided
	    }
	}

	public List<Product> getFilteredAndSortedProducts(String category, Double minPrice, Double maxPrice,
			Boolean inStock, String sortField, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}
}
