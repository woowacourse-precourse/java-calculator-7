package calculator;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {

        String inputString = readLine();

        if(!checkEmpty(inputString)){
            return;
        }

        char separator;
        if(inputString.charAt(0) == '/'){
            separator = checkCustom(inputString);

            if(separator == '0'){
                throw new IllegalArgumentException("IllegalArgumentException 발생");
            }
        }
    }

    static boolean checkEmpty(String string){
        try {
            if(string == null || string.trim().equals("")){
                throw new IllegalArgumentException("IllegalArgumentException 발생");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    static char checkCustom(String string){ // 구분자 표시 : //(구분자)\n

        if(string.charAt(1) == '/' && string.charAt(3) == '\\' && string.charAt(4) == 'n'){
            if((string.charAt(2) >= 33 && string.charAt(2) <= 47) || (string.charAt(2) >= 58 && string.charAt(2) <= 64) || (string.charAt(2) >= 91 && string.charAt(2) <= 95) || (string.charAt(2) >= 123 && string.charAt(2) <= 126))
                return string.charAt(2);
        }

        return '0';
    }
}
