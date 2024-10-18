package calculator.checkMethod;

public class CheckInputType {

    public String checkType(String input){

        String type;
        if (input.startsWith("//")){
            type = "custom";
        } else{
            type = "basic";
        }

        return type;
    }
}
