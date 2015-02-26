package org.lab.service;

import java.util.Collection;

import org.lab.model.Duration;
import org.lab.model.Movie;
import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample07forEachImpl extends Predicates implements ServiceExample07forEach {

	@Override
	public void addDurationToMovies(Collection<Movie> movies, int minutes) {
		movies.stream().forEach(x -> x.setDuration(x.getDuration().addDuration(new Duration(0, minutes))));
	}

	@Override
	public void addPercentAditionalPrice(Collection<Session> sessions, int percent) {
		sessions.stream().forEach(addPercentAditionalPrice(percent));
	}

}
