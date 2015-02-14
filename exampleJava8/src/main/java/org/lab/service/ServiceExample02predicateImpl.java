package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Stream;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample02predicateImpl extends Predicates implements ServiceExample02predicate {

	@Override
	public long getNumSessionsByDayPredicate(Collection<Session> sessions, LocalDate date) {
		Stream<Session> filter = sessions.stream().filter(equalsDate(date));
		return filter.count();
	}

	@Override
	public long getNumSessionsFullByDayPredicate(Collection<Session> sessions, LocalDate date) {
		Stream<Session> filter = sessions.stream().filter(equalsDate(date).and(isSessionFull()));
		return filter.count();
	}

}
