package onboarding;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        //'A' = 65,66,67,68,69... 'a' = 97
        //'Z' = 90,89,88,87,86.... 'z' = 122
        String[] data = { "Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A"};
        String[] OriginWord;

        Map<String,String> alpha = new HashMap<>();
        char[] originAlpha = new char[26];

        for(int i = 0; i < originAlpha.length; i++){
            alpha.put(Character.toString((char)('A'+i)),data[i]);
        }

        OriginWord = word.split("");



        for(String frogWord : OriginWord) {
//            System.out.println("frog : " + frogWord);
            boolean isAlpha = Character.isUpperCase(frogWord.charAt(0));

            String temp = alpha.get(frogWord.toUpperCase());
            if (temp == null){
                temp = " ";
            }
            else if(!isAlpha){
                temp = temp.toLowerCase();
            }

//            System.out.println("temp : " + temp);
            answer = answer.concat(temp);
//            System.out.println("answer : " + answer);
        }
//        answer = answer.concat(result);








        return answer;
    }
}