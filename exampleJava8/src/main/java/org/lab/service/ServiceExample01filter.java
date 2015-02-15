package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.lab.model.Session;

public interface ServiceExample01filter extends ServiceExampleDefault {

	public long getNumSessionsByDay(Collection<Session> sessions, LocalDate date);

	public long getNumSessionsFull(Collection<Session> sessions);

}
