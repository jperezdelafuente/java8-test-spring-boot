package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample03matchImpl extends Predicates implements ServiceExample03match {

	@Override
	public Boolean allSessionsFull(Collection<Session> sessions, LocalDate date) {
		Boolean exists = sessions.stream().allMatch(equalsDate(date).and(isSessionFull()));
		return exists;
	}

	@Override
	public Boolean existsSessionFull(Collection<Session> sessions, LocalDate date) {
		Boolean exists = sessions.stream().anyMatch(equalsDate(date).and(isSessionFull()));
		return exists;
	}

	@Override
	public Boolean existsSessionNotFull(Collection<Session> sessions, LocalDate date) {
		Boolean exists = sessions.stream().anyMatch(equalsDate(date).and(isSessionFull().negate()));
		return exists;
	}

}
