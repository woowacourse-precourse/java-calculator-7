package calculator;

public class StringCalculator {

    public String[] splitString(String input, String delimiter) {
        return input.split(delimiter);
    }

    public int stringToInt(String number){
        if(number.isEmpty()) return 0;
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닌 문자가 있습니다.");
        }
    }

    public int addString(String[] numbers){
        int sum=0;
        for(String number:numbers){

            int num = stringToInt(number);
            if(num < 0)
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            sum+=num;
        }
        return sum;
    }

    public int stringCalculate(String input){
        if(input.isEmpty())
            return 0;

        String delimiter = ",|:";
        String specialChars = ".^$*+?()[]{}\\|/";

        if(input.startsWith("//")){
            if(input.charAt(3)=='\\'&&input.charAt(4)=='n'){
                String customDelimiter = String.valueOf(input.charAt(2));
                if(input.charAt(2)>='0'&&input.charAt(2)<='9')
                    throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
                if(specialChars.indexOf(customDelimiter) != -1)
                    delimiter+="|\\"+customDelimiter;
                else
                    delimiter+="|"+customDelimiter;
                input = input.substring(5);
            } else{
                throw new IllegalArgumentException("커스텀 구분자 형식이 유효하지 않습니다.");
            }
        }
        String[] numbers = splitString(input, delimiter);
        int sum = addString(numbers);

        return sum;
    }

}
