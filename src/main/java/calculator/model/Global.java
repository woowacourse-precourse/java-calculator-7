package calculator.model;

import java.util.List;

public class Global {

    private static Global instance;
    private String input;
    private String splitStr;
    private String[] strNums;
    private NumType numType;
    private List<? extends Number> numList;
    private Number result;

    private Global() {
        this.numType = NumType.INT;
    }

    public static Global getInstance() {
        if (instance == null) {
            instance = new Global();
        }
        return instance;
    }

    public String getInput() {
        return input;
    }

    public String getSplitStr() {
        return splitStr;
    }

    public String[] getStrNums() {
        return strNums;
    }

    public NumType getNumType() {
        return numType;
    }

    public Number getResult() {
        return result;
    }

    public List<? extends Number> getNumList() {
        return numList;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setSplitStr(String splitStr) {
        this.splitStr = splitStr;
    }

    public void setStrNums(String[] strNums) {
        this.strNums = strNums;
    }

    public void setNumType(NumType numType) {
        this.numType = numType;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public void setNumList(List<? extends Number> numList) {
        this.numList = numList;
    }
}
