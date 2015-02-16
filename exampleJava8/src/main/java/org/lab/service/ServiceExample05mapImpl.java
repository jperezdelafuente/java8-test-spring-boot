package org.lab.service;

import java.util.Collection;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample05mapImpl extends Predicates implements ServiceExample05map {

	@Override
	public Double getMaxOccupation(Collection<Session> sessions) {
		Double occupation = sessions.stream().mapToDouble(getOccupation()).max().getAsDouble();
		return occupation;
	}

}
