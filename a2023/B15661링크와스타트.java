import java.io.*;
import java.util.*;

public class B15661링크와스타트 {
  static int N;
  static int[][] map;
  static boolean[] visit; // true, false로 팀 구분
  static int min;

  public static void main(String[] args) throws Exception {
    //System.setIn(new FileInputStream("index.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visit = new boolean[N];
    min = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    // 처리
    setTeam(0);

    // 출력
    System.out.println(min);
  }

  private static void setTeam(int cnt) {
    if (min == 0) return;
    if (cnt == N) {
      level();
      return;
    }
    visit[cnt] = true;
    setTeam(cnt + 1);
    visit[cnt] = false;
    setTeam(cnt + 1);

  }

  private static void level() {
    int startTeam = 0, linkTeam = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        // 같은 팀끼리 합산
        if (visit[i] && visit[j])
          startTeam += map[i][j] + map[j][i];
        else if (!visit[i] && !visit[j])
          linkTeam += map[i][j] + map[j][i];
      }
    }

    min = Math.min(min, Math.abs(startTeam - linkTeam));
  }

}