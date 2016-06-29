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
import business.wrapper.ThemeUsedWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.FilmDao;
import data.daos.ThemeUsedDao;
import data.daos.ThemeDao;
import data.entities.Film;
import data.entities.ThemeUsed;
import data.entities.Theme;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class ThemeUsedResourceTest {
	
	@Autowired
	private ThemeDao themeDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@Autowired
	private ThemeUsedDao themeUsedDao;
	
	@Test
	public void getThemeUsedTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES_USED).path("/1").build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		ThemeUsedWrapper response = new RestTemplate().exchange(requestEntity, ThemeUsedWrapper.class).getBody();
		assertTrue(response.getTheme().getId()==1);
	}
	
	@Test
	public void getThemeUsedsTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES_USED).build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		List<ThemeUsedWrapper> response = Arrays.asList(new RestTemplate().exchange(requestEntity, ThemeUsedWrapper[].class).getBody());
		assertEquals(response.size(), themeUsedDao.findAll().size());
	}
	
	@Test
	public void deleteThemeUsedTest(){
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES_USED).pathId(1).delete().build();
		assertNull(themeUsedDao.findById(1));
	}
	
	@Test
	public void createThemeUsedTest(){
		Theme t1 = themeDao.findById(1);
		Film f1 = filmDao.findById(2);
		ThemeUsedWrapper themeUsed = new ThemeUsedWrapper(new ThemeUsed(f1,t1));
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES_USED).body(themeUsed).post().build();
		assertEquals(themeUsedDao.findAll().size(), 2);
	}
	
	@Test
	public void updateThemeUsedTest(){
		Theme p1 = themeDao.findById(1);
		Film f1 = filmDao.findById(2);
		ThemeUsedWrapper interpretation = new ThemeUsedWrapper(new ThemeUsed(f1,p1));
		interpretation.setId(2);
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.THEMES_USED).body(interpretation).put().build();
		assertTrue(themeUsedDao.findById(2).getTheme().getId()==2);
	}
}
