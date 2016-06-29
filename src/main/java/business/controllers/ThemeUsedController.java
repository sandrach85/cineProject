package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import business.wrapper.ThemeUsedWrapper;
import data.daos.ThemeUsedDao;
import data.entities.ThemeUsed;

@Controller
public class ThemeUsedController {
	private ThemeUsedDao themeUsedDao;
	@Autowired
	public void setThemeUsedDao(ThemeUsedDao themeUsedDao){
		this.themeUsedDao = themeUsedDao;
	}
	
	public boolean createThemeUsed(ThemeUsedWrapper themeUsedWrapper){
		ThemeUsed themeUsed = new ThemeUsed();
		themeUsed.setTheme(themeUsedWrapper.getTheme());
		themeUsed.setFilm(themeUsedWrapper.getFilm());
		return themeUsedDao.addThemeUsed(themeUsed);
	}
	
	public List<ThemeUsedWrapper> showThemesUsed(){
		List<ThemeUsedWrapper> themesUsed = new ArrayList<ThemeUsedWrapper>();
		for(ThemeUsed themeUsed: themeUsedDao.findAll()){
			themesUsed.add(new ThemeUsedWrapper(themeUsed));
		}
		return themesUsed;
	}
	public boolean deleteThemeUsed(int themeUsedId){
		return themeUsedDao.removeThemeUsed(themeUsedDao.findById(themeUsedId));
	}
	public boolean updateThemeUsed(int idThemeUsed, ThemeUsedWrapper themeUsedWrapper){
		ThemeUsed themeUsed = themeUsedDao.findById(idThemeUsed);
		themeUsed.setTheme(themeUsedWrapper.getTheme());
		themeUsed.setFilm(themeUsedWrapper.getFilm());
		themeUsedDao.save(themeUsed);
		return true;
	}
	public ThemeUsedWrapper getThemeUsed(int idThemeUsed){
		return new ThemeUsedWrapper(themeUsedDao.findById(idThemeUsed));
	}
}
