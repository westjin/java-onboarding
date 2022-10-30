package onboarding;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiNum = 0;
        int crongNum = 0;

        int answer = Integer.MAX_VALUE;

        //각각의 페이지 설정
        setPage(pobi);
        setPage(crong);
        //각자의 큰 수 찾기
        pobiNum = getBigNum(pobi);

        crongNum = getBigNum(crong);

        if (pobiNum == -1 || crongNum == -1){
            answer = -1;
            return answer;
        }

        if(pobiNum > crongNum){
            answer = 1;
            return  answer;
        } else if (pobiNum < crongNum) {
            answer = 2;
            return answer;
        }else answer = 0;



        return answer;
    }

    public static int findBigNum(List<Integer> eachNum){
        int addResult = 0;
        int mulResult = 1;

        for (int i = 0; i < eachNum.size(); i++){
            addResult += eachNum.get(i);
        }
        for (int j = 0; j < eachNum.size(); j++){
            mulResult *= eachNum.get(j);
        }

//
//        if (addResult > mulResult){
//            return addResult;
//        }
//        else return mulResult;

        return Math.max(addResult,mulResult);

    }


    public static int getBigNum(List<Integer> pageOwner){

        List<Integer> eachNumL = new ArrayList<Integer>(); //왼쪽 페이지 각 자리수를 담을 배열리스트 생성
        List<Integer> eachNumR = new ArrayList<Integer>(); //오른쪽 페이지 각 자리수를 담을 배열리스트 생성

        int leftPage = 0;
        int rightPage = 1;

        int originLeftNum = pageOwner.get(leftPage);
        int originRightNum = pageOwner.get(rightPage);

        int leftBigNum = 0;
        int rightBignum = 0;

        if (originRightNum - originLeftNum != 1){
            return -1;
        }


        while(originLeftNum > 0) {
            eachNumL.add(originLeftNum % 10);
            originLeftNum  /= 10;
        }


        leftBigNum = findBigNum(eachNumL);




        while(originRightNum > 0) {
            eachNumR.add(originRightNum % 10);
            originRightNum /= 10;
        }

        rightBignum = findBigNum(eachNumR);


//        if (leftBigNum > rightBignum)
//            return leftBigNum;
//
//        else return rightBignum;
//
        return Math.max(leftBigNum,rightBignum);
    }




    public static void setPage(List<Integer> pageOwner){

        Random rd = new Random(); // 책을 임의로 펼칠 난수

        pageOwner.add((rd.nextInt(400)+1)); // range : 1 ~ 400
        if(pageOwner.get(0) % 2 == 0){ // 처음 뽑은 난수가 짝수일 경우 오른쪽 페이지로 설정해준다.
            pageOwner.add(0, pageOwner.get(0));
            pageOwner.remove(0);
            pageOwner.add(0,pageOwner.get(0)-1);

        } else {
            pageOwner.add(pageOwner.get(0)+1);
        }


    }






    public static void main(String[] args){

        List<Integer> pobi = new ArrayList<Integer>(2); //pobi 배열리스트 생성
        List<Integer> crong = new ArrayList<Integer>(2); //pobi 배열리스트 생성

        System.out.println(solution(pobi,crong));

    }
}
