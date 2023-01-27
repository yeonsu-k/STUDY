import java.io.*;
import java.util.*;

public class B2503숫자야구 {
  public static void main(String[] args) throws Exception {
    //System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][3];
    int[] strike = new int[N];
    int[] ball = new int[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int number = Integer.parseInt(st.nextToken());
      arr[i][0] = number / 100; // 백의자리
      arr[i][1] = (number % 100) / 10; // 십의자리
      arr[i][2] = (number % 100) % 10; // 일의자리
      strike[i] = Integer.parseInt(st.nextToken());
      ball[i] = Integer.parseInt(st.nextToken());
    }

    // 처리
    int result = 0;
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        if (i == j) continue; // 백의자리 == 십의자리 경우 continue
        for (int k = 1; k <= 9; k++) {
          if (i == k) continue; // 백의자리 == 일의자리 경우 continue
          if (j == k) continue; // 십의자리 == 일의자리 경우 continue

          int count = 0;
          for (int m = 0; m < N; m++) {
            int strike_cnt = 0;
            int ball_cnt = 0;

            // 백의 자리
            if (i == arr[m][0]) strike_cnt++;
            else if (i == arr[m][1] || i == arr[m][2]) ball_cnt++;

            // 십의 자리
            if (j == arr[m][1]) strike_cnt++;
            else if (j == arr[m][0] || j == arr[m][2]) ball_cnt++;

            // 일의 자리
            if (k == arr[m][2]) strike_cnt++;
            else if (k == arr[m][0] || k == arr[m][1]) ball_cnt++;

            if (strike_cnt == strike[m] && ball_cnt == ball[m]) count++;

            if (count == N) result++;
          }
        }
      }
    }

    // 결과
    System.out.println(result);
  }
}