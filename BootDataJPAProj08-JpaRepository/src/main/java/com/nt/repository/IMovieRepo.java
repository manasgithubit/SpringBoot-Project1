package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Movies;

public interface IMovieRepo extends JpaRepository<Movies, Integer>{

	
}
