package org.lab.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.ExampleJava8Application;
import org.lab.model.Cinema;
import org.lab.model.MovieTheater;
import org.lab.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExampleJava8Application.class)
public class ServiceExample10statisticsImplTest {

	@Autowired
	private ServiceExample10statistics service;

	private Collection<Session> sessions = null;

    private Collection<MovieTheater> movieTheaters = null;

	@Before
	public void initialize() {
		Assert.assertNotNull(service);
		Cinema cinema = new Cinema();
		sessions = cinema.getSessions();
        movieTheaters = cinema.getMovieTheaters();
	}

	@Test
	public void getDurations() {
		Double avergePrice = service.getAveragePrice(sessions);
		Assert.assertEquals(avergePrice, 5.275, 0);
	}

	@Test
	public void getMaxNumSeatsSold() {
		Integer maxNumSeatsSold = service.getMaxNumSeatsSold(sessions);
		Assert.assertEquals(maxNumSeatsSold, 251, 0);
	}

	@Test
	public void getMinNumSeatsSold() {
		Integer minNumSeatsSold = service.getMinNumSeatsSold(sessions);
		Assert.assertEquals(minNumSeatsSold, 126, 0);
	}

	@Test
    public void getSumNumSeatsSold() {
		Long sumNumSeatsSold = service.getSumNumSeatsSold(sessions);
		Assert.assertEquals(sumNumSeatsSold, 679, 0);
	}

    @Test
    public void getSumObjectsInMovieTheaters() {
        MovieTheater movieTheaterSum = service.getSumObjectsInMovieTheaters(movieTheaters);
        Assert.assertEquals(movieTheaterSum.getNumSeats(), 677, 0);
        Assert.assertEquals(movieTheaterSum.getNumLights(), 58, 0);
        Assert.assertEquals(movieTheaterSum.getNumSpeakers(), 18, 0);
        Assert.assertEquals(movieTheaterSum.getNumLitterbins(), 13, 0);
    }

    @Test
    public void getAverageObjectsInMovieTheaters() {
        MovieTheater movieTheaterSum = service.getAverageObjectsInMovieTheaters(movieTheaters);
        Assert.assertEquals(movieTheaterSum.getNumSeats(), 225, 0);
        Assert.assertEquals(movieTheaterSum.getNumLights(), 19, 0);
        Assert.assertEquals(movieTheaterSum.getNumSpeakers(), 6, 0);
        Assert.assertEquals(movieTheaterSum.getNumLitterbins(), 4, 0);
    }

	@Test
	public void getStandardDeviationSeatsSold() {
		Double standardDeviationSeatsSold = service.getStandardDeviationSeatsSold(sessions);
		Assert.assertEquals(standardDeviationSeatsSold, 48, 0.01D);
	}

}
