package data.daos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.entities.Film;
import data.entities.Theme;
import data.entities.ThemeUsed;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })

public class ThemeUsedDaoITest {
	
	@Autowired
	private ThemeDao themeDao;
	
	@Autowired
	private ThemeUsedDao themeUsedDao;
	
	@Autowired
	private FilmDao filmDao;
		
	@Test
	public void testAddInterpretation(){
		int aux = themeUsedDao.findAll().size();
		Theme theme = themeDao.findById(1);
		Film film = filmDao.findById(2);
		themeUsedDao.addThemeUsed(new ThemeUsed(film, theme));
		assertEquals(aux+1, themeUsedDao.findAll().size());
	}
	
	@Test
	public void testRemoveInterpretation(){
		int aux = themeUsedDao.findAll().size();
		Theme theme = themeDao.findById(1);
		Film film = filmDao.findById(1);
		themeUsedDao.removeThemeUsed(new ThemeUsed(film,theme));
		assertEquals(aux-1, themeUsedDao.findAll().size());
	}
	
	@Test
	public void testFindById() {
		ThemeUsed themeUsed = themeUsedDao.findById(2);
		assertEquals(2, themeUsed.getFilm().getId());
	}
}
