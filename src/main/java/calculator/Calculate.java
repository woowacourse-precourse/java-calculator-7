package calculator;

public class Calculate {
    public static void sumString(String input) {
        String regex = ",+|:+";
        if ((input.trim().startsWith("//")) && (input.trim().indexOf("\n") != 2)) {
            regex = input.trim().substring(2, input.indexOf("\n"));
            String[] inputToArr = input.trim().split(regex);
            double sum = 0;
            for (String i : inputToArr) {
                sum += Double.parseDouble(i);
            }

            System.out.println(sum);
        }
    }
}
