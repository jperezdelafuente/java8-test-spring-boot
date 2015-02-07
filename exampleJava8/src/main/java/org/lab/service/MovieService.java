package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.lab.model.Session;

public interface MovieService {

	public long numMoviesByDay(Collection<Session> sessions, LocalDate date);

}
