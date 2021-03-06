package org.lab.service;

import java.util.Collection;
import java.util.stream.Stream;

import org.lab.model.Session;

public interface ServiceExample08sorted extends ServiceExampleDefault {

	public Stream<Session> getSessionSortedByPrice(Collection<Session> sessions, boolean reversed);

	public Stream<Session> getSessionSortedByDateAndPrice(Collection<Session> sessions, boolean reversedDate, boolean reversedPrice);

}
