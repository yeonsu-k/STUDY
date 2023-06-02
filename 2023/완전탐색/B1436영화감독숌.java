import java.io.*;

public class B1436영화감독숌 {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int num = 666;
    int cnt = 1;

    while (N != cnt) {
      int temp = ++num;
      while (temp >= 666) {
        if (temp % 1000 == 666) {
          cnt++;
          break;
        }
        temp /= 10;
      }
    }

    System.out.print(num);
  }
}
