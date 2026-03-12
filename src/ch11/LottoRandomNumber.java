package ch11;

/*
    [책임, 역할] 로또 번호 생성 전달 전담 클래스

    SRP : Single Responsibility Principle - 단일 책임 원칙 (5가지 원칙)
    클래스 하나의 책임만 가져야 한다.
    즉 이 클래스는 오직 로또 번호 생성만 담당한다.
 */

import java.util.Arrays;
import java.util.Random;

public class LottoRandomNumber {

    static final int LOTTO_NUMBER_COUNT = 6;

    public int[] createNumber(){
        int[] lottoWinNum = new int[LOTTO_NUMBER_COUNT];
        Random random = new Random();

        for (int i = 0; i < lottoWinNum.length; i++) {
            lottoWinNum[i] = random.nextInt(45)+1;
            // 중복 비교
            for (int j = 0; j < i ; j++) {
                if(lottoWinNum[j] == lottoWinNum[i]){
                    i--;
                    break; // 중복 발견 시 즉시 이중for 탈출
                }
            }
        }

        Arrays.sort(lottoWinNum); // 오름차순 정렬

        return lottoWinNum;
    }; // end of createNumber


    public static void main(String[] args) {
        LottoRandomNumber lottoRandomNumber = new LottoRandomNumber();
        int[] result = lottoRandomNumber.createNumber();
        // 무조건 처음부터 끝까지 반복 시켜야 할때
        for (int num : result){
            System.out.print(num + " ");
        }

    }

} // end of class

