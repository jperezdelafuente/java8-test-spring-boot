package org.lab.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

import org.lab.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample04minMaxComparatorImpl extends Predicates implements ServiceExample04minMaxComparator {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Optional<Session> getSessionMinPrice(Collection<Session> sessions) {
		logger.debug("start getSessionMinPrice");
		Optional<Session> session = sessions.stream().min(Comparator.comparingDouble(Session::getPrice));
		logger.debug("end getSessionMinPrice");
		return session;
	}

	@Override
	public Optional<Session> getSessionMaxPrice(Collection<Session> sessions) {
		logger.debug("start getSessionMaxPrice");
		Optional<Session> session = sessions.stream().max(Comparator.comparingDouble(Session::getPrice));
		logger.debug("end getSessionMaxPrice");
		return session;
	}
}
