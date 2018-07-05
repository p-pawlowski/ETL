package etl.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Persistable;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
class CustomizedSaveImpl<T extends Persistable> implements CustomizedSave<T> {

    @PersistenceContext
    EntityManager em;

    public <S extends T> S save(S entity) {
        Session session = em.unwrap(org.hibernate.Session.class);
//        org.hibernate.Session hibernateSession = (Session)em.getDelegate(); //JPA1.0
        if (entity.isNew()) {
            em.persist(entity);
            return entity;
        } else {
            session.update(entity);
            return entity;
        }
    }
}
