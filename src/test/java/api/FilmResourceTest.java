package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import business.api.Uris;
import business.wrapper.InterpretationWrapper;
import business.wrapper.FilmWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.FilmDao;
import data.entities.Film;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class FilmResourceTest {
	@Autowired
	private FilmDao filmDao;	
	
	@Test
	public void getFilmTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.FILMS).path("/1").build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		InterpretationWrapper response = new RestTemplate().exchange(requestEntity, InterpretationWrapper.class).getBody();
		assertTrue(response.getActor().getId()==1);
	}
	
	@Test
	public void getFilmsTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.FILMS).build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		List<InterpretationWrapper> response = Arrays.asList(new RestTemplate().exchange(requestEntity, InterpretationWrapper[].class).getBody());
		assertEquals(response.size(), filmDao.findAll().size());
	}
	
	@Test
	public void deleteFilmTest(){
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.FILMS).pathId(1).delete().build();
		assertNull(filmDao.findById(1));
	}
	
	@Test
	public void createFilmTest(){
		FilmWrapper film = new FilmWrapper(new Film("Title", "Country",1234, "Argument"));
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.FILMS).body(film).post().build();
		assertEquals(filmDao.findAll().size(), 2);
	}
	
	@Test
	public void updateFilmTest(){
		Film p1 = filmDao.findById(1);
		FilmWrapper film = new FilmWrapper(p1);
		film.setId(2);
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.FILMS).body(film).put().build();
		assertTrue(filmDao.findById(2).getId()==2);
	}

}
