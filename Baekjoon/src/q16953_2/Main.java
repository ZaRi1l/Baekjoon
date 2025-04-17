package q16953_2;

import java.util.Scanner;

public class Main {

    public static long func(long a, long b, long count) {
        // 종료조건
        if (a > b)
            return -1; // 불가능한 경우
        if (a == b)
            return count; // 성공한 경우

        // 재귀함수 (경우의 수 2개)
        ++count;
        long result1 = func(a * 2, b, count); // 2를 곱하기
        long result2 = func(a * 10 + 1, b, count); // 1을 오른쪽에 추가

        // 두 결과 중 더 작은 값 반환 (불가능한 경우 -1 처리)
        if (result1 == -1 && result2 == -1) // 두개 다 X
            return -1;
        if (result1 == -1) // 2곱하기 X
            return result2;
        if (result2 == -1) // 1추가 X
            return result1;
        return (result1 < result2) ? result1 : result2; // 둘중 작은 값 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long count = 1;
        sc.close();
        long result = func(a, b, count);
        System.out.println(result);
    }

}
