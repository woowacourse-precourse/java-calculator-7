package calculator.tool1;

public class StringChecker {

    public static boolean checkString(String input){
        //문자열 유효성 체크
        if (!input.startsWith("//")){
            return false;
        }else if (input.endsWith("\n")){
            // "//\n"일 경우
            return false;
        }else if(!input.contains("//\n")){
            return false;
        }else{
            return true;
        }



    }

    public String makeString(String input, String input2){
        return input + "\n" + input2;
    }



}
