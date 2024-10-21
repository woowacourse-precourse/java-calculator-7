    package calculator;
    import java.util.ArrayList;
    import java.util.List;
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
                }
                regEx = input.substring(2, regExIndex);
                if(regEx.isEmpty()){
                    throw new IllegalArgumentException();
                }
                numbers = input.substring(regExIndex + 1);
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
            List<Integer> parsedNumbers = new ArrayList<>();

            int sum = 0;
            for (String num: numbers){
                if(num.trim().isEmpty()){
                    throw new IllegalArgumentException("숫자가 존재 하지 않는다.");
                }
                try{
                    int n = Integer.parseInt(num.trim());
                    if(n<0){
                        throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                    }
                    parsedNumbers.add(n);
                } catch (NumberFormatException e){
                    throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다.");
                }

            }
            for (int num : parsedNumbers) {
                sum += num;
            }
            return sum;
        }
    }
