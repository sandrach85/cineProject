package business.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import business.controllers.ActorController;

@Controller
public class ActorPresenter {

	@Autowired
    private ActorController actorController;
	
	public ActorPresenter (){
		
	}

	@RequestMapping("/home")
    public String home(Model model) {
        return "/home";
    }
   
	 @RequestMapping("/list-actors")
	    public String listActors(Model model) {
	        model.addAttribute("courtList", actorController.showActor());
	        return "showActorList";
	    }
}
