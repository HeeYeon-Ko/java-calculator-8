package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int result = 0;
    static String[] nums;

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        //커스텀 구분자
        if (input.startsWith("//")) {
            String[] customParts = input.split("\\\\n");
            String customDelimiter = customParts[0].substring(2);
            String numberPart = customParts[1];

            nums = numberPart.split(customDelimiter);

            for (int i = 0; i < nums.length; i++) {
                try {
                    int num = Integer.parseInt(nums[i]);

                    if (num < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }

                    result += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
                }
            }

        } else {
            nums = input.split("[,:]");

            for (int i = 0; i < nums.length; i++) {
                try {
                    int num = Integer.parseInt(nums[i]);

                    if (num < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }

                    result += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
                }
            }
        }

        System.out.println("결과 : " + result);
    }
}
