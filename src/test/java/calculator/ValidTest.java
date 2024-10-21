package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
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
    @DisplayName("Custom 구분자가 없는 경우")
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

    @Test
    @DisplayName("식에 구분자가 연속될 경우")
    public void testWrongFormula() throws Exception {

        //Given
        CalculationUtil calculationUtil = new CalculationUtil("1,2,,3");

        //Then
        InvocationTargetException thrownException = assertThrows(InvocationTargetException.class, () -> {
            invokePrivateMethod(calculationUtil, "checkDivider");
        });

        //Then
        assertTrue(thrownException.getCause() instanceof IllegalArgumentException);
        assertEquals("Expression is wrong", thrownException.getCause().getMessage());
    }

    @Test
    @DisplayName("Custom 구분자가 형식이 잘못된 경우")
    public void testWrongCustomDivider() throws Exception {

        //Given
        CalculationUtil calculationUtil = new CalculationUtil("////tt\\n");

        // When
        InvocationTargetException thrownException = assertThrows(InvocationTargetException.class, () -> {
            invokePrivateMethod(calculationUtil, "checkCustomDivider");
        });

        //Then
        assertTrue(thrownException.getCause() instanceof IllegalArgumentException);
        assertEquals("Custom Divider format is wrong", thrownException.getCause().getMessage());

    }

    @Test
    @DisplayName("숫자 추출 테스트")
    public void testExtractNums() throws Exception {

        //Given
        CalculationUtil calculationUtil = new CalculationUtil("//n\\n1,23:456n78n9");

        //When
        invokePrivateMethod(calculationUtil, "checkCustomDivider");
        invokePrivateMethod(calculationUtil, "checkDivider");

        //Then
        Field numbersField = CalculationUtil.class.getDeclaredField("numbers");

        numbersField.setAccessible(true);

        List<Integer> numbers = (List<Integer>) numbersField.get(calculationUtil);

        assertEquals(1, numbers.get(0));
        assertEquals(23, numbers.get(1));
        assertEquals(456, numbers.get(2));
        assertEquals(78, numbers.get(3));
        assertEquals(9, numbers.get(4));
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
