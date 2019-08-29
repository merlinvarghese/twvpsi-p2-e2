package com.tw.vapasi;

import java.util.Objects;

//Holds the probability of occurrences of an event
class ProbabilityEvent {
    private Double probability;

    ProbabilityEvent(Double probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj)
            return false;

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        return (this.probability.compareTo(((ProbabilityEvent) obj).probability) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.probability);
    }

    Double combineProbability(ProbabilityEvent probabilityEventOther) {
        return this.probability * probabilityEventOther.probability;
    }
}
