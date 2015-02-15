package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.lab.model.Session;

public interface ServiceExample02predicate extends ServiceExampleDefault {

	public long getNumSessionsByDayPredicate(Collection<Session> sessions, LocalDate date);

	public long getNumSessionsFullByDayPredicate(Collection<Session> sessions, LocalDate date);

}
