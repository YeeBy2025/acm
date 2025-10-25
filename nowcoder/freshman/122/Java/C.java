import java.util.*;

public class Main {

    public static final Scanner sc = new Scanner(System.in);

    public static void solve() {
        /**
         * 相当于每次操作：
         * 1. 如果存在两个或两个以上个负数，就能指定某一负数变成正数
         * 2. 或者存在一正一负两个数字，即可让某一正数变成负数
         * 3. 0乘任何数都会导致正数或负数少一个，所以只要cntZero不为0，并且正数数量大于m，直接输出cntAdd-m
         * 考虑最开始有多少个正数，比m少则应用第一种操作，比m多则应用第二种操作
         */
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int cntSub = 0;
        int cntAdd = 0;
        int cntZero = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] < 0) {
                a[i] = -1;
                cntSub ++;
            } else if (a[i] > 0){
                a[i] = 1;
                cntAdd ++;
            } else {
                cntZero ++;
            }
        }

        if (m == cntAdd) {
            System.out.println("0");
            return ;
        }

        if (cntZero > 0 && m < cntAdd) {
            System.out.println(cntAdd - m);
            return ;
        }

        if (m > cntAdd) {
            int ans = 0;
            while (cntSub >= 2 && m > cntAdd) {
                cntSub --;
                cntAdd ++;
                ans ++;
            }
            if (cntAdd == m) System.out.println(ans);
            else System.out.println("-1");
        } else if (m < cntAdd) {
            int ans = 0;
            while (cntSub >= 1 && cntAdd >= 1 && m < cntAdd) {
                cntSub ++;
                cntAdd --;
                ans ++;
            }
            if (cntAdd == m) System.out.println(ans);
            else System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        while (T > 0) {
            solve();
            T--;
        }
        sc.close();
    }
}