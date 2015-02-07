package org.lab.model;

public class Duration {

	private Integer hours;

	private Integer minutes;

	private Integer totalMinutes;

	public Duration() {
		super();
	}

	public Duration(Integer hours, Integer minutes) {
		super();
		this.hours = hours;
		this.minutes = minutes;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public Integer getTotalMinutes() {
		return hours * 60 + minutes;
	}

	public void setTotalMinutes(Integer totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	public Duration addDuration(Duration d) {
		hours += d.getHours();
		minutes += d.getMinutes();
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Duration [hours=");
		builder.append(hours);
		builder.append(", minutes=");
		builder.append(minutes);
		builder.append(", totalMinutes=");
		builder.append(totalMinutes);
		builder.append("]");
		return builder.toString();
	}

}
