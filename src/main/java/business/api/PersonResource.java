package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.PersonController;
import business.wrapper.PersonWrapper;

@RestController
@RequestMapping(Uris.PERSONS)
public class PersonResource {
private PersonController personController;
	
	@Autowired
	public void setPersonController(PersonController personController){
		this.personController = personController;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PersonWrapper> showPersons(){
		return personController.showPersons();
	}
	
	@RequestMapping(value = Uris.ID,method = RequestMethod.GET)
	public PersonWrapper showPerson(@PathVariable int id){
		PersonWrapper person = personController.getPerson(id);
		return person;
	}
	
	@RequestMapping(value = Uris.ID ,method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable int id) {
		personController.deletePerson(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void createPerson(@RequestBody PersonWrapper person){
		personController.createPerson(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateInterpretation(@RequestBody PersonWrapper person){
		personController.updatePerson(person.getId(), person);
	}
}
