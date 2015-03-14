package org.lab.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
public class ServiceExample11partitioningByImplTest {

	@Autowired
	private ServiceExample11partitioningBy service;

	private Collection<Session> sessions = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
	}

	@Test
	public void getMapSessionsFull() {
		Map<Boolean, List<Session>> mapSessionFull = service.getMapSessionsFull(sessions);

		List<Session> listSessionFull = mapSessionFull.get(true);
		Assert.assertEquals(1, listSessionFull.size());
		Assert.assertEquals(listSessionFull.get(0).getCodSession().intValue(), 2);

		List<Session> listSessionNotFull = mapSessionFull.get(false);
		Assert.assertEquals(3, listSessionNotFull.size());
		Assert.assertEquals(listSessionNotFull.get(0).getCodSession().intValue(), 1);
		Assert.assertEquals(listSessionNotFull.get(1).getCodSession().intValue(), 3);
		Assert.assertEquals(listSessionNotFull.get(2).getCodSession().intValue(), 4);
	}

	@Test
	public void getMapSessionsOccupationPercent() {
		Map<Boolean, List<Session>> mapSessionOccupationPercent = service.getMapSessionsOccupationPercent(sessions, 65D);

		List<Session> listSessionOccupationGreater = mapSessionOccupationPercent.get(true);
		Assert.assertEquals(2, listSessionOccupationGreater.size());
		Assert.assertEquals(listSessionOccupationGreater.get(0).getCodSession().intValue(), 1);
		Assert.assertEquals(listSessionOccupationGreater.get(1).getCodSession().intValue(), 2);

		List<Session> listSessionOccupationLess = mapSessionOccupationPercent.get(false);
		Assert.assertEquals(2, listSessionOccupationLess.size());
		Assert.assertEquals(listSessionOccupationLess.get(0).getCodSession().intValue(), 3);
		Assert.assertEquals(listSessionOccupationLess.get(1).getCodSession().intValue(), 4);
	}
}
