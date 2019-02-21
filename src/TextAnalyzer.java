import java.util.Scanner;

public class TextAnalyzer {
    // Method counts the number of characters
    public static int getNumOfCharacters(final String usrStr) {
        int numChars = 0;

        for (int i = 0; i < usrStr.length(); ++i) {
            ++numChars;
        }

        return numChars;
    }

    public static String outputWithoutWhiteSpaces(String userStr) {
        String userStrNoSpaces = "";

        for (char ch: userStr.toCharArray()) {
            if (ch != ' ') userStrNoSpaces += ch;
        }

        return userStrNoSpaces;
    }

    public static String getUserInput(Scanner scnr, String promptMessage) {
        System.out.println(promptMessage);

        return scnr.nextLine();
    }

    public static void main(String[] args) {
        final String INPUT_PROMPT_MESSAGE = "Enter a sentence or phrase: ";
        final String NUM_CHARS_MESSAGE = "Number of characters: ";
        final String YOU_ENTERED_MESSAGE = "You entered: ";
        final String NO_WHITE_SPACE_MESSAGE = "String with no whitespace: ";

        Scanner scnr = new Scanner(System.in);
        String userInput = getUserInput(scnr, INPUT_PROMPT_MESSAGE);

        System.out.println("\n" + YOU_ENTERED_MESSAGE + userInput + "\n");
        System.out.println(NUM_CHARS_MESSAGE + getNumOfCharacters(userInput));
        System.out.println(NO_WHITE_SPACE_MESSAGE + outputWithoutWhiteSpaces(userInput));
    }
}