import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int cnt0 = 0;
            int cnt1 = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x == 0) cnt0 ++;
                else cnt1 ++;
            }
            if (cnt1 >= Math.ceil((k+1)*1./2) || cnt0 >= k) System.out.println("0");
            else System.out.println("1");
            T--;
        }
        sc.close();
    }
}