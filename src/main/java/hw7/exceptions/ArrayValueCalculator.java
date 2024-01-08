package hw7.exceptions;

public class ArrayValueCalculator {
    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        if (array.length != 4 || array[1].length != 4) {
            throw new ArraySizeException("Array have to be 4x4 in size");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Cannot be parsed to int [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {{"1", "4", "6", "9"},
                            {"6", "5", "9", "';6",},
                            {"6", "9", "0", "1"},
                            {"6", "5", "9", "6",}};

        System.out.println(doCalc(array));
    }
}
