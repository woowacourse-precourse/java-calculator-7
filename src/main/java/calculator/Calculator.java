    package calculator;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.regex.Pattern;

    public class Calculator {
        private static final String DEFAULT_REGEX = ",|:";
        private  static final String CUSTOM_DELIMITER_PREFIX = "//";
        private  static final String END_PLACEMENT = "\\n";

        // 커스텀 개행 문자 있는지 판별하여 regEx 갱신
        public int addNumbers(String input){
            String regEx = DEFAULT_REGEX;
            String numbers = input;
            if(input.startsWith(CUSTOM_DELIMITER_PREFIX)){
                input = input.replace(END_PLACEMENT, "\n");
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
        // 문자열에서 구분자 기준으로 Split
        private String[] splitNumbers(String numbers, String regEx){
            if(regEx.equals(DEFAULT_REGEX)){
                return numbers.split("[,:]");
            }
            return numbers.split(Pattern.quote(regEx));
        }

        // 숫자의 합을 계산 해준다
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
