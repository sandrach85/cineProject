package business.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.ActorController;
import business.wrapper.ActorWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.ACTORS)
public class ActorResource {

	private ActorController actorController;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<ActorWrapper> showActors() {
        return actorController.showActor();
    }
}
