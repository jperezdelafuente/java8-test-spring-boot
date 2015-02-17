package org.lab.service;

import java.util.Collection;

import org.lab.model.Session;

public interface ServiceExample05map extends ServiceExampleDefault {

	public Double getMaxOccupation(Collection<Session> sessions);

	public Double getSumTakings(Collection<Session> sessions);

	public Double getAverageTakings(Collection<Session> sessions);

}
