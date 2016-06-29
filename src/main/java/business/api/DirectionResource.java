package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.NotFoundDirectionIdException;
import business.controllers.DirectionController;
import business.wrapper.DirectionWrapper;

@RestController

@RequestMapping(Uris.DIRECTORS)
public class DirectionResource {
	private DirectionController directionController;
	
	@Autowired
	public void setDirectionController(DirectionController directionController){
		this.directionController = directionController;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DirectionWrapper> showDirections(){
		return directionController.showDirections();
	}
	
	@RequestMapping(value = Uris.ID,method = RequestMethod.GET)
	public DirectionWrapper showDirection(@PathVariable int id)throws NotFoundDirectionIdException{
		DirectionWrapper direction = directionController.getDirection(id);
		if(direction == null){
			throw new NotFoundDirectionIdException("id: "+id);
		}
		return direction;
	}
	
	@RequestMapping(value = Uris.ID ,method = RequestMethod.DELETE)
    public void deleteDirection(@PathVariable int id) throws NotFoundDirectionIdException{
		if(!directionController.deleteDirection(id)){
			throw new NotFoundDirectionIdException("id: "+id);
		}
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void createDirection(@RequestBody DirectionWrapper direction){
		directionController.createDirection(direction);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateTheme(@RequestBody DirectionWrapper direction)throws NotFoundDirectionIdException{
		if(!directionController.updateDirection(direction.getId(), direction)){
			throw new NotFoundDirectionIdException("id: "+direction.getId());
		}
	}
}
