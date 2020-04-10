public class Exercises {

    public static void main (String[] args) {
        String str = "Test Pro";
        System.out.println(reverseString(str));
//        str.le
    }

    public static String reverseString(String actual){
        String expected = "";

        for (int i=actual.length()-1; i>=0; i--){

            expected+=actual.charAt(i);

        }
        return expected;

    }

    public static StringBuilder reverseString2(String actual){
        StringBuilder expected = new StringBuilder();

        expected.append(actual);
//        for (int i=actual.length()-1; i>=0; i--){
//
//            expected.append(actual.charAt(i));
//
//        }
        return expected.reverse();
    }

    int[] int2 = {1,2,3,4,5};


    // str 1 , str 2
    // str 1 = str 1 + str 2
}
