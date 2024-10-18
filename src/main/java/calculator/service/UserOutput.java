package calculator.service;

import calculator.model.Global;

public class UserOutput {

    private final Global global;

    public UserOutput() {
        this.global = Global.getInstance();
    }

    public void print() {
        System.out.println("결과 : " + global.getResult());
    }
}
