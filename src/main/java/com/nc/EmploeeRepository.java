package com.nc;

import com.nc.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmploeeRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Employee> findByName(String name){
        Query query = em.createQuery("select s from Employee as s where s.firstName=:name");
        return query.setParameter("name", name).getResultList();

    }

    public void save(List<Employee> employees) {
        employees.forEach(s-> em.persist(s));
    }
}
