package org.lab.service;

import java.util.Collection;

import org.lab.model.Duration;
import org.lab.model.Session;

public interface ServiceExample06reduce extends ServiceExampleDefault {

	public Duration getSumDuration(Collection<Session> sessions);

	public Duration getSumDurationWithBiFunction(Collection<Session> sessions);

	public Duration getSumDurationIncreasedWithBiFunction(Collection<Session> sessions, int minutes);

}
