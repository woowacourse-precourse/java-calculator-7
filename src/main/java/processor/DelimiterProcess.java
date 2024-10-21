package processor;

import display.ConsoleDisplay;

//import display.ConsoleDisplay.input;

public class DelimiterProcess implements Processor{

    private String delimiterStr;
    private String delimiterRegex;
    public int startIdx = -1;
    public int endIdx = -1;
    public String startDelimiter = "//";
    public String endDelimiter = "\\n";
    public String separator = "|";
    public boolean hasCustomDelimiter;
    public boolean hasStartDelimiter;
    public boolean hasEndDelimiter;

    //기본 구분자 설정
    public DelimiterProcess() {
        this.delimiterStr = ",:";
    }

    public DelimiterProcess(String delimiterRegex){
        this();
        this.delimiterRegex = delimiterRegex;
    }


    public boolean hasCustomDelimiter(){
        return hasStartDelimiter && hasEndDelimiter;
    }

    public String getDelimiterStr() {
        return delimiterStr;
    }

    public void setDelimiterStr(String delimiterStr) {
        this.delimiterStr = delimiterStr;
    }

    public String getDelimiterRegex() {
        return delimiterRegex;
    }

    public void setDelimiterRegex(String delimiterRegex) {
        this.delimiterRegex = delimiterRegex;
    }

    @Override
    public void calculate() {
        ConsoleDisplay display = new ConsoleDisplay();
        String original = display.getInput();
        setStartIdx(original, startDelimiter);
        setEndIdx(original, endDelimiter);

        if(hasStartDelimiter && hasEndDelimiter){
            setDelimiter(original, startIdx, endIdx);
        }
        setDelimiterRegex();
    }

    public void getDelimiter(){

    }

    public void setStartIdx(String original, String startDelimiter){
        if(original.contains(startDelimiter)){
            startIdx = original.indexOf(startDelimiter);
            hasStartDelimiter = true;
        }else {
            startIdx = -1;
            hasStartDelimiter = false;
        }
    }

    public void setEndIdx(String original, String endDelimiter){
        if(original.contains(endDelimiter)){
            endIdx = original.indexOf(endDelimiter);
            hasEndDelimiter = true;
        }else{
            hasStartDelimiter = false;
        }
    }

    public int getStartIdx(){
        return startIdx;
    }

    public int getEndIdx(){
        return endIdx;
    }

    public void setDelimiter(String original, int startIdx, int endIdx){
        if(hasCustomDelimiter){
            delimiterStr += original.substring(startIdx+2, endIdx).trim();
        }
        //if삭제..??
        //startIdx & endIdx가 -1일수 있...
    }


    public void setDelimiterRegex(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<delimiterStr.length(); i++){
            char ch = delimiterStr.charAt(i);
            if(ch=='|'){
                sb.append("\\|");
            }else{
                sb.append(ch);
            }

            if(i<delimiterStr.length()-1){
                sb.append(separator);
            }
        }
        setDelimiterRegex(sb.toString());
    }
}
