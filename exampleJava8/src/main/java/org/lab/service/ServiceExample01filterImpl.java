package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Stream;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample01filterImpl implements ServiceExample01filter {

	@Override
	public long getNumSessionsByDay(Collection<Session> sessions, LocalDate date) {
		Stream<Session> filter = sessions.stream().filter(session -> session.getDate().equals(date));
		return filter.count();
	}

	@Override
	public long getNumSessionsFull(Collection<Session> sessions) {
		Stream<Session> filter = sessions.stream().filter(
				session -> session.getNumSeatsSold().equals(session.getMovieTheater().getNumSeats()));
		return filter.count();
	}
}
