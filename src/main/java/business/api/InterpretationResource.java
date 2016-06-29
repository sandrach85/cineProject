package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.NotFoundInterpretationIdException;
import business.controllers.InterpretationController;
import business.wrapper.InterpretationWrapper;

@RestController

@RequestMapping(Uris.ACTORS)
public class InterpretationResource {
	private InterpretationController interpretationController;
	
	@Autowired
	public void setInterpretationController(InterpretationController interpretationController){
		this.interpretationController = interpretationController;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<InterpretationWrapper> showInterpretations(){
		return interpretationController.showInterpretations();
	}
	
	@RequestMapping(value = Uris.ID,method = RequestMethod.GET)
	public InterpretationWrapper showInterpretation(@PathVariable int id)throws NotFoundInterpretationIdException{
		InterpretationWrapper interpretation = interpretationController.getInterpretation(id);
		if(interpretation==null){
			throw new NotFoundInterpretationIdException("id"+id);
		}
		return interpretation;
	}
	
	@RequestMapping(value = Uris.ID ,method = RequestMethod.DELETE)
    public void deleteInterpretation(@PathVariable int id)throws NotFoundInterpretationIdException{
        if(!interpretationController.deleteInterpretation(id)){
        	throw new NotFoundInterpretationIdException("id: "+id);
        };
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void createInterpretation(@RequestBody InterpretationWrapper interpretation){
		interpretationController.createInterpretation(interpretation);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateInterpretation(@RequestBody InterpretationWrapper interpretation)throws NotFoundInterpretationIdException{
		if(interpretationController.updateInterpretation(interpretation.getId(), interpretation)){
			throw new NotFoundInterpretationIdException("id: "+interpretation.getId());
		}
	}
}
