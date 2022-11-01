package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        List<Integer> cash = new ArrayList<Integer>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        int count = 0;

        for (int bigMoney = 0; bigMoney < cash.size(); bigMoney++) {
            count = 0;
            if (money / cash.get(bigMoney) != 0) {

                count += money / cash.get(bigMoney);

            }
            answer.add(bigMoney, count);
            money %= cash.get(bigMoney);
            System.out.println("money : " + money);

        }


        return answer;
    }
}