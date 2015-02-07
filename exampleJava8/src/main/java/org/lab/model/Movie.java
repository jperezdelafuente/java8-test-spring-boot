package org.lab.model;

public class Movie {

	private String code;

	private String name;

	private Duration duration;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", duration=");
		builder.append(duration);
		builder.append("]");
		return builder.toString();
	}

}
