package com.tpe.repository;

import com.tpe.domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.module.Configuration;
import java.util.List;
import java.util.Optional;

@Repository

public class TaskRepository {


    @Autowired
    private SessionFactory sessionFactory;

    //update-save
    public void save(Task task) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(task);
        tx.commit();
        session.close();
    }


    public List<Task> getAll() {
        Session session = sessionFactory.openSession();
        List<Task> taskList =session.createQuery("FROM Task", Task.class).getResultList();
        session.close();
        return taskList;
    }


    public Optional<Task> findById(Long id){
        Session session = sessionFactory.openSession();
        Task task = session.get(Task.class, id);

        Optional<Task> optional = Optional.ofNullable(task);//Dikkat-null cikabilir
        session.close();
        return optional;
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx =session.beginTransaction();

        Optional<Task> task =findById(id);
        session.delete(task);

        tx.commit();
        session.close();

    }
}
