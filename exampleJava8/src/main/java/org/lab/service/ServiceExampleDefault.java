package org.lab.service;

import java.util.Collection;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import org.lab.model.Duration;
import org.lab.model.MovieTheater;
import org.lab.model.Session;

public interface ServiceExampleDefault {

	public default ToDoubleFunction<Session> getOccupation() {
		return session -> 1 * session.getNumSeatsSold() / session.getMovieTheater().getNumSeats();
	}

	public default Consumer<Session> addPercentAditionalPrice(int percent) {
		return session -> session.setPrice(session.getPrice() + (session.getPrice() * percent / 100));
	}

	public BinaryOperator<Duration> addDur = (x, y) -> {
		Integer min = x.getMinutes() + y.getMinutes();
		Integer hor = x.getHours() + y.getHours();
		return new Duration(hor + min / 60, min % 60);
	};

    public default Integer sumObjetsInMovieTheaters(Collection<MovieTheater> listMovieTheaters, ToIntFunction<MovieTheater> object) {
        return new Long(listMovieTheaters.stream().collect(Collectors.summarizingInt(object)).getSum()).intValue();
    }

    public default Integer averageObjetsInMovieTheaters(Collection<MovieTheater> listMovieTheaters, ToIntFunction<MovieTheater> object) {
        return new Double(listMovieTheaters.stream().collect(Collectors.summarizingInt(object)).getAverage()).intValue();
    }

}
