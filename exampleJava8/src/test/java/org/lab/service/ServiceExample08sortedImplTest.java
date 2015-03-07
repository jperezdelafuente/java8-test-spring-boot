package org.lab.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class ServiceExample08sortedImplTest {

	@Autowired
	private ServiceExample08sorted service;

	private Collection<Session> sessions = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
	}

	@Test
	public void getSessionSortedByPrice() {
		boolean reversed = false;
		Stream<Session> streamSessions = service.getSessionSortedByPrice(sessions, reversed);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 3);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 4);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 2);
	}

	@Test
	public void getSessionSortedByPriceDesc() {
		boolean reversed = true;
		Stream<Session> streamSessions = service.getSessionSortedByPrice(sessions, reversed);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 2);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 4);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 3);
	}

	@Test
	public void getSessionSortedByDateAndPrice() {
		boolean reversedDate = false;
		boolean reversedPrice = false;
		Stream<Session> streamSessions = service.getSessionSortedByDateAndPrice(sessions, reversedDate, reversedPrice);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 3);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 2);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 4);
	}

	@Test
	public void getSessionSortedByDateAndPriceDesc() {
		boolean reversedDate = false;
		boolean reversedPrice = true;
		Stream<Session> streamSessions = service.getSessionSortedByDateAndPrice(sessions, reversedDate, reversedPrice);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 2);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 3);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 4);
	}

	@Test
	public void getSessionSortedByDateDescAndPrice() {
		boolean reversedDate = true;
		boolean reversedPrice = false;
		Stream<Session> streamSessions = service.getSessionSortedByDateAndPrice(sessions, reversedDate, reversedPrice);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 4);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 3);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 2);
	}

	@Test
	public void getSessionSortedByDateDescAndPriceDesc() {
		boolean reversedDate = true;
		boolean reversedPrice = true;
		Stream<Session> streamSessions = service.getSessionSortedByDateAndPrice(sessions, reversedDate, reversedPrice);

		List<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Assert.assertEquals(sessionsList.get(0).getCodSession().intValue(), 4);
		Assert.assertEquals(sessionsList.get(1).getCodSession().intValue(), 2);
		Assert.assertEquals(sessionsList.get(2).getCodSession().intValue(), 1);
		Assert.assertEquals(sessionsList.get(3).getCodSession().intValue(), 3);
	}
}
