import java.util.Scanner;

public class AuthoringAssistant {

    // print a menu of possible operations and get users input
    public static String printMenu(Scanner scnr) {

        String menuText = "\nMENU\n" +
                "c - Number of non-whitespace characters\n" +
                "w - Number of words\n" +
                "f - Find text\n" +
                "r - Replace all !'s\n" +
                "s - Shorten spaces\n" +
                "q - Quit\n" +
                "\n" +
                "Choose an option:";

        System.out.println(menuText);

        String userChoice = "";
        userChoice += scnr.nextLine().charAt(0);

        return userChoice;
    }

    // Method counts the number of characters
    public static int getNumOfCharacters(final String usrStr) {
        int numChars = 0;

        for (int i = 0; i < usrStr.length(); ++i) {
            ++numChars;
        }

        return numChars;
    }

    public static int getNumOfNonWSCharacters(String userStr) {
        int countNonWS = 0;

        for (char ch : userStr.toCharArray()) {
            if (ch != ' ') ++countNonWS;
        }

        return countNonWS;
    }

    public static int getNumOfWords(String stringToCheck) {
        int countWords = 0;
        boolean currentlyInWord = false;

        // Use our nice stringToCheck method to remove extra spaces.
        stringToCheck = shortenSpace(stringToCheck);

        for (int i = 0; i < stringToCheck.length(); ++i) {
            if (stringToCheck.charAt(i) == ' ' && currentlyInWord) {
                ++countWords;
                currentlyInWord = false;
            }
            else if (currentlyInWord && i == stringToCheck.length() - 1) {
                ++countWords;
            }
            else {
                currentlyInWord = true;
            }
        }
        return countWords;
    }
    public static int findText(String subStringToFind, String toSearch) {
        int subInstances = 0;
        int lastFoundIndex = 0;

        while (lastFoundIndex != -1){
            lastFoundIndex = toSearch.indexOf(subStringToFind, lastFoundIndex);
            if (lastFoundIndex != -1) {
                ++subInstances;
                //also add 1 to lastFoundIndex so we don't search start at the same index we found the last occurence
                ++lastFoundIndex;
            }
        }
        return subInstances;
    }

    public static String replaceExclamation(String textToEdit) {
        return textToEdit.replaceAll("!", ".");
    }

    public static String getUserInput(Scanner scnr, String promptMessage) {
        System.out.println(promptMessage);

        return scnr.nextLine();
    }

    public static String shortenSpace(String textToEdit) {
        textToEdit = textToEdit.replaceAll("\\s{2,}", " ");

        return textToEdit;
    }

    public static boolean validateMenuChoice(String stringToCheck) {
        final String VALID_CHOICES = "cfrqsw";

        if (stringToCheck.length() != 1) return false;

        if (VALID_CHOICES.contains(stringToCheck)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        final String INPUT_PROMPT_MESSAGE = ("Enter a sample text:");
        final String COUNT_NON_WHITESPACE = "c";
        final String COUNT_WORDS = "w";
        final String FIND_TEXT = "f";
        final String REPLACE_ALL_EXCLAMATIONS = "r";
        final String SHORTEN_SPACES = "s";
        final String QUIT_CMD = "q";
        Scanner scnr = new Scanner(System.in);
        String menuChoice = "";
        String userInput = getUserInput(scnr, INPUT_PROMPT_MESSAGE);

        System.out.println("\nYou entered: " + userInput);

        while (menuChoice.compareTo(QUIT_CMD) != 0) {
            menuChoice = printMenu(scnr);
            if (!validateMenuChoice(menuChoice)) {
                System.out.println("choice is " + menuChoice);
                continue;}
            switch (menuChoice) {
                case COUNT_NON_WHITESPACE:
                    System.out.println("Number of non-whitespace characters: " + getNumOfNonWSCharacters(userInput));
                    break;
                case COUNT_WORDS:
                    System.out.println("Number of words: " + getNumOfWords(userInput));
                    break;
                case FIND_TEXT:
                    String stringToFind = getUserInput(scnr, "Enter a word or phrase to be found:");
                    System.out.println("\"" + stringToFind + "\"" + " instances: " + findText(stringToFind, userInput));
                    break;
                case REPLACE_ALL_EXCLAMATIONS:
                    System.out.println("Edited text: " + replaceExclamation(userInput));
                    break;
                case SHORTEN_SPACES:
                    System.out.println("Edited text: " + shortenSpace(userInput));
                    break;
            }
        }
    }
}