package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenMultiArr {

    public static List<Object> flat(List<Object> objects) {
        List<Object> result = new ArrayList();

        for(Object o : objects) {
            if(o instanceof List) {
                result.addAll(flat((List<Object>) o));
            } else {
                result.add(o);
            }
        }

        return result;
    }

    public static Object[] flat(Object[] objects) {
        Object[] result = new Object[0];

        for(Object o : objects) {
            if(o instanceof Object[]) {
                result = merge(result, flat((Object[]) o));
            } else {
                result = addToArray(result, o);
            }
        }

        return result;
    }

    private static Object[] addToArray(Object[] array, Object element) {
        int newSize = array.length + 1;
        Object[] tempArray = Arrays.copyOf(array, newSize);
        tempArray[newSize-1] = element;

        return tempArray;
    }
    private static Object[] merge(Object[] array1, Object[] array2) {
        int newSize = array1.length + array2.length;
        Object[] tempArray = Arrays.copyOf(array1, newSize);
        for(int i = array1.length, j = 0; i < newSize; i++, j++) {
            tempArray[i] = array2[j];
        }

        return tempArray;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        List nestedList = new ArrayList<>();
        nestedList.addAll(Arrays.asList(1,2,3,5,3,new ArrayList<>(Arrays.asList("lol", "zupa"))));
        list.add(nestedList);
        list.addAll(Arrays.asList(3,2,5,3,2));

        List res = flat(list);

        System.out.println(res);

        Object[][][]  arr = {{{1,2},{3,2},{4,5}},{{3,4},{1,3},{3,2}},{{4,3}}};
        Object[] flaten = flat(arr);

        System.out.println(Arrays.asList(flaten));
    }
}
