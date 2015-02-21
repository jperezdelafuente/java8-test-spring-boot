package org.lab.service;

import java.util.function.BinaryOperator;
import java.util.function.ToDoubleFunction;

import org.lab.model.Duration;
import org.lab.model.Session;

public interface ServiceExampleDefault {

	public default ToDoubleFunction<Session> getOccupation() {
		return x -> 1 * x.getNumSeatsSold() / x.getMovieTheater().getNumSeats();
	}

	public BinaryOperator<Duration> addDur = (x, y) -> {
		Integer min = x.getMinutes() + y.getMinutes();
		Integer hor = x.getHours() + y.getHours();
		return new Duration(hor + min / 60, min % 60);
	};

}
