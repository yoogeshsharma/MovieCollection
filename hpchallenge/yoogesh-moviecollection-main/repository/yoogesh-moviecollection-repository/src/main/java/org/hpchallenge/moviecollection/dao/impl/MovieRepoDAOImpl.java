/**
 * 
 */
package org.hpchallenge.moviecollection.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;
import org.hpchallenge.moviecollection.dao.MovieRepoDAO;
import org.hpchallenge.moviecollection.dao.exception.DAOException;
import org.hpchallenge.moviecollection.dao.mapper.MovieRepoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author yoogesh.sharma
 * @since 1.0
 *
 */
@Repository
public class MovieRepoDAOImpl implements MovieRepoDAO{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MovieRepoDAOImpl.class);

	@Autowired
	private DataSource dataSource;
	
	@SuppressWarnings (value="unchecked")
	public List<MovieRepoDO> getAllMovie() {
		LOGGER.info("In getVideoRepoDO() Method");
		
		final String query = "SELECT * FROM MOVIE M ";
		
		try {
			return (List<MovieRepoDO>) (Object) new JdbcTemplate(dataSource)
					.query(query,new MovieRepoMapper());
		} catch (Throwable e) {
			LOGGER.error("Exception occur in getAllMovie()", e);
			throw new DAOException(e);
		}
	}
	
	public MovieRepoDO getMovieDetails(int videoId) {
		LOGGER.info("In getMovieDetails(int) Method");
		
		final String query = "SELECT * FROM MOVIE M WHERE M.ID = ?";
		MovieRepoDO  movieRepoDo = null;
		
		try {
			movieRepoDo = new JdbcTemplate(dataSource).queryForObject(query,
					new Object[] {videoId},new MovieRepoMapper());
		} catch (Throwable e) {
			LOGGER.error("Exception occur in getMovieDetails(int)", e);
			throw new DAOException(e);
		}
		return movieRepoDo;
	}
	
	public int DeleteMovie(int videoId) {
		LOGGER.info("In DeleteMovie(int) Method");
		int delStatus = 0;
		String sqlQuery = null;
		try{
			sqlQuery = "DELETE FROM MOVIE WHERE ID = ?";
			delStatus =  new JdbcTemplate(dataSource).update(sqlQuery,new Object[]{videoId});
		}
		catch (Throwable e) {
			LOGGER.error("Exception occur in DeleteMovie(int)", e);
			throw new DAOException(e);
		}		
		return delStatus;
	}
	
	public int updateMovie(MovieRepoDO movieRepoDO) {
		LOGGER.info("In updateMovie(MovieRepoDO) Method");
		int updateStatus = 0;
		String sqlQuery = null;
		try{
			sqlQuery = "UPDATE MOVIE SET  TITLE=?, FORMATS=?, LENGTH_MIN=?, " +
					"LENGTH_SEC=?, RELEASES=?, RATING=? WHERE ID = ?";
			
			updateStatus = new JdbcTemplate(dataSource).update(sqlQuery, new Object[]{movieRepoDO.getVideoTitle(),
					movieRepoDO.getVideoFormat(),movieRepoDO.getVideoLengthMin(),movieRepoDO.getVideoLengthSec(),
					movieRepoDO.getVideoReleaseYear(),movieRepoDO.getVideoRating(),movieRepoDO.getVideoId()});
			
		}catch(Exception e){
			LOGGER.error("Exception occur in updateMovie(MovieRepoDO)", e);
			throw new DAOException(e);
		}
		
		return updateStatus;
	}
	
	public int insertMovie(MovieRepoDO movieRepoDO) {
		LOGGER.info("In insertMovie(MovieRepoDO) Method");
		String sqlQuery = null;
		int id = 0;
		int insertStatus = 0;
		try{
			sqlQuery = "INSERT INTO MOVIE (ID,TITLE,FORMATS,RELEASES,RATING,LENGTH_MIN,LENGTH_SEC) VALUES(?,?,?,?,?,?,?)";
			id = getMaxId("Movie", "ID");
			
			insertStatus = new JdbcTemplate(dataSource).update(sqlQuery, new Object[]{id,movieRepoDO.getVideoTitle(),
					movieRepoDO.getVideoFormat(),movieRepoDO.getVideoReleaseYear(),movieRepoDO.getVideoRating(),
					movieRepoDO.getVideoLengthMin(),movieRepoDO.getVideoLengthSec()});
			
		}catch(Exception e){
			LOGGER.error("Exception occur in insertMovie(MovieRepoDO)", e);
			throw new DAOException(e);
		}
		
		return insertStatus;
	}
	
	public int getMaxId(String tableName, String columnName) {
		LOGGER.info("In getMaxId(string,string) Method");
		String sqlQuery = null;
		int maxId = 0;
		try{
			sqlQuery = "Select max(" + columnName + ") From " + tableName;
			maxId = new JdbcTemplate(dataSource).queryForInt(sqlQuery);
		}catch(Exception e){
			maxId = 0;
		}
		return (maxId+1);
	}
	
	

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
