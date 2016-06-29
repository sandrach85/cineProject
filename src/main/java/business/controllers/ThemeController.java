package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.ThemeWrapper;
import data.daos.ThemeDao;
import data.entities.Theme;

@Controller
public class ThemeController {
	private ThemeDao themeDao;
	@Autowired
	public void setThemeDao(ThemeDao themeDao){
		this.themeDao = themeDao;
	}
	public boolean createTheme(ThemeWrapper themeWrapper){
		Theme theme = new Theme();
		theme.setName(themeWrapper.getName());
		return themeDao.addTheme(theme);
	}
	
	public List<ThemeWrapper> showThemes(){
		List<ThemeWrapper> themes = new ArrayList<ThemeWrapper>();
		for(Theme theme: themeDao.findAll()){
			themes.add(new ThemeWrapper(theme));
		}
		return themes;
	}
	public boolean deleteTheme(int themeId){
		return themeDao.removeTheme(themeDao.findById(themeId));
	}
	public boolean updateTheme(int idTheme, ThemeWrapper themeWrapper){
		Theme theme = themeDao.findById(idTheme);
		theme.setName(themeWrapper.getName());
		themeDao.save(theme);
		return true;
	}
	public ThemeWrapper getTheme(int idTheme){
		return new ThemeWrapper(themeDao.findById(idTheme));
	}

}
