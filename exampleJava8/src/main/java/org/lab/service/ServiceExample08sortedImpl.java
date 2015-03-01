package org.lab.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample08sortedImpl extends Predicates implements ServiceExample08sorted {

	@Override
	public Stream<Session> getSessionSortedByPrice(Collection<Session> sessions, boolean reversed) {
		Stream<Session> sessionSorted;
		if (!reversed) {
			sessionSorted = sessions.stream().sorted(Comparator.comparing(Session::getPrice));
		} else {
			sessionSorted = sessions.stream().sorted(Comparator.comparing(Session::getPrice).reversed());
		}
		return sessionSorted;
	}

	@Override
	public Stream<Session> getSessionSortedByDateAndPrice(Collection<Session> sessions, boolean reversedDate, boolean reversedPrice) {
		Stream<Session> sessionSorted;
		if (!reversedDate) {
			if (!reversedPrice) {
				sessionSorted = sessions.stream()
						.sorted(Comparator.comparing(Session::getDateWithOutHour).thenComparing(Session::getPrice));
			} else {
				Comparator<Session> comparatorPrice = Comparator.comparing(Session::getPrice).reversed();
				sessionSorted = sessions.stream().sorted(Comparator.comparing(Session::getDateWithOutHour).thenComparing(comparatorPrice));
			}
		} else {
			if (!reversedPrice) {
				sessionSorted = sessions.stream().sorted(
						Comparator.comparing(Session::getDateWithOutHour).reversed().thenComparing(Session::getPrice));
			} else {
				Comparator<Session> comparatorPrice = Comparator.comparing(Session::getPrice).reversed();
				sessionSorted = sessions.stream().sorted(
						Comparator.comparing(Session::getDateWithOutHour).reversed().thenComparing(comparatorPrice));
			}
		}
		return sessionSorted;
	}
}
