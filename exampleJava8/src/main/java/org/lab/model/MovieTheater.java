package org.lab.model;

public class MovieTheater {

	private String code;

	private Integer numSeats;

    private Integer numSpeakers;

    private Integer numLights;

    private Integer numLitterbins;

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

    public Integer getNumSpeakers() {
        return numSpeakers;
    }

    public void setNumSpeakers(Integer numSpeakers) {
        this.numSpeakers = numSpeakers;
    }

    public Integer getNumLights() {
        return numLights;
    }

    public void setNumLights(Integer numLights) {
        this.numLights = numLights;
    }

    public Integer getNumLitterbins() {
        return numLitterbins;
    }

    public void setNumLitterbins(Integer numLitterbins) {
        this.numLitterbins = numLitterbins;
    }
    
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MovieTheater [code=");
        builder.append(code);
        builder.append(", numSeats=");
        builder.append(numSeats);
        builder.append(", numSpeakers=");
        builder.append(numSpeakers);
        builder.append(", numLights=");
        builder.append(numLights);
        builder.append(", numLitterbins=");
        builder.append(numLitterbins);
        builder.append("]");
        return builder.toString();
    }

}
