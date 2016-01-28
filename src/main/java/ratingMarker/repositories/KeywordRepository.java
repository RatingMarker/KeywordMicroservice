package ratingMarker.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ratingMarker.models.Keyword;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class KeywordRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Keyword keyword) {
        entityManager.persist(keyword);
    }

    public void update(Keyword keyword) {
        entityManager.merge(keyword);
    }

    public void delete(Keyword keyword) {
        if (entityManager.contains(keyword))
            entityManager.remove(keyword);
        else
            entityManager.remove(entityManager.merge(keyword));
    }

    public List getAll() {
        return entityManager.createQuery("from Keyword").getResultList();
    }

    public Keyword getById(int id) {
        return (Keyword) entityManager.find(Keyword.class, id);
    }
}
