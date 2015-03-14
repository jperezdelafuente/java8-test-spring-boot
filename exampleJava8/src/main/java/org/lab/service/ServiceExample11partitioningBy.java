package org.lab.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.lab.model.Session;

public interface ServiceExample11partitioningBy extends ServiceExampleDefault {

	public Map<Boolean, List<Session>> getMapSessionsFull(Collection<Session> sessions);

	public Map<Boolean, List<Session>> getMapSessionsOccupationPercent(Collection<Session> sessions, Double percent);

}
