package calculator;

public class Calculator {
    private String input;
    private String target;
    private String customseperator;
    private String seperator;
    private int result = 0;

    public Calculator(String input) {
        this.input = input;
    }

    public void calculate() {
        try{
            if(checkCustom()){
                deleteSeperator(seperator);
                checkException();
                getResult();
            } else {
                deleteSeperator();
                checkException();
                getResult();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Incorrect input value >> " + e);
        }
    }

    private boolean checkCustom() {
        if (input.length() < 5){
            target = input;
            return false;
        } else {
            customseperator = input.substring(0, 5);
            if (customseperator.startsWith("//") && customseperator.endsWith("\\n")){
                seperator = customseperator.substring(2, 3);
                target = input.substring(5, input.length());
                return true;
            } else {
                target = input;
                return false;
            }
        }
    }

    private void deleteSeperator() {
        target = target.replace(":","");
        target = target.replace(",","");
    }

    private void deleteSeperator(String seperator) {
        target = target.replace(":","");
        target = target.replace(",","");
        target = target.replace(seperator,"");
    }

    private void checkException(){
        String regex = "^[1-9][0-9]*$";
        if (!target.matches(regex)){
            throw new IllegalArgumentException("Incorrect input value >> " + target);
        }
    }

    private void getResult(){
        for(int i=0; i<target.length(); i++){
            result += Character.getNumericValue(target.charAt(i));
        }
        System.out.println("Result : " + result);
    }

}





















