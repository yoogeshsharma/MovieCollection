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
			LOGGER.error("Exception occur in getMovieDetails(int) + ", e);
			throw new DAOException(e);
		}
		return movieRepoDo;
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
