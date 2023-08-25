import java.io.*;
import java.util.*;

public class B1946신입사원 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine()); // 지원자 수
      int[] person = new int[N + 1]; // 1차 성적 순서로 2차 성적 받기
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        person[num1] = num2;
      }

      int cnt = 1, rank = person[1]; // 합격자 수, 비교 기준 순위
      for (int i = 2; i <= N; i++) {
        if (rank > person[i]) { // 1차 순위가 낮은 사람이 2차 순위가 더 높으면
          rank = person[i];
          cnt++;
        }
      }

      sb.append(cnt).append('\n');
    }

    System.out.print(sb.toString());
  }
}
