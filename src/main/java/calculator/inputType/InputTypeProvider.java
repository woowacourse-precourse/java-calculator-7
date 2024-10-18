package calculator.inputType;

import java.util.ArrayList;
import java.util.List;

public class InputTypeProvider {


    public static List<InputType> provideInputTypelist() {
        List<InputType> inputTypeList = new ArrayList<>();
        inputTypeList.add(new DefaultInput());
        inputTypeList.add(new CustomInput());
        return inputTypeList;
    }
}
