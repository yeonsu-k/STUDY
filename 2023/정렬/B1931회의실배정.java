import java.io.*;
import java.util.*;

/* 
 * Arrays.sort로 정렬 재정의 하기
 */

public class B1931회의실배정 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] time = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
      time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
    }
    Arrays.sort(time, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1])
          return o1[0] - o2[0];
        return o1[1] - o2[1];
      }

    });

    int cnt = 1, last = time[0][1];
    for (int i = 1; i < N; i++) {
      if (last <= time[i][0]) {
        last = time[i][1];
        cnt++;
      }
    }

    System.out.print(cnt);
  }

}