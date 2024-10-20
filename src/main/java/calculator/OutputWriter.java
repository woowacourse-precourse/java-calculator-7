package calculator;

public class OutputWriter {

    private static final String outputFormat = "결과 : ";

    public static void writeOutput(Long sum) {
        System.out.println(outputFormat + sum);
    }
}
