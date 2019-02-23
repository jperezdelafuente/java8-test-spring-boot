package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExampleJava8Application.class)
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
	public void getSortedMapSessionsByDate() {
		SortedMap<LocalDate, List<Session>> sortedMapSessionByDate = service.getSortedMapSessionsByDate(sessions);

		Assert.assertEquals(2, sortedMapSessionByDate.size());

		List<Session> listSession1 = sortedMapSessionByDate.get(LocalDate.of(2015, 1, 15));
		Assert.assertEquals(3, listSession1.size());
		Assert.assertEquals(listSession1.get(0).getCodSession().intValue(), 1);
		Assert.assertEquals(listSession1.get(1).getCodSession().intValue(), 2);
		Assert.assertEquals(listSession1.get(2).getCodSession().intValue(), 3);

		List<Session> listSession2 = sortedMapSessionByDate.get(LocalDate.of(2015, 1, 16));
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

	@Test
	public void getMapTitleByNumSessions() {
		Map<Long, Set<String>> mapTitleByNumSession = service.getMapTitleBypNumSessions(sessions);

		Assert.assertEquals(2, mapTitleByNumSession.size());

		Assert.assertEquals(2, mapTitleByNumSession.get(1L).size());
		Assert.assertEquals(1, mapTitleByNumSession.get(2L).size());
	}

	@Test
	public void getMapPricesByTitle() {
		Map<String, List<Double>> mapMapPricesByTitle = service.getMapPricesByTitle(sessions);

		Assert.assertEquals(3, mapMapPricesByTitle.size());

		Assert.assertEquals(1, mapMapPricesByTitle.get("King kong").size());
		Assert.assertEquals(5.50, mapMapPricesByTitle.get("King kong").get(0), 0);

		Assert.assertEquals(1, mapMapPricesByTitle.get("Blade Runner").size());
		Assert.assertEquals(6.50, mapMapPricesByTitle.get("Blade Runner").get(0), 0);

		Assert.assertEquals(2, mapMapPricesByTitle.get("Jurassic Park").size());
		Assert.assertEquals(4.50, mapMapPricesByTitle.get("Jurassic Park").get(0), 0);
		Assert.assertEquals(4.60, mapMapPricesByTitle.get("Jurassic Park").get(1), 0);
	}

	@Test
	public void getMapAveragePriceByTitle() {
		Map<String, Double> mapMapAveragePriceByTitle = service.getMapAveragePriceByTitle(sessions);

		Assert.assertEquals(3, mapMapAveragePriceByTitle.size());

		Assert.assertEquals(5.50, mapMapAveragePriceByTitle.get("King kong"), 0);

		Assert.assertEquals(6.50, mapMapAveragePriceByTitle.get("Blade Runner"), 0);

		Assert.assertEquals(4.55, mapMapAveragePriceByTitle.get("Jurassic Park"), 0);
	}

	@Test
	public void getMapTakingsByTitle() {
		Map<LocalDate, Double> mapMapTakingsByTitle = service.getMapTakingsByTitle(sessions);

		Assert.assertEquals(2, mapMapTakingsByTitle.size());

		Assert.assertEquals(2879, mapMapTakingsByTitle.get(LocalDate.of(2015, 1, 15)), 0);

		Assert.assertEquals(694.6, mapMapTakingsByTitle.get(LocalDate.of(2015, 1, 16)), 0.01);

	}
}
