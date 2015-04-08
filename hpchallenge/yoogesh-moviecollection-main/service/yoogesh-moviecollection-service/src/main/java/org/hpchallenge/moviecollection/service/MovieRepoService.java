package org.hpchallenge.moviecollection.service;

import java.util.List;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;


/**
 * @author yoogesh.sharma
 */
public interface MovieRepoService {
	
	List<MovieRepoDO> getAllMovie();

}
