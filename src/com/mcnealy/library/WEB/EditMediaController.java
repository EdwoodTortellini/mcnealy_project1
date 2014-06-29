/**
 * 
 */
package com.mcnealy.library.WEB;

import javax.ejb.EJB;

import com.mcnealy.library.EIS.Media;
import com.mcnealy.library.EJB.LibraryBean;

/**
 * @author emcnealy
 * 
 */
public class EditMediaController {

	@EJB
	LibraryBean libraryBean;

	private Media media;

	public String edit() {
		media.setCanEdit(false);
		return "";
	}

	public String save() {
		media.setCanEdit(true);
		return "";
	}

	/**
	 * @return the editMedia
	 */
	public Media getMedia() {
		return media;
	}

	/**
	 * @param editMedia
	 *            the editMedia to set
	 */
	public void setMedia(Media media) {
		this.media = media;
	}

}
