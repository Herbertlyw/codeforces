package _1017Div3._1017E;

import java.io.*;
import java.util.*;

public class Main {
    static void print(List<Long> c, long k) {
        int cnt = 0;
        while (k-- > 0) {
            System.out.print(c.get(cnt) + " ");
            cnt++;
            cnt %= c.size();
        }
        System.out.println();
    }

    static void solve(BufferedReader br, PrintWriter out) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] a = new long[(int)(n + 1)];
        long[] b = new long[(int)(n + 1)];
        List<Long> c = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            b[(int)a[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (b[i] == 0) c.add((long)i);
        }

        if (c.size() == 0) {
            c.add(a[(int)n - 2]);
            c.add(a[(int)n - 1]);
            c.add(a[(int)n]);
            print(c, k);
        }
        else if (c.size() == 1) {
            if (a[(int)n - 1] == a[(int)n]) c.add(a[(int)n - 2]);
            else c.add(a[(int)n - 1]);
            c.add(a[(int)n]);
            if (k >= 1) {
                k--;
                System.out.print(c.get(0) + " ");
            }
            Collections.swap(c, 0, 1);
            Collections.swap(c, 1, 2);
            print(c, k);
        }
        else if (c.size() == 2) {
            c.add(a[(int)n]);
            if (k >= 2) {
                k -= 2;
                System.out.print(c.get(0) + " " + c.get(1) + " ");
            } else {
                System.out.println(c.get(0));
            }
            Collections.swap(c, 0, 2);
            Collections.swap(c, 1, 2);
            print(c, k);
        }
        else {
            print(c, k);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            solve(br, out);
        }

        out.flush();
        out.close();
    }
}