package org.lab.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
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

	Cinema cinema = new Cinema();

	@Test
	public void getSessionSortedByPrice() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Stream<Session> streamSessions = service.getSessionSortedByPrice(sessions);

		Collection<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Integer numSession = 0;
		for (Session session : sessionsList) {
			switch (numSession) {
			case 0:
				Assert.assertEquals(session.getCodSession().intValue(), 3);
				break;
			case 1:
				Assert.assertEquals(session.getCodSession().intValue(), 4);
				break;
			case 2:
				Assert.assertEquals(session.getCodSession().intValue(), 1);
				break;
			case 3:
				Assert.assertEquals(session.getCodSession().intValue(), 2);
				break;
			}
			numSession++;
		}
	}

	@Test
	public void getSessionSortedByDateAndPrice() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Stream<Session> streamSessions = service.getSessionSortedByDateAndPrice(sessions);

		Collection<Session> sessionsList = streamSessions.collect(Collectors.toList());

		Integer numSession = 0;
		for (Session session : sessionsList) {
			switch (numSession) {
			case 0:
				Assert.assertEquals(session.getCodSession().intValue(), 3);
				break;
			case 1:
				Assert.assertEquals(session.getCodSession().intValue(), 1);
				break;
			case 2:
				Assert.assertEquals(session.getCodSession().intValue(), 2);
				break;
			case 3:
				Assert.assertEquals(session.getCodSession().intValue(), 4);
				break;
			}
			numSession++;
		}
	}
}
