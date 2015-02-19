package org.lab.service;

import java.util.Collection;

import org.lab.model.Duration;
import org.lab.model.Session;

public interface ServiceExample06reduce extends ServiceExampleDefault {

	public Duration getSumDurartion(Collection<Session> sessions);

}
