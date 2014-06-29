/**
 * 
 */
package com.mcnealy.library.WEB;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.AjaxBehaviorEvent;

import com.mcnealy.library.EIS.Media;
import com.mcnealy.library.EJB.LibraryBean;
import com.mcnealy.library.enums.MediaType;

/**
 * @author emcnealy
 * 
 */
@ManagedBean(name = "viewMedia", eager = true)
@SessionScoped
public class ViewMediaController {

	@EJB
	LibraryBean libraryBean;

	private MediaType type;
	private Media media;
	private String selectedMedia;
	private List<Media> mediaList;

	public void selectByType(AjaxBehaviorEvent event) {
		mediaList = libraryBean.getMediaByType(type);
	}

	private HtmlDataTable mediaTable;

	public HtmlDataTable getMediaTable() {
		return mediaTable;
	}

	public void setMediaTable(HtmlDataTable mediaTable) {
		this.mediaTable = mediaTable;
	}

	public String edit() {
		Media media = (Media) mediaTable.getRowData();
		media.setCanEdit(true);
		return null;
	}

	public String save() {
		Media media = (Media) mediaTable.getRowData();
		media.setCanEdit(false);
		return "";
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
	public Media getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(Media media) {
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
	public String getSelectedMedia() {
		return selectedMedia;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setSelectedMedia(String selectedMedia) {
		this.selectedMedia = selectedMedia;
	}
}
