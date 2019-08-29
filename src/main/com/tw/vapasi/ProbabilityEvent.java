package com.tw.vapasi;

//Holds the probability of occurrences of an event
class ProbabilityEvent {
    private Double probability;

    ProbabilityEvent(Double probability) {
        this.probability = probability;
    }

    boolean equals(ProbabilityEvent probabilityEvent) {
        return (this.probability.compareTo(probabilityEvent.probability) == 0 ? true : false);
    }
}
