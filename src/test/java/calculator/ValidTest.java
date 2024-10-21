package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidTest {

    @Test
    @DisplayName("Custom 구분자가 있는 경우")
    public void testCheckCustomDividerAndFields() throws Exception {
        //Given
        CalculationUtil calculationUtil = new CalculationUtil("//;\\n1;2;3");

        //When
        invokePrivateMethod(calculationUtil, "checkCustomDivider");

        //Then
        Field inputField = CalculationUtil.class.getDeclaredField("input");
        Field customDividerField = CalculationUtil.class.getDeclaredField("customDivider");
        Field isCustomField = CalculationUtil.class.getDeclaredField("isCustom");

        inputField.setAccessible(true);
        customDividerField.setAccessible(true);
        isCustomField.setAccessible(true);

        String inputValue = (String) inputField.get(calculationUtil);
        char customDividerValue = (char) customDividerField.get(calculationUtil);
        boolean isCustomValue = (boolean) isCustomField.get(calculationUtil);

        assertEquals("1;2;3", inputValue);
        assertEquals(';', customDividerValue);
        assertTrue(isCustomValue);
    }

    @Test
    @DisplayName("Custom 구분자가 있는 경우")
    public void testCheckNoCustomDivider() throws Exception {

        //Given
        CalculationUtil calculationUtil = new CalculationUtil("1,24:3");

        //When
        invokePrivateMethod(calculationUtil, "checkCustomDivider");

        //Then
        Field inputField = CalculationUtil.class.getDeclaredField("input");
        Field isCustomField = CalculationUtil.class.getDeclaredField("isCustom");

        inputField.setAccessible(true);
        isCustomField.setAccessible(true);

        String inputValue = (String) inputField.get(calculationUtil);
        boolean isCustomValue = (boolean) isCustomField.get(calculationUtil);

        assertEquals("1,24:3", inputValue);
        assertFalse(isCustomValue);
    }

    /**
     * private 메서드 호출
     */
    private void invokePrivateMethod(Object obj, String methodName, Class<?>... parameterTypes) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        method.invoke(obj);
    }

}
