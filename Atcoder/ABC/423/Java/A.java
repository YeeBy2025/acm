import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int c = sc.nextInt();
        int cnt = 1;
        while(cnt*1000+cnt*c <= x) cnt ++;
        System.out.println((cnt-1)*1000);
    }
}