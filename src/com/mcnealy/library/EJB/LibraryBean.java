package com.mcnealy.library.EJB;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mcnealy.library.EIS.Media;
import com.mcnealy.library.Errors.MediaException;
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
	 * @throws MediaException
	 */
	public boolean insertMedia(Media media) throws MediaException {
		Query query = em
				.createQuery("SELECT m FROM Media m WHERE m.title = :title AND m.author = :author")
				.setParameter("title", media.getTitle()).setParameter("author", media.getAuthor());
		if (query.getSingleResult() != null)
			throw new MediaException("A media item by that title and author already exists.");
		em.persist(media);
		return true;
	}

	public void updateMedia(Media media) throws MediaException {
		Media original = em.find(Media.class, media.getId());
		if (original == null)
			throw new MediaException("Cannot be updated because media item does not exist.");
		if (original.equals(media))
			throw new MediaException("No changes to make.");
		em.merge(media);
	}

	public Media find(Integer id) {
		return em.find(Media.class, id);
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
