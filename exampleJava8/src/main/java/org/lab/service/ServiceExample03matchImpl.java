package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.lab.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample03matchImpl extends Predicates implements ServiceExample03match {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Boolean allSessionsFull(Collection<Session> sessions, LocalDate date) {
		logger.debug("start allSessionsFull");
		Boolean exists = sessions.stream().allMatch(equalsDate(date).and(isSessionFull()));
		logger.debug("end allSessionsFull");
		return exists;
	}

	@Override
	public Boolean existsSessionFull(Collection<Session> sessions, LocalDate date) {
		logger.debug("start existsSessionFull");
		Boolean exists = sessions.stream().anyMatch(equalsDate(date).and(isSessionFull()));
		logger.debug("end existsSessionFull");
		return exists;
	}

	@Override
	public Boolean existsSessionNotFull(Collection<Session> sessions, LocalDate date) {
		logger.debug("start existsSessionNotFull");
		Boolean exists = sessions.stream().anyMatch(equalsDate(date).and(isSessionFull().negate()));
		logger.debug("end existsSessionNotFull");
		return exists;
	}

}
