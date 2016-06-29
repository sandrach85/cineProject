package data.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Film;
import data.entities.Theme;
import data.entities.ThemeUsed;

public class ThemeUsedDaoImpl implements ThemeUsedExtended {
	
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private ThemeDao themeDao;
	@Autowired
	private ThemeUsedDao themeUsedDao;
	
	private int id;
	
	@Override
	public boolean addThemeUsed(ThemeUsed themeUsed) {
		if(!existsThemeUsed(themeUsed)){
			themeUsedDao.save(themeUsed);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeThemeUsed(ThemeUsed themeUsed) {
		if(existsThemeUsed(themeUsed)){
			themeUsedDao.delete(themeUsedDao.findById(id));
			return true;
		}
		return false;
	}
	
	private boolean existsThemeUsed(ThemeUsed themeUsed){
		Theme theme= themeDao.findById(themeUsed.getTheme().getId());
		Film film = filmDao.findById(themeUsed.getFilm().getId());
		if(theme != null && film != null){
			List<ThemeUsed> themeUseds = themeUsedDao.findAll();
			for(int i=0; i<themeUseds.size();i++){
				if(themeUseds.get(i).getTheme().getId() == theme.getId() && themeUseds.get(i).getFilm().getId()==film.getId()){
					id = themeUseds.get(i).getId();
					return true;
				}
			}
		}
		return false;
	}

}
