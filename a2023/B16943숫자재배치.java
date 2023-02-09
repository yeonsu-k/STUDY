import java.io.*;
import java.util.*;

public class B16943숫자재배치 {
  static int[] A;
  static int B, result = -1;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    String number = st.nextToken();
    B = Integer.parseInt(st.nextToken());

    A = new int[number.length()];
    for (int i = 0; i < number.length(); i++) {
      A[i] = number.charAt(i) - '0';
    }

    if (Integer.toString(B).length() >= A.length) {
      nCr(0, 0, 0, new boolean[A.length]);
    }

    System.out.println(result);
    br.close();
  }

  private static void nCr(int start, int cnt, int C, boolean[] visit) {
    if (cnt == A.length) {
      if (B > C) {
        result = Math.max(result, C);
      }
      return;
    }

    for (int i = 0; i < A.length; i++) {
      if ((cnt == 0 && A[i] == 0) || visit[i]) continue;
      visit[i] = true;
      nCr(i + 1, cnt + 1, C * 10 + A[i], visit);
      visit[i] = false;
    }
  }
}
