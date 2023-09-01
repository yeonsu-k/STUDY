import java.io.*;
import java.util.*;

/*
 * 누적합 
 */

public class B28018시간이겹칠까 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine()); // 학생수
    int maxTime = 0, time[] = new int[1000002]; // 1~1000000범위에서 종료시간+1 사용을 위한 배열크기
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken()); // 시작 시각
      int E = Integer.parseInt(st.nextToken()); // 종료 시각
      time[S]++; // time[시각] = 해당 시각에 좌석 사용 학생수
      time[E + 1]--; // 끝나는 시간 + 1 에는 이용자 수 하나 줄어듬
      maxTime = Integer.max(maxTime, E);
    }

    for (int i = 1; i <= maxTime + 1; i++) {
      time[i] += time[i - 1];
    }

    int Q = Integer.parseInt(br.readLine()); // 특정 시각 수
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < Q; i++) {
      int check = Integer.parseInt(st.nextToken());
      sb.append(time[check]).append('\n');
    }

    System.out.print(sb);
  }
}
