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
import business.wrapper.PersonWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.PersonDao;
import data.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class PersonResourceTest {
	@Autowired
	private PersonDao personDao;	
	
	@Test
	public void getPersonTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.PERSONS).path("/1").build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		InterpretationWrapper response = new RestTemplate().exchange(requestEntity, InterpretationWrapper.class).getBody();
		assertTrue(response.getActor().getId()==1);
	}
	
	@Test
	public void getPersonsTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.PERSONS).build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		List<InterpretationWrapper> response = Arrays.asList(new RestTemplate().exchange(requestEntity, InterpretationWrapper[].class).getBody());
		assertEquals(response.size(), personDao.findAll().size());
	}
	
	@Test
	public void deletePersonTest(){
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.PERSONS).pathId(1).delete().build();
		assertNull(personDao.findById(1));
	}
	
	@Test
	public void createPersonTest(){
		PersonWrapper person = new PersonWrapper(new Person("NName", "NCountry", "NDate"));
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.PERSONS).body(person).post().build();
		assertEquals(personDao.findAll().size(), 2);
	}
	
	@Test
	public void updatePersonTest(){
		Person p1 = personDao.findById(1);
		PersonWrapper person = new PersonWrapper(p1);
		person.setId(2);
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.PERSONS).body(person).put().build();
		assertTrue(personDao.findById(2).getId()==2);
	}

}
