package org.lab.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.Duration;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleJava8Application.class)
public class ServiceExample09collectImplTest {

	@Autowired
	private ServiceExample09collect service;

	Cinema cinema = new Cinema();

	@Test
	public void getDurations() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		List<Duration> listDuration = service.getDurations(sessions);

		Assert.assertEquals(listDuration.size(), 4);
		Assert.assertEquals(listDuration.get(0).getTotalMinutes().intValue(), 187);
		Assert.assertEquals(listDuration.get(1).getTotalMinutes().intValue(), 112);
		Assert.assertEquals(listDuration.get(2).getTotalMinutes().intValue(), 120);
		Assert.assertEquals(listDuration.get(3).getTotalMinutes().intValue(), 120);
	}

	@Test
	public void getTitles() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		Set<String> listTitles = service.getTitles(sessions);

		Assert.assertEquals(listTitles.size(), 3);
		Assert.assertTrue(listTitles.contains("King kong"));
		Assert.assertTrue(listTitles.contains("Blade Runner"));
		Assert.assertTrue(listTitles.contains("Jurassic Park"));
	}

	@Test
	public void getTitlesSorted() {
		Assert.assertNotNull(service);
		Collection<Session> sessions = cinema.getSessions();
		SortedSet<String> listTitles = service.getTitlesSorted(sessions);

		Assert.assertEquals(listTitles.size(), 3);
		int num = 0;
		for (String title : listTitles) {
			switch (num) {
			case 0:
				Assert.assertTrue(title.equals("Blade Runner"));
				break;
			case 1:
				Assert.assertTrue(title.equals("Jurassic Park"));
				break;
			case 2:
				Assert.assertTrue(title.equals("King kong"));
				break;
			}
			num++;
		}
	}
}
