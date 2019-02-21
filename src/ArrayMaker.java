import java.util.Scanner;

public class ArrayMaker {

    public static void main(String[] args) {
        final int ARRAY_NAMES_CAPACITY = 10;
        String[] arrayNames = new String[ARRAY_NAMES_CAPACITY];
        int arrayNamesSize = 0;

        int callStatus = 0;

//        while (arrayNamesSize < 10 && callStatus != -1) {
//            System.out.println(arrayNames.length);
//            Scanner scnr = new Scanner(System.in);
//            System.out.println("What name should we add?");
//            String inputName = scnr.nextLine();
//            arrayNamesSize = addElement(arrayNames, arrayNamesSize, inputName);
//        }
        char[] dblArr = new char[4];
//        dblArr = EqualityAndRelational.createInitializedArray(5, 0.0);
//
        for (int i = 0; i < dblArr.length ; ++i) {
            System.out.println("." + dblArr[i] + ".");
        }
    }

    private static int addElement(String[] arrayRef, int currentArraySize, String addMe) {

        if (currentArraySize < arrayRef.length) {
            arrayRef[currentArraySize] = addMe;
            ++currentArraySize;
            return currentArraySize;
        }
        else {
            return -1;
        }
    }
}
