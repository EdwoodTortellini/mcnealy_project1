/**
 * 
 */
package com.mcnealy.library.WEB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import com.mcnealy.library.EIS.Media;
import com.mcnealy.library.EJB.LibraryBean;
import com.mcnealy.library.Errors.MediaException;
import com.mcnealy.library.enums.MediaType;

/**
 * @author emcnealy
 * 
 */
public class Library {

	@EJB
	LibraryBean libraryBean;

	private String author;
	private String title;
	private String publisher;
	private String publicationYear;
	private String format;
	private MediaType type;
	private List<SelectItem> types;

	private String persistResult;

	@PostConstruct
	public void init() {
		types = new ArrayList<SelectItem>();
		List<MediaType> mediaTypes = new ArrayList<MediaType>(Arrays.asList(MediaType.values()));
		for (MediaType type : mediaTypes) {
			types.add(new SelectItem("lblType", type.toString()));
		}
	}

	public String addMedia() {
		Media media = new Media(title, publisher, format, publicationYear, author, type);
		try {
			libraryBean.insertMedia(media);
		} catch (MediaException e) {
			persistResult = e.getMessage();
			return "";
		}
		persistResult = "The media item " + media.toString() + " was added.";
		return media.toString();
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher
	 *            the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the publicationYear
	 */
	public String getPublicationYear() {
		return publicationYear;
	}

	/**
	 * @param publicationYear
	 *            the publicationYear to set
	 */
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
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
	 * @return the types
	 */
	public List<SelectItem> getTypes() {
		return types;
	}

	/**
	 * @param types
	 *            the types to set
	 */
	public void setTypes(List<SelectItem> types) {
		this.types = types;
	}

	/**
	 * @return the persistResult
	 */
	public String getPersistResult() {
		return persistResult;
	}

	/**
	 * @param persistResult
	 *            the persistResult to set
	 */
	public void setPersistResult(String persistResult) {
		this.persistResult = persistResult;
	}
}
