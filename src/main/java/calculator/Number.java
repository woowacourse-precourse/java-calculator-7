package calculator;

public class Number {
    private String[] extractedNumbers;

    public void extractNumbers(String input, String seperator){
        this.extractedNumbers = input.split(seperator);
    }

    public int validateAndParseNumber(String number) {
        if (!number.isEmpty()) {
            try {
                int num = Integer.parseInt(number);
                if (num <= 0) {
                    throw new IllegalArgumentException();
                }
                return num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return 0;
    }

    public String[] getExtractedNumbers(){
        return extractedNumbers;
    }
}
