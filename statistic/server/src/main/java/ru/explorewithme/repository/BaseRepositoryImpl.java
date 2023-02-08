package ru.explorewithme.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import ru.explorewithme.model.QStats;

import javax.persistence.EntityManager;

public abstract class BaseRepositoryImpl<T, id> extends SimpleJpaRepository<T, id> implements BaseRepository<T, id> {

    EntityManager em;
    JPAQueryFactory jpaQueryFactory;
    protected final QStats stats = QStats.stats;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

}
