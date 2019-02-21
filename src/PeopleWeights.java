import java.util.Scanner;

public class PeopleWeights {

    public static void main (String[] args) {
        final int MAX_NUM_WEIGHTS = 5;
        double[] peopleWeights = new double[MAX_NUM_WEIGHTS];
        String concatWeights = "";
        double totalWeight = 0.0;
        double averageWeight;
        double maxWeight;
        Scanner scnr = new Scanner(System.in);

        for (int i = 0; i < MAX_NUM_WEIGHTS; ++i) {
            System.out.println("Enter weight " + i + ":");
            peopleWeights[i] = scnr.nextDouble();
        }

        maxWeight = peopleWeights[0];

        for (double weight: peopleWeights) {
            concatWeights += weight + "  ";
            totalWeight += weight;

            if (weight > maxWeight) maxWeight = weight;
        }
        averageWeight = totalWeight / MAX_NUM_WEIGHTS;
        System.out.println("You entered: " + concatWeights);

        System.out.println("Total weight: " + totalWeight);
        System.out.println("Average weight: " + averageWeight);
        System.out.println("Max weight: " + maxWeight);

    }
}

