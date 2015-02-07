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
	public long getNumSessionsByDay(Collection<Session> sessions, LocalDate date) {
		logger.debug("start getNumSessionsByDay");
		Stream<Session> filter = sessions.stream().filter(
				session -> session.getDate().equals(date));
		logger.debug("end getNumSessionsByDay");
		return filter.count();
	}

	@Override
	public long getNumSessionsFull(Collection<Session> sessions) {
		logger.debug("start getNumSessionsFull");
		Stream<Session> filter = sessions.stream().filter(
				session -> session.getNumSeatsSold().equals(
						session.getMovieTheater().getNumSeats()));
		logger.debug("end getNumSessionsFull");
		return filter.count();
	}
}
