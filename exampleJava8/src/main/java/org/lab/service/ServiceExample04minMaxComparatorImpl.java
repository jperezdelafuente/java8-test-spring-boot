package org.lab.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample04minMaxComparatorImpl extends Predicates implements ServiceExample04minMaxComparator {

	@Override
	public Optional<Session> getSessionMinPrice(Collection<Session> sessions) {
		Optional<Session> session = sessions.stream().min(Comparator.comparingDouble(Session::getPrice));
		return session;
	}

	@Override
	public Optional<Session> getSessionMaxPrice(Collection<Session> sessions) {
		Optional<Session> session = sessions.stream().max(Comparator.comparingDouble(Session::getPrice));
		return session;
	}
}
