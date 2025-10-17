package _1017Div3._1017C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == b) {
                System.out.println(0);
                continue;
            }
            int k = 32 - Integer.numberOfLeadingZeros(a);
            int num = (1 << k) - 1;
            if (b > num) {
                System.out.println(-1);
                continue;
            }
            if (a != num) {
                System.out.println(2);
                System.out.println((a ^ num) + " " + (num ^ b));
            } else {
                System.out.println(1);
                System.out.println(num ^ b);
            }
        }
    }
}