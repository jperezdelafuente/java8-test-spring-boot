package org.lab.service;

import java.util.Collection;

import org.lab.model.Movie;
import org.lab.model.Session;

public interface ServiceExample07forEach extends ServiceExampleDefault {

	public void addDurationToMovies(Collection<Movie> movies, int minutes);

	public void addPercentAditionalPrice(Collection<Session> sessions, int percent);

}
