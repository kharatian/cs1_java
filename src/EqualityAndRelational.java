import java.util.Scanner;

public class EqualityAndRelational {

    public static void swapArrayEnds(int[] arrayToSwapEnds, int arraySize) {
        int firstIndexItem = arrayToSwapEnds[0];
        int lastIndex = arraySize - 1;

        arrayToSwapEnds[0] = arrayToSwapEnds[lastIndex];
        arrayToSwapEnds[lastIndex] = firstIndexItem;
    }

    public static void main (String [] args) {

        int aa = 10;
        int bb = 9;

        float diffSquares = aa+bb * aa-bb;

        System.out.println(diffSquares);

        int value = 106;

        if (!(value < 0 || value > 100) || value % 2 == 0) {
            ++value;
        }

        System.out.println(value);

        boolean a = true;
        boolean b = true;
        boolean c = true;

        System.out.println(!a && !b || !c);

        System.out.println(a && b && c);

        System.out.println(!(a || b || c));
        System.out.println( ! ((a || b) && c) );

        System.out.println(a || b || c);

        int n = 5;
        int fact = 1;

        while (n-- > 0) fact *= n;

//        while (n > 0) fact *= n--;

        System.out.println(fact + " " + n);


        float prod = 1;

        int count = 0;

        for (int m = 10; m > 0; m /= 2) {
            System.out.println("here");
            count += 1;
            prod *= m;
        }
        count = 0;
        int sum = 0;
        for (int on = 0; on < 10; on++) {
            count += 1;
            sum += n;
        }
        System.out.println(count + " count\tsum" + sum);
//        int numElem = 4;
//        int[] sortArray = new int[numElem];
//        int i;
//
//        int n = 11;
//        int valu = ++n % 3;
//        valu += n/2;
//
//        boolean value = n == 2;
//
//        System.out.println("********\t" + value);
//
//        System.out.println("********\t" + valu);
//
//        int numberELements = 5;
//
//        double initializedValue = 0.0;
//
//        double[] arrArr = createInitializedArray(numberELements, initializedValue);
//
//
//
//        System.out.println("****************\n" + arrArr);
//
//        System.out.println("\n\n\t\t array length\n\n\t\t" + sortArray.length);
//
//        sortArray[0] = 10;
//        sortArray[1] = 20;
//        sortArray[2] = 30;
//        sortArray[3] = 40;
//
//        swapArrayEnds(sortArray, numElem);
//
//        for (i = 0; i < numElem; ++i) {
//            System.out.print(sortArray[i]);
//            System.out.print(" ");
//        }
//        System.out.println("");
    }

    public static double[] createInitializedArray(int numberElements, double initializedValue) {
        double[] returnArray = new double[numberElements];
        System.out.println(initializedValue);
        System.out.println(returnArray);

        for (int i = 0; i < numberElements; ++i) {
            System.out.println(i);
            returnArray[i] = initializedValue;
        }

        System.out.println(returnArray);

        return returnArray;
    }
}

