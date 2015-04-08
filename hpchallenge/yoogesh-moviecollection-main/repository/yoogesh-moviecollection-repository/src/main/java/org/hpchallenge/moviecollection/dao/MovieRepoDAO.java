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
	List<MovieRepoDO> getAllMovie();
	
	MovieRepoDO getMovieDetails(int videoId);
	
}