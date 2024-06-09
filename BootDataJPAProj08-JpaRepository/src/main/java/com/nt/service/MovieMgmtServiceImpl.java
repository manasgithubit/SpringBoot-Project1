	//service impl class
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Movies;
import com.nt.repository.IMovieRepo;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {

	@Autowired //injects the dynamically generated proxy class object
	private IMovieRepo movieRepo;  //HAS-A property

	@Override
	public String removieMoviesByIds(List<Integer> ids) {
		List<Movies> list = movieRepo.findAllById(ids);
		long count = list.size();
			movieRepo.deleteAllByIdInBatch(ids);
		return count +"no of records are deleted";
	}

	@Override
	public List<Movies> searchMoviesByMovie(Movies movie, boolean asc, String... props) {
		Example example = Example.of(movie);
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,props);
		List<Movies> list = movieRepo.findAll(example,sort);
		return list;
	}

	@Override
	public Movies serchMoviesById(Integer id) {
		Movies movie = movieRepo.getById(id);
		System.out.println(movie.getClass());
		if(movie==null)
			  throw new IllegalArgumentException("given movie not avaiable");
		else
		return movie;
	}
}//class

