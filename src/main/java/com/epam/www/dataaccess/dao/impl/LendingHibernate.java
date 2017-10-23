package com.epam.www.dataaccess.dao.impl;

import com.epam.www.dataaccess.dao.LendingDao;
import com.epam.www.dataaccess.entity.Book;
import com.epam.www.forms.IdForm;
import com.epam.www.forms.LendingForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

/**
 * Created by Farkas on 2017.10.22..
 */
@Repository
public class LendingHibernate implements LendingDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookHibernate.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deleteLending(IdForm idForm) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> bookRoot = cq.from(Book.class);
        cq.select(bookRoot);
        cq.where(cb.equal(bookRoot.get("id"), idForm.getId()));
        Book book = entityManager.createQuery(cq).getSingleResult();
        book.setLended(false);
    }

    @Override
    @Transactional
    public void createLending(LendingForm lendingForm) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> bookRoot = cq.from(Book.class);
        cq.select(bookRoot);
        cq.where(cb.equal(bookRoot.get("id"), lendingForm.getId()));
        Book book = entityManager.createQuery(cq).getSingleResult();
        book.setLended(true);
        book.setLendedTo(lendingForm.getUser());
        LocalDate today = LocalDate.now();
        book.setLendingFromDate(today.toString());
        book.setLendingToDate(today.plusMonths(1).toString());}

    @Override
    @Transactional
    public void updateLending(IdForm idForm) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> bookRoot = cq.from(Book.class);
        cq.select(bookRoot);
        cq.where(cb.equal(bookRoot.get("id"), idForm.getId()));
        Book book = entityManager.createQuery(cq).getSingleResult();
        LocalDate until = LocalDate.parse(book.getLendingToDate());
        book.setLendingToDate(until.plusWeeks(2).toString());
    }



}
