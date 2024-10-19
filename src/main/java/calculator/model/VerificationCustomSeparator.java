package calculator.model;

public class VerificationCustomSeparator {

    private final String custom;

    public VerificationCustomSeparator(String custom){
        this.custom = custom;
        verifyCustomSeparator();
    }

    public void verifyCustomSeparator(){
        verifyCustomIncludeNums();
        verifyCustomGrammar();
    }

    private void verifyCustomIncludeNums(){
        if(custom.matches("[+-]?\\d+(\\.\\d+)?")){
            throw new IllegalArgumentException("커스텀 구분자에는 숫자가 들어갈 수 없습니다!");
        }
    }

    private void verifyCustomGrammar(){
        if(custom.contains("//") || custom.contains("\\n")){
            throw new IllegalArgumentException("커스텀 구분자에는 //과 \\n이 들어갈 수 없습니다!");
        }
    }
}
