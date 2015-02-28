package org.lab.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample08sortedImpl extends Predicates implements ServiceExample08sorted {

	@Override
	public Stream<Session> getSessionSortedByPrice(Collection<Session> sessions) {
		Stream<Session> sessionSorted = sessions.stream().sorted(Comparator.comparing(Session::getPrice));
		return sessionSorted;
	}

	@Override
	public Stream<Session> getSessionSortedByDateAndPrice(Collection<Session> sessions) {
		Stream<Session> sessionSorted = sessions.stream().sorted(
				Comparator.comparing(Session::getDateWithOutHour).thenComparing(Session::getPrice));
		return sessionSorted;
	}

}
