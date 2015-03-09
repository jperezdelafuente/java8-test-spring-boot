package org.lab.service;

import java.util.Collection;

import org.lab.model.Session;

public interface ServiceExample10statistics extends ServiceExampleDefault {

	public Double getAveragePrice(Collection<Session> sessions);

	public Integer getMaxNumSeatsSold(Collection<Session> sessions);

	public Integer getMinNumSeatsSold(Collection<Session> sessions);

	public Long getSumNumSeatsSold(Collection<Session> sessions);

	public Double getStandardDeviationSeatsSold(Collection<Session> sessions);

}
