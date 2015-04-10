package org.hpchallenge.moviecollection.service;

import java.util.List;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;


/**
 * @author yoogesh.sharma
 */
public interface MovieRepoService {
	
public List<MovieRepoDO> getAllMovie();
	
	public MovieRepoDO getMovieDetails(int videoId);
	
	public int DeleteMovie(int videoId);
	
	public int updateMovie(MovieRepoDO movieRepoDO);
	
	public int insertMovie(MovieRepoDO movieRepoDO);

}
