	//Service Interface
package com.nt.service;

import java.util.List;

import com.nt.entity.Movies;

public interface IMovieMgmtService {

	public String removieMoviesByIds(List<Integer>ids);
	public List<Movies> searchMoviesByMovie(Movies movie,boolean asc,String...props);
	public Movies serchMoviesById(Integer id);
}
