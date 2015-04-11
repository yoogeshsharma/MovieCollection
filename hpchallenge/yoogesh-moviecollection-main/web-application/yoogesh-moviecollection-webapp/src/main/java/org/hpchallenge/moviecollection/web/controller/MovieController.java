/**
 * 
 */
package org.hpchallenge.moviecollection.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;
import org.hpchallenge.moviecollection.service.MovieRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		List<MovieRepoDO> lstMovie = null;
		
		try{
			lstMovie =  movieRepoService.getAllMovie();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("listMovie", lstMovie);
		mav.setViewName("listMovie");
		return mav;
	}
	
	@RequestMapping(value = "/{id}/editMovie", method = RequestMethod.GET)
	public ModelAndView showEditMovie(@PathVariable String id, ModelAndView mav, Model model) {
		LOGGER.info("In editMovie() Method for Id : " + id);
		
		int cntr = 0;
		List<String> mvFormatList = new ArrayList<String>();
		List<Integer> mvRatingList = new ArrayList<Integer>();
		List<Integer> mvReleaseYearList = new ArrayList<Integer>();

		try{			
			//Get the details of movie to be edited
			MovieRepoDO movieDetail = movieRepoService.getMovieDetails(Integer.parseInt(id));
			
			
			mvFormatList.add("DVD");
			mvFormatList.add("Streaming");
			mvFormatList.add("VHS");
			for(cntr = 1; cntr<=5 ; cntr++){
				mvRatingList.add(cntr);	
			}
			for(cntr = 1801; cntr<2100 ; cntr++){
				mvReleaseYearList.add(cntr);	
			}

			mav.addObject("mvFormatList", mvFormatList);
			mav.addObject("mvRatingList", mvRatingList);
			mav.addObject("mvReleaseYearList", mvReleaseYearList);

			//mav.addObject("mvdetail", movieDetail);
			model.addAttribute("mvdetail", movieDetail);
			mav.setViewName("editMovie");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/{id}/editMovie", method = RequestMethod.POST)
	public ModelAndView editMovie(@ModelAttribute("mvdetail")MovieRepoDO movieRepoDO, ModelAndView mav) {
		LOGGER.info("In addMovie() Method");
		List<MovieRepoDO> lstMovie = null;
		try{
			//Add the movie
			movieRepoService.updateMovie(movieRepoDO);
			//get the list of all movie
			lstMovie =  movieRepoService.getAllMovie();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("listMovie", lstMovie);
		mav.setViewName("listMovie");
		return mav;
	}
	
	
	@RequestMapping(value = "/addMovie", method = RequestMethod.GET)
	public ModelAndView showAddMovie(ModelAndView mav) {
		LOGGER.info("In addMovie() Method");
		int cntr = 0;
		try{						
			List<String> mvFormatList = new ArrayList<String>();
			List<Integer> mvRatingList = new ArrayList<Integer>();
			List<Integer> mvReleaseYearList = new ArrayList<Integer>();
			
			
			mvFormatList.add("DVD");
			mvFormatList.add("Streaming");
			mvFormatList.add("VHS");
			
			for(cntr = 1; cntr<=5 ; cntr++){
				mvRatingList.add(cntr);	
			}
			for(cntr = 1801; cntr<2100 ; cntr++){
				mvReleaseYearList.add(cntr);	
			}

			mav.addObject("mvFormatList", mvFormatList);
			mav.addObject("mvRatingList", mvRatingList);
			mav.addObject("mvReleaseYearList", mvReleaseYearList);
			
		}catch(Exception e){
			e.printStackTrace();
		}	
		mav.setViewName("addMovie");
		return mav;
	}
	
	@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
	public ModelAndView addMovie(@ModelAttribute("movie")MovieRepoDO movieRepoDO, ModelAndView mav) {
		LOGGER.info("In addMovie() Method");
		List<MovieRepoDO> lstMovie = null;
		try{
			//Add the movie
			movieRepoService.insertMovie(movieRepoDO);
			//get the list of all movie
			lstMovie =  movieRepoService.getAllMovie();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("listMovie", lstMovie);
		mav.setViewName("listMovie");
		return mav;
	}
	
	@RequestMapping(value = "/{id}/deleteMovie", method = RequestMethod.GET)
	public @ResponseBody String deleteMovie(@PathVariable String id) {
		LOGGER.info("In deleteMovie() Method");
		try{
			//Delete the movie
			movieRepoService.DeleteMovie(Integer.parseInt(id));
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}		
		return "deleted";
	}
	
	
	@ModelAttribute("movie")
	public MovieRepoDO constructMovie() {
		return new MovieRepoDO();
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
