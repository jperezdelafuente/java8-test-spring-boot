package org.lab.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.lab.model.Duration;
import org.lab.model.Session;

public interface ServiceExample09collect extends ServiceExampleDefault {

	public List<Duration> getDurations(Collection<Session> sessions);

	public Set<String> getTitles(Collection<Session> sessions);

}
