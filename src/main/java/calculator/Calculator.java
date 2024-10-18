package calculator;

public class Calculator {
    private String[] stringNumbers;
    private int sum;

    public int getSum() {
        return sum;
    }

    public void splitInput(String input) {
        stringNumbers = input.split(Delimiter.delimiter);
        // TODO print
        System.out.println("splitInput");
        for (String stringNumber : stringNumbers) {
            System.out.print(stringNumber + "^");
        }
        System.out.println();
    }

    public void addNumbers() {
//        System.out.println("addNumbers");
//        for (String stringNumber : stringNumbers) {
////            System.out.println(stringNumber + " ");
//            sum += Integer.parseInt(stringNumber);
//        }
    }
}
