package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Stream;

import org.lab.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample02predicateImpl extends Predicates implements ServiceExample02predicate {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public long getNumSessionsByDayPredicate(Collection<Session> sessions, LocalDate date) {
		logger.debug("start getNumSessionsByDayPredicate");
		Stream<Session> filter = sessions.stream().filter(equalsDate(date));
		logger.debug("end getNumSessionsByDayPredicate");
		return filter.count();
	}

	@Override
	public long getNumSessionsFullByDayPredicate(Collection<Session> sessions, LocalDate date) {
		logger.debug("start getNumSessionsFullByDayPredicate");
		Stream<Session> filter = sessions.stream().filter(equalsDate(date).and(isSessionFull()));
		logger.debug("end getNumSessionsFullByDayPredicate");
		return filter.count();
	}

}
