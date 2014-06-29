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
	private boolean canEdit;
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

	/**
	 * @return the canEdit
	 */
	public boolean isCanEdit() {
		return canEdit;
	}

	/**
	 * @param canEdit
	 *            the canEdit to set
	 */
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	@Override
	public String toString() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (canEdit ? 1231 : 1237);
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((mediaId == null) ? 0 : mediaId.hashCode());
		result = prime * result + ((publicationYear == null) ? 0 : publicationYear.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (canEdit != other.canEdit)
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (mediaId == null) {
			if (other.mediaId != null)
				return false;
		} else if (!mediaId.equals(other.mediaId))
			return false;
		if (publicationYear == null) {
			if (other.publicationYear != null)
				return false;
		} else if (!publicationYear.equals(other.publicationYear))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
