package data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.daos.FilmDao;
import data.daos.PersonDao;
@Service
public class DataService {
    @Autowired
    private FilmDao filmDao;
    
    @Autowired
    private PersonDao personDao;
    
    public void deleteAll() {
        filmDao.deleteAll();
        personDao.deleteAll();
    }

}
