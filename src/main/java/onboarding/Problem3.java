package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int temp = 0;
        //ex 33


        for (int i = 1; i <= number; i++) {
             temp = i;
            while (temp != 0) {
                if ( temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9)
                    answer++;
                temp /= 10;
            }
        }


        return answer;
    }
    //33 -> 14  36 -> 18
//    public static void main(String[] args){
//        int number = 36;
//        int result = solution(number);
//        System.out.println(result);

//    }
}
