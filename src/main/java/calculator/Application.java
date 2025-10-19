package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int result = 0; // 결과
    static String[] nums; // 추출한 숫자

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 사용자 입력

        // 빈 문자열 입력 시
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 커스텀 구분자 지정시
        if (input.startsWith("//")) {
            String[] customParts = input.split("\\\\n");
            String customDelimiter = customParts[0].substring(2);
            String numberPart = customParts[1];

            nums = numberPart.split(customDelimiter);

            calculate(nums);

        } else { // 기본 구분자
            nums = input.split("[,:]");

            calculate(nums);
        }

        // 결과 출력
        System.out.println("결과 : " + result);
    }

    // 더하기 계산
    private static void calculate(String[] arr) {
        for (String s : arr) {
            try {
                int num = Integer.parseInt(s);

                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }

                result += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }
}
