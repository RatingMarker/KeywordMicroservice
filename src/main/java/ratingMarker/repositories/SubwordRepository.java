package ratingMarker.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ratingMarker.models.Subword;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
 * Created by iGilga on 28.01.2016.
 */
@Repository
@Transactional
public class SubwordRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Subword subword) {
        entityManager.persist(subword);
    }

    public void update(Subword subword) {
        entityManager.merge(subword);
    }

    public void delete(Subword subword) {
        if (entityManager.contains(subword))
            entityManager.remove(subword);
        else
            entityManager.remove(entityManager.merge(subword));
    }

    public List getAll() {
        return entityManager.createQuery("from Subword").getResultList();
    }

    public Subword getById(int id) {
        return (Subword) entityManager.find(Subword.class, id);
    }
}
