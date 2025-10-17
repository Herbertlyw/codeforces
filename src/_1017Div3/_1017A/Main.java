package _1017Div3._1017A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int maxAvg = Integer.MIN_VALUE;
            for (int l = 0; l < n; l++) {
                int sum = 0;
                for (int r = l; r < n; r++) {
                    sum += a[r];
                    int len = r - l + 1;
                    int avg = sum / len;
                    if (avg > maxAvg) {
                        maxAvg = avg;
                    }
                }
            }
            System.out.println(maxAvg);
        }
    }
}