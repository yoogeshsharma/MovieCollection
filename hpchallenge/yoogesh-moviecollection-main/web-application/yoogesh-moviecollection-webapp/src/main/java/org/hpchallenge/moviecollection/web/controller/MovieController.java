/**
 * 
 */
package org.hpchallenge.moviecollection.web.controller;

import java.util.List;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;
import org.hpchallenge.moviecollection.dao.exception.DAOException;
import org.hpchallenge.moviecollection.exception.ServiceException;
import org.hpchallenge.moviecollection.service.MovieRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yoogesh.sharma
 *
 */
@Controller
public class MovieController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MovieController.class);
	
	@Autowired
	private MovieRepoService movieRepoService;
	
	@RequestMapping(value = "/getAllMovie", method = RequestMethod.GET)
	public ModelAndView getAllMovie(ModelAndView mav) {
		LOGGER.info("In getAllMovie() Method");		

		try{
			List<MovieRepoDO> lstMovie =  movieRepoService.getAllMovie();
			mav.addObject("listMovie", lstMovie);
			
			mav.setViewName("listMovie");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/{id}/editMovie", method = RequestMethod.GET)
	public ModelAndView editMovie(@PathVariable String id, ModelAndView mav) {
		LOGGER.info("In editMovie() Method for Id : " + id);		

		try{			
			//Get the details of movie to be edited
			MovieRepoDO movieDetail = movieRepoService.getMovieDetails(Integer.parseInt(id));
			
			mav.addObject("mvdetail", movieDetail);
			mav.setViewName("editMovie");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/addMovie", method = RequestMethod.GET)
	public ModelAndView addMovie(ModelAndView mav) {
		LOGGER.info("In addMovie() Method");		
		try{						
			mav.setViewName("addMovie");
		}catch(Exception e){
			e.printStackTrace();
		}		
		return mav;
	}
	
	
	

	/**
	 * @return the movieRepoService
	 */
	public MovieRepoService getMovieRepoService() {
		return movieRepoService;
	}

	/**
	 * @param movieRepoService the movieRepoService to set
	 */
	public void setMovieRepoService(MovieRepoService movieRepoService) {
		this.movieRepoService = movieRepoService;
	}
}
