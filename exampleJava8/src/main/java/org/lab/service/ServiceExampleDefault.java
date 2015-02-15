package org.lab.service;

import java.util.function.ToDoubleFunction;

import org.lab.model.Session;

public interface ServiceExampleDefault {

	public default ToDoubleFunction<Session> getOccupation() {
		return x -> 1 * x.getNumSeatsSold() / x.getMovieTheater().getNumSeats();
	}
}
