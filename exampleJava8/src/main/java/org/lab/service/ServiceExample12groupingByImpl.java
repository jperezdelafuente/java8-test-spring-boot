package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample12groupingByImpl extends Predicates implements ServiceExample12groupingBy {

	@Override
	public Map<LocalDate, List<Session>> getMapSessionsByDate(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.groupingBy(Session::getDateWithOutHour));
	}

	@Override
	public Map<String, Set<Session>> getMapSessionsByTitle(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.groupingBy(Session::getTitle, Collectors.toSet()));
	}

}
