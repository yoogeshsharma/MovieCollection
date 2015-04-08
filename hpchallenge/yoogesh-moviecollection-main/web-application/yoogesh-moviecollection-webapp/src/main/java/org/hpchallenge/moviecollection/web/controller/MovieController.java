/**
 * 
 */
package org.hpchallenge.moviecollection.web.controller;

import java.util.List;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;
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
			//Call a method for deleting a movie
			
			//Reload the move list
			List<MovieRepoDO> lstMovie =  movieRepoService.getAllMovie();
			mav.addObject("listMovie", lstMovie);
			mav.setViewName("listMovie");
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
