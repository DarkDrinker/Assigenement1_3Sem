import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //lambda excercises
        System.out.println();
        System.out.println("Lambda excercises");
        int resultAddition = operate(5, 3, Integer::sum);
        System.out.println("Addidtion:" + resultAddition);

        int resultSubtraction = operate(5, 3, (a, b) -> a - b);
        System.out.println("Subtraction: " + resultSubtraction);

        int resultMultiplication = operate(5, 3, (a, b) -> a * b);
        System.out.println("Multiplication: " + resultMultiplication);

        int resultDivision = operate(6, 2, (a, b) -> a / b);
        System.out.println("Division: " + resultDivision);

        int resultModulus = operate(5, 3, (a, b) -> a % b);
        System.out.println("Modulus: " + resultModulus);

        int resultPower = operate(2, 3, (a, b) -> (int) Math.pow(a, b));
        System.out.println("Power: " + resultPower);

        // Example with arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int[] resultArray = operate(array1, array2, (a, b) -> a + b);
        System.out.println("Array Addition: " + Arrays.toString(resultArray));

        //Functional interfaces
        System.out.println();
        System.out.println("Functional interface excersises");

        int[] exmparray = {2,5,6,8};

        int[] Multiplicativearray = map(exmparray, x -> x * 2);
        System.out.println("Doubled array: " + Arrays.toString(Multiplicativearray));

        int[] evenArray = filter(exmparray, x -> x % 2 == 0);
        System.out.println("printing the even values:" + Arrays.toString(evenArray));
    }

    public static int operate(int a, int b, ArithmeticOperation op) {
        return op.perform(a, b);
    }

    public static int[] operate(int[] a, int[] b, ArithmeticOperation op) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array length mist be the same");
        }

        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = op.perform(a[i], b[i]);
        }

        return result;
    }

    public static int[] map(int[] a, MyTransformingType op) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = op.transform(a[i]);
        }
        return result;
    }

    // Filter method to keep elements in the array based on a validation condition
    public static int[] filter(int[] a, MyValidatingType op) {
        return Arrays.stream(a)
                .filter(op::validate)
                .toArray();
    }


}
