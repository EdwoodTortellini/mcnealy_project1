package com.mcnealy.library.EJB;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mcnealy.library.EIS.Media;
import com.mcnealy.library.enums.MediaType;

/**
 * Session Bean implementation class LibraryBean
 */
@Stateless
@LocalBean
public class LibraryBean {

	@PersistenceContext
	EntityManager em;

	public LibraryBean() {

	}

	/**
	 * Insert a new Media item into the database.
	 * 
	 * @param media
	 *            The media item to insert.
	 */
	public void insertMedia(Media media) {
		Media entity = new Media();
		entity.setAuthor(media.getAuthor());
		entity.setFormat(media.getFormat());
		entity.setPublicationYear(media.getPublicationYear());
		entity.setPublisher(media.getPublisher());
		entity.setTitle(media.getTitle());
		entity.setType(media.getType());
		em.persist(entity);
	}

	/**
	 * Use a named query to select all Media items from the database.
	 * 
	 * @return All Media items from the database.
	 */
	public List<Media> getAllMedia() {
		Query query = em.createNamedQuery("selectAllMedia");
		return query.getResultList();
	}

	public List<Media> getMediaByType(MediaType type) {
		Query query = em.createNamedQuery("selectAllMediaByType");
		query.setParameter("type", type);
		return query.getResultList();
	}

	public void createMediaTypes() {
		Media music = new Media("Discovering the Waterfront", "publisher", "format", "2005",
				"Silverstein", MediaType.Music);
		em.persist(music);
	}

}
