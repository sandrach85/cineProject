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
import business.wrapper.ThemeWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.ThemeDao;
import data.entities.Theme;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class ThemeResourceTest {
	@Autowired
	private ThemeDao themeDao;	
	
	@Test
	public void getThemeTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES).path("/1").build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		InterpretationWrapper response = new RestTemplate().exchange(requestEntity, InterpretationWrapper.class).getBody();
		assertTrue(response.getActor().getId()==1);
	}
	
	@Test
	public void getThemesTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES).build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		List<InterpretationWrapper> response = Arrays.asList(new RestTemplate().exchange(requestEntity, InterpretationWrapper[].class).getBody());
		assertEquals(response.size(), themeDao.findAll().size());
	}
	
	@Test
	public void deleteThemeTest(){
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES).pathId(1).delete().build();
		assertNull(themeDao.findById(1));
	}
	
	@Test
	public void createThemeTest(){
		ThemeWrapper theme = new ThemeWrapper(new Theme("THEME"));
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES).body(theme).post().build();
		assertEquals(themeDao.findAll().size(), 2);
	}
	
	@Test
	public void updateThemeTest(){
		Theme p1 = themeDao.findById(1);
		ThemeWrapper theme = new ThemeWrapper(p1);
		theme.setId(2);
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES).body(theme).put().build();
		assertTrue(themeDao.findById(2).getId()==2);
	}

}
