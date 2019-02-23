package org.lab.service;

import java.util.Collection;
import java.util.Optional;

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
public class ServiceExample04minMaxComparatorImplTest {

	@Autowired
	private ServiceExample04minMaxComparator service;

	private Collection<Session> sessions = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
	}

	@Test
	public void getSessionMinPrice() {
		Optional<Session> session = service.getSessionMinPrice(sessions);
		Assert.assertEquals(true, session.isPresent());
		Assert.assertTrue(session.get().getMovie().getTitle().equals("Jurassic Park"));
	}

	@Test
	public void getSessionMaxPrice() {
		Optional<Session> session = service.getSessionMaxPrice(sessions);
		Assert.assertEquals(true, session.isPresent());
		Assert.assertTrue(session.get().getMovie().getTitle().equals("Blade Runner"));
	}

	@Test
	public void getSessionMaxOccupation() {
		Optional<Session> session = service.getSessionMaxOccupation(sessions);
		Assert.assertEquals(true, session.isPresent());
		Assert.assertTrue(session.get().getMovieTheater().getCode().equals("MT2"));
	}

}
