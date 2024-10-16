package calculator;

public class Checkdelemeter {

    char[] delemeter = new char[3];

    char[] AddDelemeter(String input){
        String check_slash = "";
        String check_line = "";
        String slash = "//";
        String line = "\\n";
        check_slash += input.charAt(0);
        check_slash += input.charAt(1);
        check_line += input.charAt(3);
        check_line += input.charAt(4);
        char adding_delemeter;
        //input의 사이즈 확인 예외처리
        if(slash == check_slash && line == check_line){
            adding_delemeter = input.charAt(2);
            delemeter[2] = adding_delemeter;
            // delemeter가 유효한 char인지 예외처리
        }
        return delemeter;
    }

    Checkdelemeter(){
        delemeter[0] = ',';
        delemeter[1] = ':';
    }
}
