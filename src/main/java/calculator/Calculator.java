    package calculator;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Calculator {
        private String[] splitNumbers(String numbers, String regEx){
            if(regEx.equals(",|:")){
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

        public int addNumber(String input){
            String regEx = ",|:";
            String numbers = input;
            if(input.startsWith("//")){
                int regExIndex = input.indexOf("\n");
                if (regExIndex != -1) {
                    regEx = input.substring(2, regExIndex);
                    numbers = input.substring(regExIndex + 1);
                }
            }
            return returnSum(splitNumbers(numbers, regEx));
        }
    }
