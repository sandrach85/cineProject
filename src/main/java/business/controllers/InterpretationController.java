package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.InterpretationWrapper;
import data.daos.InterpretationDao;
import data.entities.Interpretation;

@Controller
public class InterpretationController {
	private InterpretationDao interpretationDao;
	
	@Autowired
	public void setInterpretationDao(InterpretationDao interpretationDao){
		this.interpretationDao = interpretationDao;
	}
	
	public boolean createInterpretation(InterpretationWrapper interpretationWrapper){
		Interpretation interpretation = new Interpretation();
		interpretation.setActor(interpretationWrapper.getActor());
		interpretation.setFilm(interpretationWrapper.getFilm());
		return interpretationDao.addInterpretation(interpretation);
	}
	
	public List<InterpretationWrapper> showInterpretations(){
		List<InterpretationWrapper> interpretations = new ArrayList<InterpretationWrapper>();
		for(Interpretation interpretation: interpretationDao.findAll()){
			interpretations.add(new InterpretationWrapper(interpretation));
		}
		return interpretations;
	}
	public boolean deleteInterpretation(int interpretationId){
		return interpretationDao.removeInterpretation(interpretationDao.findById(interpretationId));
	}
	public boolean updateInterpretation(int idInterpretation, InterpretationWrapper interpretationWrapper){
		Interpretation interpretation = interpretationDao.findById(idInterpretation);
		interpretation.setActor(interpretationWrapper.getActor());
		interpretation.setFilm(interpretationWrapper.getFilm());
		interpretationDao.save(interpretation);
		return true;
	}
	public InterpretationWrapper getInterpretation(int idInterpretation){
		return new InterpretationWrapper(interpretationDao.findById(idInterpretation));
	}
}

