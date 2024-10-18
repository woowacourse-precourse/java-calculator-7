package calculator.service;

import calculator.controller.Calculator;
import calculator.model.Global;
import calculator.model.NumType;
import calculator.service.adder.DecAdder;
import calculator.service.adder.IntAdder;
import calculator.service.convertor.DecConverter;
import calculator.service.convertor.IntConverter;

public class NumTypeResolver {

    private static final Global global = Global.getInstance();

    private NumTypeResolver() {
    }

    public static void resolveNumType(Calculator calculator) {
        String[] strNums = global.getStrNums();

        for (String i : strNums) {
            if (i.contains(".")) {
                global.setNumType(NumType.DEC);
                break;
            }
        }

        resolveConverterAndAdder(calculator);
    }

    private static void resolveConverterAndAdder(Calculator calculator) {
        NumType numType = global.getNumType();

        if (numType == NumType.INT) {
            calculator.setNumConverter(new IntConverter());
            calculator.setNumAdder(new IntAdder());
        } else if (numType == NumType.DEC) {
            calculator.setNumConverter(new DecConverter());
            calculator.setNumAdder(new DecAdder());
        }
    }
}
