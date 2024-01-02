import java.io.*;
import java.util.*;

public class B1339단어수학 {

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] alpha = new int[26];
    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      char[] arr = br.readLine().toCharArray();
      int len = arr.length - 1;
      for (int i = 0; i <= len; i++) {
        alpha[arr[i] - 'A'] += (int) Math.pow(10, len - i); // 자리수
      }
    }

    Arrays.sort(alpha);
    int result = 0;
    int num = 9;
    for (int i = 25; i >= 0; i--) {
      if (alpha[i] == 0)
        break;
      result += alpha[i] * num--;
    }

    System.out.print(result);
  }
}