package calculator;

public class Calculate {

    private static String input;
    private static String delimiter;

    public Calculate(String input) {
        Calculate.input = input;
        delimiter = ",|:";
    }

    private static String[] toArray() {

        if (input.startsWith("//") && input.indexOf("\n") == 3) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        return input.split(delimiter);
    }

    public int cal() {
        int sum = 0;

        String[] arr = toArray();

        for (int i = 0; i < arr.length; i++) {
            try {
                int num = Integer.parseInt(arr[i]);
                sum += num;
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid number: " + arr[i]);
                e.printStackTrace();
            }
        }

        return sum;
    }

}
