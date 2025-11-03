import java.util.*;

public class Main {

    public static final Scanner sc = new Scanner(System.in);

    public static void solve() {
        long x = sc.nextLong();
        long y = sc.nextLong();
        int ans = 0;
        /**
         * 操作一只会减小x的值，而操作二会让x的值增加或保持不变
         * while的循环条件可以保证循环结束时x的位（如101）是y如（111）的子集，通过一次或运算即可由x变成y
         */
        while ((x&y) != x) {
            ans ++;
            x >>= 1;
        }
        System.out.println(ans + (x != y ? 1 : 0));
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