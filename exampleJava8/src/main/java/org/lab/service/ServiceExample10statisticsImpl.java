package org.lab.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.lab.model.MovieTheater;
import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample10statisticsImpl extends Predicates implements ServiceExample10statistics {

	@Override
	public Double getAveragePrice(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.summarizingDouble(Session::getPrice)).getAverage();
	}

	@Override
	public Integer getMaxNumSeatsSold(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.summarizingInt(Session::getNumSeatsSold)).getMax();
	}

	@Override
	public Integer getMinNumSeatsSold(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.summarizingInt(Session::getNumSeatsSold)).getMin();
	}

	@Override
	public Long getSumNumSeatsSold(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.summarizingInt(Session::getNumSeatsSold)).getSum();
	}

    @Override
    public MovieTheater getSumObjectsInMovieTheaters(Collection<MovieTheater> listMovieTheaters) {
        MovieTheater movieTheaterSum = new MovieTheater();

        movieTheaterSum.setNumSeats(sumObjetsInMovieTheaters(listMovieTheaters, MovieTheater::getNumSeats));
        movieTheaterSum.setNumSpeakers(sumObjetsInMovieTheaters(listMovieTheaters, MovieTheater::getNumSpeakers));
        movieTheaterSum.setNumLights(sumObjetsInMovieTheaters(listMovieTheaters, MovieTheater::getNumLights));
        movieTheaterSum.setNumLitterbins(sumObjetsInMovieTheaters(listMovieTheaters, MovieTheater::getNumLitterbins));

        return movieTheaterSum;
    }

    @Override
    public MovieTheater getAverageObjectsInMovieTheaters(Collection<MovieTheater> listMovieTheaters) {
        MovieTheater movieTheaterSum = new MovieTheater();

        movieTheaterSum.setNumSeats(averageObjetsInMovieTheaters(listMovieTheaters, MovieTheater::getNumSeats));
        movieTheaterSum.setNumSpeakers(averageObjetsInMovieTheaters(listMovieTheaters, MovieTheater::getNumSpeakers));
        movieTheaterSum.setNumLights(averageObjetsInMovieTheaters(listMovieTheaters, MovieTheater::getNumLights));
        movieTheaterSum.setNumLitterbins(averageObjetsInMovieTheaters(listMovieTheaters, MovieTheater::getNumLitterbins));

        return movieTheaterSum;
    }

	@Override
	public Double getStandardDeviationSeatsSold(Collection<Session> sessions) {
		Double averageSquare = sessions.stream().collect(Collectors.summarizingDouble(x -> x.getNumSeatsSold() * x.getNumSeatsSold()))
				.getAverage();
		Double average = sessions.stream().collect(Collectors.summarizingInt(Session::getNumSeatsSold)).getAverage();

		return Math.sqrt(averageSquare - average * average);
	}

}
