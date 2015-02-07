package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Stream;

import org.lab.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public long numMoviesByDay(Collection<Session> sessions, LocalDate date) {
		logger.info("start numMoviesByDay");
		Stream<Session> filter = sessions.stream().filter(
				session -> session.getDate().equals(date));
		logger.info("end numMoviesByDay");
		return filter.count();
	}
}
