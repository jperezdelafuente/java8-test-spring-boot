package org.lab.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample11partitioningByImpl extends Predicates implements ServiceExample11partitioningBy {

	@Override
	public Map<Boolean, List<Session>> getMapSessionsFull(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.partitioningBy(isSessionFull()));
	}

}
