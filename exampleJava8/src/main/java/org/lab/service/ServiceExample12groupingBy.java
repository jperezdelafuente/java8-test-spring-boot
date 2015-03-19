package org.lab.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.lab.model.Session;

public interface ServiceExample12groupingBy extends ServiceExampleDefault {

	public Map<LocalDate, List<Session>> getMapSessionsByDate(Collection<Session> sessions);

	public Map<String, Set<Session>> getMapSessionsByTitle(Collection<Session> sessions);

	public Map<String, Long> getMapNumSessionsByTitle(Collection<Session> sessions);

	public Map<String, Double> getMapAveragePriceByTitle(Collection<Session> sessions);

	public Map<LocalDate, Double> getMapTakingsByTitle(Collection<Session> sessions);

}
