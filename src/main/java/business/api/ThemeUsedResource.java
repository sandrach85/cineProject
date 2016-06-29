package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.ThemeUsedController;
import business.wrapper.ThemeUsedWrapper;

@RestController

@RequestMapping(Uris.THEMES_USED)
public class ThemeUsedResource {
	private ThemeUsedController themeUsedController;
	
	@Autowired
	public void setThemeUsedController(ThemeUsedController themeUsedController){
		this.themeUsedController = themeUsedController;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ThemeUsedWrapper> showThemesUsed(){
		return themeUsedController.showThemesUsed();
	}
	
	@RequestMapping(value = Uris.ID,method = RequestMethod.GET)
	public ThemeUsedWrapper showThemeUsed(@PathVariable int id){
		ThemeUsedWrapper themeUsed = themeUsedController.getThemeUsed(id);
		return themeUsed;
	}
	
	@RequestMapping(value = Uris.ID ,method = RequestMethod.DELETE)
    public void deleteThemeUsed(@PathVariable int id) {
		themeUsedController.deleteThemeUsed(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void createThemeUsed(@RequestBody ThemeUsedWrapper themeUsed){
		themeUsedController.createThemeUsed(themeUsed);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateThemeUsed(@RequestBody ThemeUsedWrapper themeUsed){
		themeUsedController.updateThemeUsed(themeUsed.getId(), themeUsed);
	}

}
