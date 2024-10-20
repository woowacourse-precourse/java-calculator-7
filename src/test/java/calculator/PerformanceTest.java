package calculator;

import calculator.myParser.MyParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class PerformanceTest {
    private static final int TEST_CASES = 1_000;
    private static final String DELIMITERS = ",:;|!@#$%^&*+=";
    private static final int MAX_NUMBERS = 100_000;
    private static final int MAX_NUMBER = 100_000;
    private static final int WARM_UP_RUNS = 10;

    private static List<String> testInputs;
    private static SimpleParser simpleParser;
    private static MyParser myParser;

    public static void main(String[] args) {
        setUp();
        compareParserPerformance();
    }

    static void setUp() {
        testInputs = generateTestInputs();
        simpleParser = new SimpleParser();
        myParser = new MyParser();
    }

    static void compareParserPerformance() {
        System.out.println("Performance Test");
        System.out.println("Test cases\t: " + TEST_CASES);
        System.out.println("Delimiters\t: " + DELIMITERS);
        System.out.println("Max numbers\t: " + MAX_NUMBERS);
        System.out.println("Max number\t: " + MAX_NUMBER);
        System.out.println("Warm-up runs\t: " + WARM_UP_RUNS);

        // warm-up runs
        for (int i = 0; i < WARM_UP_RUNS; i++) {
            runParser(simpleParser, testInputs);
            runParser(myParser, testInputs);
        }
        System.out.println("Warm-up runs completed");

        // actual test runs
        long simpleParserTime = runParser(simpleParser, testInputs);
        long myParserTime = runParser(myParser, testInputs);

        System.out.println("`SimpleParser` total time\t: " + simpleParserTime + " ns");
        System.out.println("`MyParser` total time\t: " + myParserTime + " ns");
        System.out.println("Difference\t: " + Math.abs(simpleParserTime - myParserTime) + " ns");
    }

    private static List<String> generateTestInputs() {
        List<String> inputs = new ArrayList<>(TEST_CASES);
        for (int i = 0; i < TEST_CASES; i++) {
            inputs.add(generateTestInput());
        }
        return inputs;
    }

    private static String generateTestInput() {
        Random random = new Random();
        StringBuilder input = new StringBuilder("//" + DELIMITERS + "\\n");

        // Generate numbers
        int numberCount = random.nextInt(MAX_NUMBERS);
        for (int j = 0; j < numberCount; j++) {
            if (j > 0) {
                input.append(DELIMITERS.charAt(random.nextInt(DELIMITERS.length())));
            }
            input.append(random.nextInt(MAX_NUMBER));
        }
        return input.toString();
    }

    private static long runParser(Parser parser, List<String> inputs) {
        long startTime = System.nanoTime();
        for (String input : inputs) {
            parser.parse(input);
        }
        return System.nanoTime() - startTime;
    }
}
