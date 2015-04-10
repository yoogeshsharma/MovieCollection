/**
 * 
 */
package org.hpchallenge.moviecollection.dao;

import java.util.List;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;



/**
 * @author yoogesh.sharma
 * @since 1.0
 *
 */
public interface MovieRepoDAO{
	
	public List<MovieRepoDO> getAllMovie();
	
	public MovieRepoDO getMovieDetails(int videoId);
	
	public int DeleteMovie(int videoId);
	
	public int updateMovie(MovieRepoDO movieRepoDO);
	
	public int insertMovie(MovieRepoDO movieRepoDO);
	
	public int getMaxId(String tableName, String columnName);
}