/**
 * 
 */
package org.hpchallenge.moviecollection.services.impl;

import java.util.List;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;
import org.hpchallenge.moviecollection.dao.MovieRepoDAO;
import org.hpchallenge.moviecollection.dao.exception.DAOException;
import org.hpchallenge.moviecollection.exception.ServiceException;
import org.hpchallenge.moviecollection.service.MovieRepoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yoogesh.sharma
 *
 */
public class MovieRepoServiceImpl implements MovieRepoService{
	
	@Autowired
	private MovieRepoDAO videoRepoDAO; 
	
	public List<MovieRepoDO> getAllMovie() {
		try{
			return videoRepoDAO.getAllMovie();
		}catch(DAOException e){
			throw new ServiceException(e);
		}
	}

	/**
	 * @return the videoRepoDAO
	 */
	public MovieRepoDAO getVideoRepoDAO() {
		return videoRepoDAO;
	}

	/**
	 * @param videoRepoDAO the videoRepoDAO to set
	 */
	public void setVideoRepoDAO(MovieRepoDAO videoRepoDAO) {
		this.videoRepoDAO = videoRepoDAO;
	}
}