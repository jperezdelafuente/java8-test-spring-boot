package org.lab.service;

import java.util.Collection;
import java.util.Optional;

import org.lab.model.Session;

public interface ServiceExample04minMaxComparator {

	public Optional<Session> getSessionMinPrice(Collection<Session> sessions);

	public Optional<Session> getSessionMaxPrice(Collection<Session> sessions);

}
