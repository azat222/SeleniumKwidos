import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise2 {

    public static void main(String[] args) {
        int[] intArray = {2,4,5,6,5,7,7,8,9};
//        natali();
    }

    public static Set natali(int[] intArray){
//        int[] intArray = {2,4,5,6,5,7,7,8,9,5,7};
        Set<Integer> list1 = new HashSet<>();

        for(int i = 0; i< intArray.length; i++){
            for (int j = i +1 ; j<intArray.length; j++){
                if(intArray[i]==intArray[j])
                        list1.add(intArray[j]);
            }
        }
        return list1;
    }


    // TC1: array with multiple duplicates - > returned duplicated values only one time
    // TC2: array without duplicates
    // TC3: empty array - > empty set

    @Test
    public void testDuplicatedArray() {
        int[] intArray = {2,4,5,6,5,7,7,8,9};
        Set<Integer> list1 = new HashSet<>();
        list1.add(5);
        list1.add(7);

        Assert.assertEquals(natali(intArray), list1);
    }

}
