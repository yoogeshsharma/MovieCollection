/**
 * 
 */
package org.hpchallenge.moviecollection.commons.dos;

import java.util.ArrayList;
import java.util.List;


/**
 * Domain Object for Video Repository
 * 
 * @author yoogesh.sharma
 * @since 1.0
 *
 */
public class MovieRepoDO implements Comparable<MovieRepoDO>{

	private static final long serialVersionUID = 9124692114990693946L;
	
	private int 	videoId;
	private String 	videoTitle;
	private String 	videoFormat;
	private int 	videoLengthMin;
	private int 	videoLengthSec;
	private int 	videoReleaseYear;
	private int 	videoRating;
	
	@Override
	public int hashCode() {
		return this.videoId;
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((MovieRepoDO)obj).getVideoId() == this.videoId;
	}
	
	public int compareTo(MovieRepoDO obj) {
		if(this.videoId == obj.videoId){
			return 0;
		}else if(this.videoId > obj.videoId){
			return 1;
		}else{
			return -1;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovieRepoDO [videoId=" + videoId + ", videoTitle=" + videoTitle
				+ ", videoFormat=" + videoFormat + ", videoLengthMin="
				+ videoLengthMin + ", videoLengthSec=" + videoLengthSec
				+ ", videoReleaseYear=" + videoReleaseYear + ", videoRating="
				+ videoRating + "]";
	}

	/**
	 * @return the videoId
	 */
	public int getVideoId() {
		return videoId;
	}

	/**
	 * @return the videoTitle
	 */
	public String getVideoTitle() {
		return videoTitle;
	}

	/**
	 * @return the videoFormat
	 */
	public String getVideoFormat() {
		return videoFormat;
	}

	/**
	 * @return the videoLengthMin
	 */
	public int getVideoLengthMin() {
		return videoLengthMin;
	}

	/**
	 * @return the videoLengthSec
	 */
	public int getVideoLengthSec() {
		return videoLengthSec;
	}

	/**
	 * @return the videoReleaseYear
	 */
	public int getVideoReleaseYear() {
		return videoReleaseYear;
	}

	/**
	 * @return the videoRating
	 */
	public int getVideoRating() {
		return videoRating;
	}

	/**
	 * @param videoId the videoId to set
	 */
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	/**
	 * @param videoTitle the videoTitle to set
	 */
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	/**
	 * @param videoFormat the videoFormat to set
	 */
	public void setVideoFormat(String videoFormat) {
		this.videoFormat = videoFormat;
	}

	/**
	 * @param videoLengthMin the videoLengthMin to set
	 */
	public void setVideoLengthMin(int videoLengthMin) {
		this.videoLengthMin = videoLengthMin;
	}

	/**
	 * @param videoLengthSec the videoLengthSec to set
	 */
	public void setVideoLengthSec(int videoLengthSec) {
		this.videoLengthSec = videoLengthSec;
	}

	/**
	 * @param videoReleaseYear the videoReleaseYear to set
	 */
	public void setVideoReleaseYear(int videoReleaseYear) {
		this.videoReleaseYear = videoReleaseYear;
	}

	/**
	 * @param videoRating the videoRating to set
	 */
	public void setVideoRating(int videoRating) {
		this.videoRating = videoRating;
	}

}