/**
 * Created by m on 11/14/2016.
 */

public class DiceSimulation {

    static int die1 = 2; // global variables available in all methods
    static int die2 = 2;

    public static void main(String[] args) {

        int count = 0;
        int timesToSimulate = 20000;
        int rolls = 0;
        int sum = 0;
        boolean snakeeyes = false;

        while (count < timesToSimulate) {
            // as long as the two dice are not snake eyes, keep rolling them.

            while ( !snakeeyes  ) {
                //System.out.println("testing..");
                // generates a random number from 1 to 6 for each die
                die1 = (int) Math.round(Math.random() * 6) + 1;
                die2 = (int) Math.round(Math.random() * 6) + 1;

                //System.out.println("You roll a.... " + die1);
                //System.out.println("And a... " + die2);

                if ((die1 == 1) && (die2 == 1)) {
                    System.out.println("Snake eyes!");
                    snakeeyes = true;
                }
                rolls++;
            }

            System.out.println("You rolled " + rolls + " times to get snakeeyes!");
            count++; // keeps track of times to simulate
            sum += rolls;
            die1 = 1;
            die2 = 2;
            rolls = 0;
            snakeeyes = false;

        }

        System.out.println("We simulated the roll for snakeeyes " + timesToSimulate + " times");
        System.out.println("The number of total times we rolled the two dice was " + sum + " times");

        double snAverage = (double) sum / timesToSimulate;
        System.out.println("The average number of times it takes to roll snakeeyes is: " + snAverage);

        }

}
