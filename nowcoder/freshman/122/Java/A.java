import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int[] a = new int[6];
            int[] b = new int[6];
            for (int i = 0; i < 6; i++) a[i] = sc.nextInt();
            for (int i = 0; i < 6; i++) b[i] = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cnt = 0;
            for (int i = 0; i < 6; i++) {
                if (a[i] == y) cnt ++;
                if(b[i] == y) cnt ++;
            }
            if (cnt < x) System.out.println("win");
            else System.out.println("lose");
            T--;
        }
        sc.close();
    }
}