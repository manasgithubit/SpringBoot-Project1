package com.nt.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Movies;
import com.nt.service.IMovieMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	private IMovieMgmtService service;
	
	
	@Override
	public void run(String... args) throws Exception {
			
	/*	System.out.println("------ deleteAllByIdInBatch(-) ----------");
		try
		{
			System.out.println(service.removieMoviesByIds(List.of(513,515)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
	/*	System.out.println("------ deleteAllByIdInBatch(-) ----------");
		try
		{
			Movies movie = new Movies();
			movie.setMid(100);movie.setMname("RRR");
			movie.setRating(4.0f); movie.setYear("2021");
			List<Movies> list = service.searchMoviesByMovie(movie, true, "mname");
			list.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		System.out.println("---------getById(Integer id)-------");
		try
		{
			System.out.println("416 Movie Details are" + service.serchMoviesById(416));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}//main
}//class
