package com.company;

public class Zoo {
    private final int amountOfElephants;
    private int weightOfLightestElephant;

    private Elephant[] elephants;

    public Zoo(int amountOfElephants, Elephant[] elephants) {
        this.amountOfElephants = amountOfElephants;
        this.elephants = elephants;
        calculateTheLightestElephant();
    }

    public void calculateTheLightestElephant() {
        weightOfLightestElephant = elephants[0].getWeight();
        for (int i = 0; i < elephants.length; ++i) {
            weightOfLightestElephant = Math.min(weightOfLightestElephant, elephants[i].getWeight());
        }
    }

    public long reorderElephants() {
        long result = 0;
        for (int i = 0; i < this.amountOfElephants; ++i) {
            if (!this.elephants[i].isReplaced()) {
                long minimumWeightInCycle = 1000000000;
                long sumOfWeightsInCycle = 0;
                int j = i;
                int cycleLength = 0;
                boolean cycleEnd = false;

                while (!cycleEnd) {
                    minimumWeightInCycle = Math.min(minimumWeightInCycle, this.elephants[j].getWeight());
                    sumOfWeightsInCycle += this.elephants[j].getWeight();
                    j = this.elephants[j].getDestination();
                    this.elephants[j].setReplaced(true);
                    ++cycleLength;
                    if (j == i)
                        cycleEnd = true;
                }
                result += Math.min(sumOfWeightsInCycle + (cycleLength - 2) * minimumWeightInCycle, sumOfWeightsInCycle + minimumWeightInCycle + (cycleLength + 1) * (long) this.weightOfLightestElephant);
            }

        }
        return result;
    }
}
