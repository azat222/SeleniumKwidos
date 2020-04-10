public class Exercise3 {

//    Input: n = 234
//    Output: 15
//    Explanation:
//    Product of digits = 2 * 3 * 4 = 24
//    Sum of digits = 2 + 3 + 4 = 9
//    Result = 24 - 9 = 15

    public static void main(String[] args) {
        System.out.println(solution(4421));
        // {2, 3, 4}


    }

    public static int solution(int i) {
        int product = 1;
        int sum =0;

        while (i > 0) {
            int reminder = i % 10;
            product *= reminder;
            sum += reminder;
            i = i / 10;
        }
        return  product - sum;
    }
}
