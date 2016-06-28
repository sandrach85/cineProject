package data.daos;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Film;
import data.entities.Interpretation;
import data.entities.Person;

public class InterpretationDaoImpl implements InterpretationExtended{
	
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private InterpretationDao interpretationDao;
	
	private int id;
	
	@Override
	public boolean addInterpretation(Interpretation interpretation) {
		if(!existsInterpretation(interpretation)){
			interpretationDao.save(interpretation);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeInterpretation(Interpretation interpretation) {
		if(existsInterpretation(interpretation)){
			interpretationDao.delete(interpretationDao.findById(id));
			return true;
		}
		return false;
	}
	
	private boolean existsInterpretation(Interpretation interpretation){
		Person person = personDao.findById(interpretation.getActor().getId());
		Film film = filmDao.findById(interpretation.getFilm().getId());
		if(person != null && film != null){
			List<Interpretation> interpretations = interpretationDao.findAll();
			for(int i=0; i<interpretations.size();i++){
				if(interpretations.get(i).getActor().getId() == person.getId() && interpretations.get(i).getFilm().getId()==film.getId()){
					id = interpretations.get(i).getId();
					return true;
				}
			}
		}
		return false;
	}

}
