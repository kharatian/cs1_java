import java.util.Scanner;

public class PlayerRoster {
    public static void main(String[] args) {
        final int NUM_PLAYERS = 5;
        Scanner scnr = new Scanner(System.in);
        int[] jerseyNums = new int[NUM_PLAYERS];
        int[] numRating = new int[NUM_PLAYERS];
        boolean printMenuAgain = true;
        String menuChoice;

        for (int i = 0; i < NUM_PLAYERS; ++i) {
            int currPlayer = i + 1;
            System.out.println("Enter player " + currPlayer + "'s jersey number:");
            int inputInt = scnr.nextInt();
            jerseyNums[i] = inputInt;

            System.out.println("Enter player " + currPlayer + "'s rating:");
            inputInt = scnr.nextInt();
            numRating[i] = inputInt;

            System.out.println();
        }

        outputRoster(jerseyNums, numRating);

        while (printMenuAgain) {
            menuChoice = printMenu(scnr);

            if (!isValidMenuChoice(menuChoice)) continue;

            switch (menuChoice) {
                case "q":
                    printMenuAgain = false;
                    break;
                case "u":
                    updatePlayerRating(jerseyNums, numRating, scnr);
                    break;
                case "a":
                    outputPlayerAboveRating(jerseyNums, numRating, scnr);
                    break;
                case "r":
                    replacePlayer(jerseyNums, numRating, scnr);
                    break;
                case "o":
                    outputRoster(jerseyNums, numRating);
                    break;
            }
        }
    }

    public static void outputRoster(int[] jerseyNums, int[] numRating) {
        System.out.println("ROSTER");

        for (int i = 0; i < jerseyNums.length; ++i) {
            int currPlayer = i + 1;
            System.out.println("Player " + currPlayer + " -- Jersey number: " + jerseyNums[i] + ", Rating: " + numRating[i]);
        }
    }

    public static void replacePlayer(int[] jerseyNums, int[] numRating, Scanner scnr) {
        int toBeReplaced;
        int indexToReplace;

        System.out.println("Enter a jersey number:");
        toBeReplaced = scnr.nextInt();

        indexToReplace = findIndex(jerseyNums, toBeReplaced);
        if (indexToReplace != -1) {
            System.out.println("Enter a new jersey number:");
            int newJersey = scnr.nextInt();
            System.out.println("Enter a rating for the new player:");
            int newRating = scnr.nextInt();

            jerseyNums[indexToReplace] = newJersey;
            numRating[indexToReplace] = newRating;
        }
    }

    public static void outputPlayerAboveRating(int[] jerseyNums, int[] numRating, Scanner scnr) {
        int minRating;
        System.out.println("Enter a rating:");

        minRating = scnr.nextInt();

        System.out.println("ABOVE " + minRating);
        for (int i = 0; i < numRating.length; ++i) {
            if (numRating[i] > minRating) {
                System.out.println("Player " + (i + 1) +
                        " -- Jersey number: " + jerseyNums[i] + ", Rating: " + numRating[i]);
            }
        }
    }

    public static void updatePlayerRating(int[] jerseyNums, int[] ratingNums, Scanner scnr) {
        int indexToUpdate = -1;
        int jerseyToUpdate;
        int newRating;

        while (indexToUpdate == -1) {
            System.out.println("Enter a jersey number:");
            jerseyToUpdate = scnr.nextInt();

            indexToUpdate = findIndex(jerseyNums, jerseyToUpdate);
        }

        System.out.println("Enter a new rating for player:");
        newRating = scnr.nextInt();

        ratingNums[indexToUpdate] = newRating;
    }

    public static int findIndex(int[] arrOfInts, int toFind) {

        for (int i = 0; i < arrOfInts.length; ++i){
            if (arrOfInts[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isValidMenuChoice(String strToCheck) {
        boolean isValid;
        String legalChars = "uaroq";

        strToCheck = strToCheck.toLowerCase();

        if (!legalChars.contains(strToCheck)) {
            isValid = false;
        }
        else isValid = true;

        return isValid;
    }

    public static String printMenu(Scanner scnr) {
        final String MENU_TEXT = "MENU\n" +
                "u - Update player rating\n" +
                "a - Output players above a rating\n" +
                "r - Replace player\n" +
                "o - Output roster\n" +
                "q - Quit\n" +
                "\n" +
                "Choose an option:";
        String userChoice;

        System.out.println("\n" + MENU_TEXT);

        userChoice = scnr.nextLine();

        if (userChoice.length() == 0) {
            userChoice += scnr.nextLine().charAt(0);
        }

        return userChoice;
    }
}