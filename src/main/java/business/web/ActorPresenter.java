package business.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import business.controllers.ActorController;
import business.wrapper.ActorWrapper;

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
	        model.addAttribute("courtList", actorController.showActors());
	        return "showActorList";
	    }
	 	 
	 @RequestMapping(value = "/create-actor", method = RequestMethod.GET)
	    public String createActor(Model model) {
	        model.addAttribute("actor", new ActorWrapper());
	        return "createCourt";
	    }
	 
	 @RequestMapping(value = "/create-actor", method = RequestMethod.POST)
    public String createActorSubmit(@ModelAttribute(value = "actor") ActorWrapper actor, Model model) {
        actorController.createActor(actor);
        this.createActor(model);
        return "/createActorSuccess";

    }
}
