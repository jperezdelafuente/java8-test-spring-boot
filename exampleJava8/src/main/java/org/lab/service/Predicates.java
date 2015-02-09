package org.lab.service;

import java.time.LocalDate;
import java.util.function.Predicate;

import org.lab.model.Session;

public class Predicates {

	Predicate<Session> equalsDate(LocalDate date) {
		return x -> x.getDate().equals(date);
	}

	Predicate<Session> isSessionFull() {
		return session -> session.getNumSeatsSold().equals(session.getMovieTheater().getNumSeats());
	}

}
