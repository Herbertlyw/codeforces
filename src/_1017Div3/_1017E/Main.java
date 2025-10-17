package _1017Div3._1017E;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            solve(n, k, a);
        }
        pw.close();
    }

    static void solve(int n, int k, int[] a) {
        boolean[] appeared = new boolean[n + 1];
        for (int num : a) {
            appeared[num] = true;
        }
        List<Integer> candidateList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!appeared[i]) {
                candidateList.add(i);
            }
        }
        if (candidateList.isEmpty()) {
            for (int i = 1; i <= n; i++) {
                candidateList.add(i);
            }
        }

        int last1 = a[n - 1];
        int last2 = a[n - 2];
        List<Integer> res = new ArrayList<>();
        int prev1 = last1;
        int prev2 = last2;
        for (int i = 0; i < k; i++) {
            int chosen = -1;
            for (int cand : candidateList) {
                if (cand != prev1 && cand != prev2) {
                    chosen = cand;
                    break;
                }
            }
            if (chosen == -1) {
                for (int cand : candidateList) {
                    if (cand != prev1) {
                        chosen = cand;
                        break;
                    }
                }
                if (chosen == -1) {
                    chosen = candidateList.get(0);
                }
            }
            res.add(chosen);
            prev2 = prev1;
            prev1 = chosen;
        }

        for (int i = 0; i < k; i++) {
            pw.print(res.get(i));
            if (i < k - 1) pw.print(" ");
        }
        pw.println();
    }
}