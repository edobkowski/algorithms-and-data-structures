package algorithms;

public class BinarySearch {
    public static boolean search(int[] array, int n) {
        int[] tempArray = array.clone();
        Sorters.insertionSort(tempArray);

        int leftIndex = 0;
        int rightIndex = tempArray.length - 1;

        while(leftIndex <= rightIndex) {
            int middleIndex = (int) Math.floor((leftIndex + rightIndex)/2);
            if(n == tempArray[middleIndex]) {
                return true;
            } else if(n > tempArray[middleIndex]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }

        return false;
    }
}
