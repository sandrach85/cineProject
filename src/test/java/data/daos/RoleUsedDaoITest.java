package data.daos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.entities.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class RoleUsedDaoITest {
	
    @Autowired
    private RoleUsedDao roleUsedDao;
    
    @Autowired
    private PersonDao personDao;

    @Autowired
    private DaosService daosService;
    
    @Test
    public void testFindRoleByPerson() {
        List<Role> roles = roleUsedDao.findRoleByPerson(personDao.findById(0));
        assertEquals(1, roles.size());
        assertEquals(Role.ACTOR, roles.get(0));
    }
}
