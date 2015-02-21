package org.lab.service;

import java.util.Collection;

import org.lab.model.Duration;
import org.lab.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceExample06reduceImpl extends Predicates implements ServiceExample06reduce {

	@Override
	public Duration getSumDuration(Collection<Session> sessions) {

		Duration sumDuration = sessions.stream().map(x -> x.getMovie().getDuration()).reduce(new Duration(0, 0), Duration::addDuration);
		return sumDuration;
	}

	@Override
	public Duration getSumDurationWithBiFunction(Collection<Session> sessions) {
		// Declare in Interface ServiceExampleDefault
		// BinaryOperator<Duration> addDur = (x, y) -> x.addDuration(y);
		Duration sumDuration = sessions.stream().map(x -> x.getMovie().getDuration()).reduce(new Duration(0, 0), addDur);
		return sumDuration;
	}
}
