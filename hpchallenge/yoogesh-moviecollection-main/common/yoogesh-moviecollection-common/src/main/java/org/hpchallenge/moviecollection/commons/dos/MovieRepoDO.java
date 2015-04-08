/**
 * 
 */
package org.hpchallenge.moviecollection.commons.dos;


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
	private String 	videoLength;
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
				+ ", videoFormat=" + videoFormat + ", videoLength="
				+ videoLength 
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
	 * @return the videoLength
	 */
	public String getVideoLength() {
		return videoLength;
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
	 * @param videoLength the videoLength to set
	 */
	public void setVideoLength(String videoLength) {
		this.videoLength = videoLength;
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