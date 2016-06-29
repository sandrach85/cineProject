package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.DirectionWrapper;
import data.daos.DirectionDao;
import data.entities.Direction;

@Controller
public class DirectionController {
	private DirectionDao directionDao;
	@Autowired
	public void setDirectionDao(DirectionDao directionDao){
		this.directionDao = directionDao;
	}
	
	public boolean createDirection(DirectionWrapper directionWrapper){
		Direction direction = new Direction();
		direction.setDirector(directionWrapper.getDirector());
		direction.setFilm(directionWrapper.getFilm());
		return directionDao.addDirection(direction);
	}
	
	public List<DirectionWrapper> showDirections(){
		List<DirectionWrapper> directions = new ArrayList<DirectionWrapper>();
		for(Direction direction: directionDao.findAll()){
			directions.add(new DirectionWrapper(direction));
		}
		return directions;
	}
	public boolean deleteDirection(int directionId){
		return directionDao.removeDirection(directionDao.findById(directionId));
	}
	public boolean updateDirection(int idDirection, DirectionWrapper directionWrapper){
		Direction direction = directionDao.findById(idDirection);
		direction.setDirector(directionWrapper.getDirector());
		direction.setFilm(directionWrapper.getFilm());
		directionDao.save(direction);
		return true;
	}
	public DirectionWrapper getDirection(int idDirection){
		return new DirectionWrapper(directionDao.findById(idDirection));
	}
}
