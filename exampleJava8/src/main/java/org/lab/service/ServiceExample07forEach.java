package org.lab.service;

import java.util.Collection;

import org.lab.model.Movie;

public interface ServiceExample07forEach extends ServiceExampleDefault {

	public void addDurationToMovies(Collection<Movie> movies, Integer minutes);

}
