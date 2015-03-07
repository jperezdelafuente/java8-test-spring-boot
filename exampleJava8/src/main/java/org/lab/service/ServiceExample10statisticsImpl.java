package org.lab.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample10statisticsImpl extends Predicates implements ServiceExample10statistics {

	@Override
	public Double getAveragePrice(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.summarizingDouble(Session::getPrice)).getAverage();
	}

	@Override
	public Integer getMaxNumSeatsSold(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.summarizingInt(Session::getNumSeatsSold)).getMax();
	}

	@Override
	public Integer getMinNumSeatsSold(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.summarizingInt(Session::getNumSeatsSold)).getMin();
	}

	@Override
	public Long getSumNumSeatsSold(Collection<Session> sessions) {
		return sessions.stream().collect(Collectors.summarizingInt(Session::getNumSeatsSold)).getSum();
	}

}
