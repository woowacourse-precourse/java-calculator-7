package calculator;

public class Calculator {
    private String input;
    private String delimiter;
    public String[] stringNumbers;
    private int sum;

    public Calculator(String input) {
        this.delimiter = ",:";
//        this.delimiter = ",:";
        this.input = input;
    }

    public int getSum() {
        return sum;
    }

    public String checkInput() throws IllegalArgumentException {
        if (input.substring(0, 2).equals("//") && input.contains("\\n")) {
            String newDelimiter = extractDelimiter(input);
            delimiter += "(" + newDelimiter + ")"; // TODO 정규표현식 그룹으로 묶기
            input = input.substring(input.indexOf("\\n") + 2, input.length());
        }
        for (char c : input.toCharArray()) {
            if (!validateInput(c, delimiter)) {
                throw new IllegalArgumentException("잘못된 입력");
            }
        }
        return delimiter;
    }

    private boolean validateInput(char c, String delimiter) {
        return Character.isDigit(c) || delimiter.indexOf(c) != -1;
    }

    private String extractDelimiter(String input) {
//        String newDelimiter = input.split("//")[1].split("|\n|")[0];
        return input.substring(2, input.indexOf("\\n"));
    }

    public void splitInput() {
        stringNumbers = input.split(delimiter);
        // TODO
//        System.out.println("splitInput");
//        for (String stringNumber : stringNumbers) {
//            System.out.print(stringNumber + " ");
//        }
//        System.out.println();
    }

    public void addNumbers() {
//        System.out.println("addNumbers");
        for (String stringNumber : stringNumbers) {
//            System.out.println(stringNumber + " ");
            sum += Integer.parseInt(stringNumber);
        }
    }
}
