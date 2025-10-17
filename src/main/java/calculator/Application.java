package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args)  {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if(input.isEmpty()){
            System.out.println("결과 : 0");
            return;
        }

        String[] nums = input.split("[,:]");
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            try{
                int num = Integer.parseInt(nums[i]);

                if(num < 0){
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }

                result += num;
            } catch(NumberFormatException e){
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }

        System.out.println("결과 : " + result);
    }
}
