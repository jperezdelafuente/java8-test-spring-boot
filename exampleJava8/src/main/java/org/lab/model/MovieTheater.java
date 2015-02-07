package org.lab.model;

public class MovieTheater {

	private String code;

	private Integer numSeats;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(Integer numSeats) {
		this.numSeats = numSeats;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovieTheater [code=");
		builder.append(code);
		builder.append(", numSeats=");
		builder.append(numSeats);
		builder.append("]");
		return builder.toString();
	}

}
