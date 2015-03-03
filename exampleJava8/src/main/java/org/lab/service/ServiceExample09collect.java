package org.lab.service;

import java.util.Collection;
import java.util.List;

import org.lab.model.Duration;
import org.lab.model.Session;

public interface ServiceExample09collect extends ServiceExampleDefault {

	public List<Duration> getDurations(Collection<Session> sessions);

}
