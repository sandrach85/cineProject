package data.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Theme;

public class ThemeDaoImpl implements ThemeExtended {
	@Autowired
	private ThemeDao themeDao;
	
	private int id;
	
	@Override
	public boolean addTheme(Theme theme) {
		if(!existsTheme(theme)){
			themeDao.save(theme);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeTheme(Theme theme) {
		if(existsTheme(theme)){
			Theme t = themeDao.findById(id);
			themeDao.delete(t);
			return true;
		}
		return false;
	}
	private boolean existsTheme(Theme theme){
			List<Theme> themes = themeDao.findAll();
			for(int i=0; i<themes.size();i++){
				if(themes.get(i).getName().equals(theme.getName())){
					id = themes.get(i).getId();
					System.out.println(id);
					return true;
				}
		}
		return false;
	}
	

}
