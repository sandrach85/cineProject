package data.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Direction;
import data.entities.Film;
import data.entities.Person;

public class DirectionDaoImpl implements DirectionExtended {
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private DirectionDao directionDao;
	
	private int id;
	@Override
	public boolean addDirection(Direction direction) {
		if(!existsDirection(direction)){
			directionDao.save(direction);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeDirection(Direction direction) {
		if(existsDirection(direction)){
			directionDao.delete(directionDao.findById(id));
			return true;
		}
		return false;
	}
	private boolean existsDirection(Direction direction){
		Person person = personDao.findById(direction.getDirector().getId());
		Film film = filmDao.findById(direction.getFilm().getId());
		if(person != null && film != null){
			List<Direction> directions = directionDao.findAll();
			for(int i=0; i<directions.size();i++){
				if(directions.get(i).getDirector().getId() == person.getId() && directions.get(i).getFilm().getId()==film.getId()){
					id = directions.get(i).getId();
					return true;
				}
			}
		}
		return false;
	}
	

}
