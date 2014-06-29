package com.mcnealy.library.EIS;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.mcnealy.library.enums.MediaType;

/**
 * Entity implementation class for Entity: MediaEntity
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "selectAllMedia", query = "SELECT t FROM Media t"),
		@NamedQuery(name = "selectAllMediaByType", query = "SELECT t FROM Media t WHERE t.type = :type") })
public class Media implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mediaId;
	private String title;
	private String publisher;
	private String format;
	private String publicationYear;
	private String author;
	@Enumerated(EnumType.STRING)
	private MediaType type;
	private static final long serialVersionUID = 1L;

	public Media() {
		super();
	}

	/**
	 * @param title
	 * @param publisher
	 * @param format
	 * @param publicationYear
	 * @param author
	 * @param type
	 */
	public Media(String title, String publisher, String format, String publicationYear,
			String author, MediaType type) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.format = format;
		this.publicationYear = publicationYear;
		this.author = author;
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return mediaId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.mediaId = id;
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

	@Override
	public String toString() {
		return "Title: " + title;
	}

}
