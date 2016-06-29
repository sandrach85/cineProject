package business.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.wrapper.ThemeWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.ThemeDao;
import data.entities.Theme;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class ThemeControllerTest {
	@Autowired
	ThemeController themeController;
	
	@Autowired
	ThemeDao themeDao;
	@Test
	public void getThemeTest(){
		ThemeWrapper theme = themeController.getTheme(1);
		assertEquals(themeDao.findById(1).getName(), theme.getName());
	}
	@Test
	public void createThemeTest(){
		int numThemes = themeDao.findAll().size();
		Theme theme = new Theme("HORROR");
		themeController.createTheme(new ThemeWrapper(theme));
		assertEquals(numThemes+1, themeDao.findAll().size());
	}
	
	@Test
	public void showThemesTest(){
		int numThemes = themeDao.findAll().size();
		assertEquals(numThemes, themeController.showThemes().size());
	}

	@Test
	public void deleteThemeTest(){
		int aux = themeDao.findAll().size();
		themeController.deleteTheme(3);
		assertEquals(aux-1, themeDao.findAll().size());
	}
	
	@Test
	public void updateThemeTest(){
		Theme theme = themeDao.findById(2);
		theme.setName("MISTERIOUS");
		ThemeWrapper themeWrapper = new ThemeWrapper(theme);
		themeController.updateTheme(2, themeWrapper);
		assertTrue(themeDao.findById(2).getName().equals("MISTERIOUS"));
	}
}
