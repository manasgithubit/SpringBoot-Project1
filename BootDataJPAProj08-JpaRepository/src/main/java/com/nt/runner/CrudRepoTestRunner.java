package com.nt.runner;

import java.lang.reflect.Array;
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
			//System.out.println(service.removieMoviesByIds(List.of(513,515)));
			List<Integer> ids = new ArrayList<>();
			ids.add(567);
			ids.add(null);
			List<Integer> ids = Arrays.asList(13,null);
			    System.out.println(service.removieMoviesByIds(ids));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
	/*	System.out.println("------ findAll(Example,Sort) ----------");
		try
		{
			 Movies movie = new Movies();
			 movie.setMid(101);
			 movie.setMname("Puspa");
			 movie.setRating(5.0f); movie.setYear("2023");
			 List<Movies> list = service.searchMoviesByMovie(movie, true, "mname");
			 list.forEach(System.out::println);
		}//try
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		
		System.out.println("------ getById(Integer id) ----------");
		try
		{
			System.out.println("416 Movie details are" + service.serchMoviesById(416));
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
