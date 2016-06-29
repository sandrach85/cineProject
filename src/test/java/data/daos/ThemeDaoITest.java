package data.daos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.entities.Theme;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })

public class ThemeDaoITest {
	@Autowired
	private ThemeDao themeDao;
		
	@Test
	public void testAddInterpretation(){
		int aux = themeDao.findAll().size();
		themeDao.addTheme(new Theme("ADVENTURE"));
		assertEquals(aux+1, themeDao.findAll().size());
	}
	
	@Test
	public void testRemoveInterpretation(){
		int aux = themeDao.findAll().size();
		themeDao.removeTheme(new Theme("COMEDY"));
		assertEquals(aux-1, themeDao.findAll().size());
	}
	
	@Test
	public void testFindById() {
		Theme theme = themeDao.findById(1);
		assertEquals("ACTION", theme.getName());
	}
}
