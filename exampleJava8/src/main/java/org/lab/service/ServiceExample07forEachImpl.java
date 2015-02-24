package org.lab.service;

import java.util.Collection;

import org.lab.model.Duration;
import org.lab.model.Movie;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample07forEachImpl extends Predicates implements ServiceExample07forEach {

	@Override
	public void addDurationToMovies(Collection<Movie> movies, Integer minutes) {
		movies.stream().forEach(x -> x.setDuration(x.getDuration().addDuration(new Duration(0, minutes))));
	}

}
