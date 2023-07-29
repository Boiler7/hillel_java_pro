package HW7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValueCalculatorTest {
    @Test
    void doCalc(){
        String[][] array = {{"1", "4", "6", "9"},
                {"6", "5", "9", "6",},
                {"6", "9", "0", "1"},
                {"6", "5", "9", "6",}};

        int result = ArrayValueCalculator.doCalc(array);
        assertEquals(88 , result);
    }

    @Test
    void doCalcThrowableException1(){
        String[][] array = {{"1", "4", "6", "9"},
                            {"6", "5", "9", "6",},
                            {"6", "9", "0", "1"}};
        assertThrows(ArraySizeException.class, () -> ArrayValueCalculator.doCalc(array));

    }

    @Test
    void doCalcThrowableException2(){
        String[][] array = {{"1", "4", "6", "9"},
                            {"6", "5", "9", "6",},
                            {"6", "9", "0", "1"},
                            {"6", "5", "9", "6opj",}};
        assertThrows(ArrayDataException.class, () -> ArrayValueCalculator.doCalc(array));

    }
}