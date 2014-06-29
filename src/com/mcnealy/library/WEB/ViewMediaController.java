/**
 * 
 */
package com.mcnealy.library.WEB;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;

import com.mcnealy.library.EIS.Media;
import com.mcnealy.library.EJB.LibraryBean;
import com.mcnealy.library.enums.MediaType;

/**
 * @author emcnealy
 * 
 */
public class ViewMediaController {

	@EJB
	LibraryBean libraryBean;

	private MediaType type;
	private String media;
	private List<Media> mediaList;
	private String result;

	public void selectByType(AjaxBehaviorEvent event) {
		result = type.toString();
		mediaList = libraryBean.getMediaByType(type);
	}

	/**
	 * @return the type
	 */
	public MediaType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(MediaType type) {
		this.type = type;
	}

	/**
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}

	/**
	 * @return the mediaList
	 */
	public List<Media> getMediaList() {
		return mediaList;
	}

	/**
	 * @param mediaList
	 *            the mediaList to set
	 */
	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
}
