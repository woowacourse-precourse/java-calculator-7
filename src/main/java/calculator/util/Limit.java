package calculator.util;

public enum Limit {
    MAX_DIGIT(30),
    MAX_NUMBER(1000);

    int value;

    Limit(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
