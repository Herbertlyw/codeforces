package _1017Div3._1017B;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            boolean found = false;
            int totalMasks = 1 << n;
            for (int mask = 0; mask < totalMasks; mask++) {
                List<Character> pChars = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                StringBuilder x = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        pChars.add(s.charAt(i));
                        indices.add(i + 1);
                    } else {
                        x.append(s.charAt(i));
                    }
                }
                if (!isNonDecreasing(pChars)) {
                    continue;
                }
                if (isPalindrome(x.toString())) {
                    System.out.println(pChars.size());
                    if (!pChars.isEmpty()) {
                        for (int j = 0; j < indices.size(); j++) {
                            if (j > 0) System.out.print(" ");
                            System.out.print(indices.get(j));
                        }
                        System.out.println();
                    } else {
                        System.out.println();
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(-1);
            }
        }
    }

    private static boolean isNonDecreasing(List<Character> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == '1' && list.get(i + 1) == '0') {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}