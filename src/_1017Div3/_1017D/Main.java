package _1017Div3._1017D;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long sA = ask(2, 1, n, sc);
            long sP = (long) n * (n + 1) / 2;
            long m = sA - sP;

            int l = 1, r = n, L = n;
            while (l <= r) {
                int mid = (l + r) / 2;
                long pA = ask(2, 1, mid, sc);
                long p = ask(1, 1, mid, sc);
                long d = pA - p;
                if (d == 0) {
                    l = mid + 1;
                } else {
                    L = mid;
                    r = mid - 1;
                }
            }

            long R = L + m - 1;
            System.out.println("! " + L + " " + R);
            System.out.flush();
        }
    }

    private static long ask(int type, int l, int r, Scanner sc) {
        System.out.println(type + " " + l + " " + r);
        System.out.flush();
        return sc.nextLong();
    }
}