package org.lab.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.lab.model.Duration;
import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample09collectImpl extends Predicates implements ServiceExample09collect {

	@Override
	public List<Duration> getDurations(Collection<Session> sessions) {
		return sessions.stream().map(x -> x.getMovie().getDuration()).collect(Collectors.toList());
	}

	@Override
	public Set<String> getTitles(Collection<Session> sessions) {
		return sessions.stream().map(x -> x.getMovie().getTitle()).collect(Collectors.toSet());
	}

}
