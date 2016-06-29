package business.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.wrapper.ThemeUsedWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.FilmDao;
import data.daos.ThemeUsedDao;
import data.daos.ThemeDao;
import data.entities.Film;
import data.entities.ThemeUsed;
import data.entities.Theme;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class ThemeUsedControllerTest {
	@Autowired
	ThemeUsedController themeUsedController;
	
	@Autowired
	ThemeUsedDao themeUsedDao;
	
	@Autowired
	ThemeDao themeDao;
	
	@Autowired
	FilmDao filmDao;
	
	@Test
	public void getThemeUsedTest(){
		ThemeUsedWrapper themeUsed = themeUsedController.getThemeUsed(1);
		assertEquals(themeUsedDao.findById(1).getTheme().getName(), themeUsed.getTheme().getName());
		assertEquals(themeUsedDao.findById(1).getFilm(), themeUsed.getFilm());
	}
	@Test
	public void createThemeUsedTest(){
		int numThemeUseds = themeUsedDao.findAll().size();
		Theme theme = themeDao.findById(1);
		Film film = filmDao.findById(2);
		themeUsedController.createThemeUsed(new ThemeUsedWrapper(new ThemeUsed(film,theme)));
		assertEquals(numThemeUseds+1, themeUsedDao.findAll().size());
	}
	
	@Test
	public void showThemeUsedsTest(){
		int numThemeUseds = themeUsedDao.findAll().size();
		assertEquals(numThemeUseds, themeUsedController.showThemesUsed().size());
	}

	@Test
	public void deleteThemeUsedTest(){
		int aux = themeUsedDao.findAll().size();
		themeUsedController.deleteThemeUsed(1);
		assertEquals(aux-1, themeUsedDao.findAll().size());
	}
	
	@Test
	public void updateThemeUsedTest(){
		ThemeUsed themeUsed = themeUsedDao.findById(2);
		themeUsed.setFilm(filmDao.findById(2));
		ThemeUsedWrapper themeUsedWrapper = new ThemeUsedWrapper(themeUsed);
		themeUsedController.updateThemeUsed(2, themeUsedWrapper);
		assertTrue(themeUsedDao.findById(2).getFilm().getId() == 2);
	}

}
