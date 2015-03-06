package org.lab.service;

import java.util.Collection;

import org.lab.model.Session;

public interface ServiceExample10statistics extends ServiceExampleDefault {

	public Double getAveragePrice(Collection<Session> sessions);

}
