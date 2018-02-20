package com.nc;

import com.nc.entity.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBConfig.class, EmploeeRepository.class})
@Transactional
public class AppTest {
    private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private EmploeeRepository repository;

    @Before
    @Rollback(false)
    public void setUp(){
        Employee e1 = new Employee("Ivan", "Petrovich", 5);
        Employee e2 = new Employee("Petr", "Ivanovich", 5);
        repository.save(List.of(e1, e2));
    }

    @Test
    public void t1(){
        LOG.info("----------------------Empl: "+repository.findByName("Petr"));
    }
}
