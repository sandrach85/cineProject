package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.ThemeController;
import business.wrapper.ThemeWrapper;

@RestController
@RequestMapping(Uris.THEMES)
public class ThemeResource {
	
private ThemeController themeController;
	
	@Autowired
	public void setThemeController(ThemeController themeController){
		this.themeController = themeController;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ThemeWrapper> showThemes(){
		return themeController.showThemes();
	}
	
	@RequestMapping(value = Uris.ID,method = RequestMethod.GET)
	public ThemeWrapper showTheme(@PathVariable int id){
		ThemeWrapper theme = themeController.getTheme(id);
		return theme;
	}
	
	@RequestMapping(value = Uris.ID ,method = RequestMethod.DELETE)
    public void deleteTheme(@PathVariable int id) {
		themeController.deleteTheme(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void createTheme(@RequestBody ThemeWrapper theme){
		themeController.createTheme(theme);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateTheme(@RequestBody ThemeWrapper theme){
		themeController.updateTheme(theme.getId(), theme);
	}
}
