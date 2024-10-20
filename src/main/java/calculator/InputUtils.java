package calculator;

public class InputUtils {

    public final static String DEFAULT_DELIMITER = "[,:]";

    public final static String CUSTOM_DELIMITER_PREFIX = "//";
    public final static  String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final static int CUSTOM_DELIMITER_POSITION = 2;
    private final static int CUSTOM_DELIMITER_SUFFIX_POSITION = 3;

    public static String[] splitInputs(String input, String delimiter){
        return input.split(delimiter);
    }
    public static int[] StringToNumber(String[] inputs){
        int[] numbers = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++){
            validateInput(inputs[i]);
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        return numbers;
    }
    public static boolean isCustomDelimiter(String input){
        if(input.startsWith(CUSTOM_DELIMITER_PREFIX)){
            return input.indexOf(CUSTOM_DELIMITER_SUFFIX) == CUSTOM_DELIMITER_SUFFIX_POSITION;
        }return false;
    }
    public static String extractNumbers(String input){
        return input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length());
    }
    public static String extractDelimiter(String input){
        return Character.toString(input.charAt(CUSTOM_DELIMITER_POSITION));
    }
    public static void validateInput(String input){
        int number;
        try{
            number = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("조건에 맞게 입력해주세요");
        }

        if(number < 0){
            throw new IllegalArgumentException("0 이상의 숫자를 입력해주세요");
        }

    }

}
