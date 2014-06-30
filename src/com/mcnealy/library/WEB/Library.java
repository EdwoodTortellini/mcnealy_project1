/**
 * 
 */
package com.mcnealy.library.WEB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.mcnealy.library.EIS.Media;
import com.mcnealy.library.EJB.LibraryBean;
import com.mcnealy.library.Errors.MediaException;
import com.mcnealy.library.enums.MediaType;

/**
 * @author emcnealy
 * 
 */
@RequestScoped
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

	private boolean viewAddForm = false;

	/**
	 * Populates the list of MediaTypes to populate the select menu with.
	 */
	@PostConstruct
	public void init() {
		types = new ArrayList<SelectItem>();
		List<MediaType> mediaTypes = new ArrayList<MediaType>(Arrays.asList(MediaType.values()));
		for (MediaType type : mediaTypes) {
			types.add(new SelectItem("lblType", type.toString()));
		}
	}

	/**
	 * Used to add new Media items into the database.
	 * 
	 * @return nothing
	 */
	public String addMedia() {
		Media media = new Media(title, publisher, format, publicationYear, author, type);
		try {
			libraryBean.insertMedia(media);
		} catch (MediaException e) {
			persistResult = e.getMessage();
			viewAddForm = true;
			return "";
		}
		persistResult = "The media item " + media.toString() + " was added.";
		viewAddForm = true;
		return media.toString();
	}

	/**
	 * Used to populate the database to view many different types of media items.
	 * 
	 * @return nothing.
	 */
	public String addTestData() {
		List<Media> mediaList = new ArrayList<Media>();
		for (int x = 0; x < 10; x++) {
			String num = String.valueOf(x);
			Media book = new Media("Book " + num, "Publisher Name", "Hardback", "200" + num,
					"Author Name", MediaType.Book);
			Media ebook = new Media("EBook " + num, "Publisher Name", "Digital", "200" + num,
					"Author Name", MediaType.EBook);
			Media music = new Media("Music " + num, "Publisher Name", "Record", "200" + num,
					"Author Name", MediaType.Music);
			Media video = new Media("Video " + num, "Publisher Name", "DVD", "200" + num,
					"Author Name", MediaType.Video);
			mediaList.add(book);
			mediaList.add(ebook);
			mediaList.add(music);
			mediaList.add(video);
		}
		for (Media media : mediaList) {
			try {
				libraryBean.insertMedia(media);
			} catch (MediaException e) {
				persistResult = e.getMessage();
				viewAddForm = true;
				return "";
			}
		}
		viewAddForm = true;
		persistResult = mediaList.size() + " records of test data added.";
		return "";
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

	/**
	 * @return the viewAddForm
	 */
	public boolean isViewAddForm() {
		return viewAddForm;
	}

	/**
	 * @param viewAddForm
	 *            the viewAddForm to set
	 */
	public void setViewAddForm(boolean viewAddForm) {
		this.viewAddForm = viewAddForm;
	}
}
