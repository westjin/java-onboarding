package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        // target ex) browoanoommnaon


        String answer = "answer";
        char[] sToC = cryptogram.toCharArray(); //char배열로 옮기기

        int i,j = 0 ;

//        System.out.println("sToC.length : " + sToC.length);

        for(i = 1; i < sToC.length; i++) {
            if (sToC[i - 1] != sToC[i]) {// i-1 번째 값과 i 번째 값이 다를 경우
                sToC[j] = sToC[i - 1]; // j번째 인덱스에 i-1 번째 값 대입 값 보존 b r ...
                j++;
            } else { // 값이 같을 경우
                while (i < sToC.length && sToC[i - 1] == sToC[i]) {
                    i++; // 값을 추가하지 않는다.
                }
            }
        }

        if(j == 0){
            answer = "";
            return answer;
        }


        sToC[j++] = sToC[i-1]; //반복 종료 후 마지막 문자 추가하기

         answer = new String(sToC).substring(0,j); //char 배열을 다시 String으로 변환
//         System.out.println("answer : " + answer);
//         System.out.println( "j : " + j);

        if (j != sToC.length) { // j 와 sToC.length 비교 즉, 배열의 중복제거가 다 끝날때까지 재귀함수 이용
            return solution(answer);
        }


        return answer;
    }

//    public static void main(String[] args){
//
//
//        String str = "zyelleyz";
//        String res = solution(str);
//
//        System.out.println("결과 : "+ res);
//    }
}










