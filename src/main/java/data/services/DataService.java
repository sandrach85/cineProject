package data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.daos.FilmDao;
import data.daos.PersonDao;
import data.daos.ThemeUsedDao;

@Service
public class DataService {
    @Autowired
    private FilmDao filmDao;
    
    @Autowired
    private PersonDao personDao;
         
    @Autowired
    private ThemeUsedDao themeUsedDao;
    
    public void deleteAll() {
        filmDao.deleteAll();
        personDao.deleteAll();
        themeUsedDao.deleteAll();
    }

}
