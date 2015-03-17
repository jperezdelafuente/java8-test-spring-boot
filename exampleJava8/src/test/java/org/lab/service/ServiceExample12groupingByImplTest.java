package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleJava8Application.class)
public class ServiceExample12groupingByImplTest {

	@Autowired
	private ServiceExample12groupingBy service;

	private Collection<Session> sessions = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
	}

	@Test
	public void getMapSessionsByDate() {
		Map<LocalDate, List<Session>> mapSessionByDate = service.getMapSessionsByDate(sessions);

		Assert.assertEquals(2, mapSessionByDate.size());

		List<Session> listSession1 = mapSessionByDate.get(LocalDate.of(2015, 1, 15));
		Assert.assertEquals(3, listSession1.size());
		Assert.assertEquals(listSession1.get(0).getCodSession().intValue(), 1);
		Assert.assertEquals(listSession1.get(1).getCodSession().intValue(), 2);
		Assert.assertEquals(listSession1.get(2).getCodSession().intValue(), 3);

		List<Session> listSession2 = mapSessionByDate.get(LocalDate.of(2015, 1, 16));
		Assert.assertEquals(1, listSession2.size());
		Assert.assertEquals(listSession2.get(0).getCodSession().intValue(), 4);
	}

	@Test
	public void getMapSessionsByTitle() {
		Map<String, Set<Session>> mapSessionByTitle = service.getMapSessionsByTitle(sessions);

		Assert.assertEquals(3, mapSessionByTitle.size());

		Set<Session> listMovie1 = mapSessionByTitle.get("King kong");
		Assert.assertEquals(1, listMovie1.size());

		Set<Session> listMovie2 = mapSessionByTitle.get("Blade Runner");
		Assert.assertEquals(1, listMovie2.size());

		Set<Session> listMovie3 = mapSessionByTitle.get("Jurassic Park");
		Assert.assertEquals(2, listMovie3.size());
	}

	@Test
	public void getMapNumSessionsByTitle() {
		Map<String, Long> mapNumSessionByTitle = service.getMapNumSessionsByTitle(sessions);

		Assert.assertEquals(3, mapNumSessionByTitle.size());

		Assert.assertEquals(1, mapNumSessionByTitle.get("King kong"), 0);

		Assert.assertEquals(1, mapNumSessionByTitle.get("Blade Runner"), 0);

		Assert.assertEquals(2, mapNumSessionByTitle.get("Jurassic Park"), 0);
	}
}
