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
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void mergeSort(int[] array) {
        sortByMerge(array, 0, array.length-1);
    }

    private static void sortByMerge(int[] array, int leftIndex, int rightIndex) {
        if(leftIndex >= rightIndex) {
            return;
        }

        int middleIndex = (int) Math.floor((leftIndex+rightIndex)/2);
        sortByMerge(array, leftIndex, middleIndex);
        sortByMerge(array, middleIndex+1, rightIndex);

        merge(array, leftIndex, middleIndex, rightIndex);
    }

    private static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int[] tempArray = array.clone();

        int i = leftIndex;
        int j = middleIndex + 1;
        int k = leftIndex;

        while(i <= middleIndex && j <= rightIndex) {
            if(tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        // copy the rest of left or right array if not whole array was iterated through
        while(i <= middleIndex) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
        while(j <= rightIndex) {
            array[k] = tempArray[j];
            k++;
            j++;
        }
    }

    public static void quickSort(int[] array) {
        sortByQuick(array, 0, array.length-1);
    }

    private static void sortByQuick(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int pivot = array[right];
        int pivotIndex = partitionArray(array, left, right, pivot);

        sortByQuick(array, left, pivotIndex-1);
        sortByQuick(array, pivotIndex+1, right);
    }

    private static int partitionArray(int[] array, int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (leftPointer < array.length && array[++leftPointer] < pivot);
            while (rightPointer > 0 && array[--rightPointer] > pivot);

            if(leftPointer >= rightPointer) {
                break;
            } else {
                swap(array, leftPointer, rightPointer);
            }
        }

        swap(array, leftPointer, right);

        return leftPointer;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
