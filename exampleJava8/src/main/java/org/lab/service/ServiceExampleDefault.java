package org.lab.service;

import java.util.Collection;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import org.lab.model.Duration;
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

    public default <T> Integer sumObjets(Collection<T> collection, ToIntFunction<T> object) {
        return new Long(collection.stream().collect(Collectors.summarizingInt(object)).getSum()).intValue();
    }

    public default <T> Integer averageObjets(Collection<T> collection, ToIntFunction<T> object) {
        return new Double(collection.stream().collect(Collectors.summarizingInt(object)).getAverage()).intValue();
    }

}
