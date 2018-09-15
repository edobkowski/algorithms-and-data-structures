package algorithms;

public class Sorters {

    public static void bubbleSort(int[] array) {
        for(int i = array.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int valueToInsert = array[i];
            int j = i;

            while(j > 0 && array[j-1] > array[j]) {
                swap(array, j, j-1);
                j--;
            }

            array[j] = valueToInsert;
        }

    }

    public static void selectionSort(int[] array) {

    }

    public static void mergeSort(int[] array) {

    }

    public static void quickSort(int[] array) {

    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
