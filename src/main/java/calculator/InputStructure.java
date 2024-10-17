package calculator;

public class InputStructure {
    private Character customSeparator = null;
    private String formulaString = "";

    public InputStructure(String str){
        if(str.startsWith("//")){
            int idx = str.indexOf("\\n");
            if(idx == -1){
                throw new IllegalArgumentException();
            }
            this.customSeparator = str.charAt(3);
            this.formulaString = str.substring(idx+2);
        } else{
            this.formulaString = str;
        }
    }

    public String getFormulaString(){
        return formulaString;
    }

    public Character getCustomSeparator(){
        return customSeparator;
    }

}
