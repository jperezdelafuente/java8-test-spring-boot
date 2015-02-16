package org.lab.service;

import java.util.Collection;

import org.lab.model.Session;

public interface ServiceExample05map extends ServiceExampleDefault {

	public Double getMaxOccupation(Collection<Session> sessions);

}
