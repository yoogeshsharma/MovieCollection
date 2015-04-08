/**
 * 
 */
package org.hpchallenge.moviecollection.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hpchallenge.moviecollection.commons.dos.MovieRepoDO;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author yoogesh.sharma
 *
 */
public class MovieRepoMapper implements RowMapper<MovieRepoDO> {
	
	public MovieRepoDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MovieRepoDO _videoRepoDo = new MovieRepoDO();
		_videoRepoDo.setVideoId(rs.getInt("ID"));
		_videoRepoDo.setVideoTitle(rs.getString("TITLE"));
		_videoRepoDo.setVideoFormat(rs.getString("FORMAT"));
		_videoRepoDo.setVideoLengthMin(rs.getInt("LENGTH_MIN"));
		_videoRepoDo.setVideoLengthSec(rs.getInt("LENGTH_SEC"));
		_videoRepoDo.setVideoReleaseYear(rs.getInt("RELEASE"));
		_videoRepoDo.setVideoRating(rs.getInt("RATING"));
		return _videoRepoDo;
	}
}
