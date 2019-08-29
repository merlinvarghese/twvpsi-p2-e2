package com.tw.vapasi;

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

        if ((obj == null) || (obj.getClass() != this.getClass()))
            return false;

        return (this.probability.compareTo(((ProbabilityEvent) obj).probability) == 0);
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + (probability.hashCode());
        return result;
    }
}
