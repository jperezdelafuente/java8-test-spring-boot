package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;

import org.lab.model.Session;

public interface ServiceExample03match extends ServiceExampleDefault {

	public Boolean allSessionsFull(Collection<Session> sessions, LocalDate date);

	public Boolean existsSessionFull(Collection<Session> sessions, LocalDate date);

	public Boolean existsSessionNotFull(Collection<Session> sessions, LocalDate date);

}
