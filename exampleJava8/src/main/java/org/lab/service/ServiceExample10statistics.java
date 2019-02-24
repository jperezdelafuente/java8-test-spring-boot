package org.lab.service;

import java.util.Collection;

import org.lab.model.MovieTheater;
import org.lab.model.Session;

public interface ServiceExample10statistics extends ServiceExampleDefault {

	public Double getAveragePrice(Collection<Session> sessions);

	public Integer getMaxNumSeatsSold(Collection<Session> sessions);

	public Integer getMinNumSeatsSold(Collection<Session> sessions);

	public Long getSumNumSeatsSold(Collection<Session> sessions);

    public MovieTheater getSumObjectsInMovieTheaters(Collection<MovieTheater> listMovieTheaters);

    public MovieTheater getAverageObjectsInMovieTheaters(Collection<MovieTheater> listMovieTheaters);

    public Session getSumObjectsInSession(Collection<Session> listSessions);
    
    public Session getAverageObjectsInSession(Collection<Session> listSessions);

	public Double getStandardDeviationSeatsSold(Collection<Session> sessions);

}
