package com.nt.Handling;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.nt.ProductModel.Product;
import com.nt.RepositoryLayer.ProductRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class ProductSpecifications {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getFilteredAndSortedProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder) {
        Sort sort = Sort.by(Sort.Order.by(sortField).with(Sort.Direction.fromString(sortOrder)));

        Specification<Product> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (category != null) {
                predicates.add(criteriaBuilder.equal(root.get("category"), category));
            }
            if (minPrice != null && maxPrice != null) {
                predicates.add(criteriaBuilder.between(root.get("price"), minPrice, maxPrice));
            } else if (minPrice != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
            } else if (maxPrice != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
            }
            if (inStock != null) {
                predicates.add(criteriaBuilder.equal(root.get("inStock"), inStock));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return productRepository.findAll(specification, sort);
    }
}
