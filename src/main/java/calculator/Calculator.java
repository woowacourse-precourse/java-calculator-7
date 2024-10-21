    package calculator;
    import java.util.regex.Pattern;

    public class Calculator {
        private static final String DEFAULT_REGEX = ",|:";

        public int addNumbers(String input){
            String regEx = DEFAULT_REGEX;
            String numbers = input;
            if(input.startsWith("//")){
                input = input.replace("\\n", "\n");
                int regExIndex = input.indexOf("\n");
                if (regExIndex == -1) {
                    throw new IllegalArgumentException("커스텀 구분자 선언 후 개행이 필요 합니다.");
                } else{
                    regEx = input.substring(2, regExIndex);
                    numbers = input.substring(regExIndex + 1);
                }
            }
            return returnSum(splitNumbers(numbers, regEx));
        }
        private String[] splitNumbers(String numbers, String regEx){
            if(regEx.equals(DEFAULT_REGEX)){
                return numbers.split("[,:]");
            }
            return numbers.split(Pattern.quote(regEx));
        }

        public int returnSum(String[] numbers){
            int sum = 0;
            for (String num: numbers){
                int n = Integer.parseInt(num);
                sum += n;
            }
            return sum;
        }
    }
