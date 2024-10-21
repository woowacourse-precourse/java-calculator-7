package calculator.domain;

import calculator.domain.constant.CustomDelimBracket;

public class CustomDelimExtract {

    private static String lining;

    public static String getEssence(String coveredCustomDelim) {
        lining = coveredCustomDelim;
        hatchBracket(CustomDelimBracket.OPEN.get());
        hatchBracket(CustomDelimBracket.CLOSE.get());
        return lining;
    }

    private static void hatchBracket(String bracket) {
        lining = lining.replace(bracket, "");
    }

}
