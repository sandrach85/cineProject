package business.api;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import business.wrapper.ActorWrapper;

public class ActorResourceFunctionalTesting {
	
    @Test
    public void testShowCourts() {
        List<ActorWrapper> list = Arrays.asList(new RestBuilder<ActorWrapper[]>(Uris.SERVLET_MAP).path(Uris.ACTORS)
                .clazz(ActorWrapper[].class).get().build());
        assertEquals(8, list.size());
    }

}
