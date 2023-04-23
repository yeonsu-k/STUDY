import java.io.*;
import java.util.*;

public class B16918봄버맨 {
  static int[] dx = { -1, 0, 1, 0 }; // ↑ → ↓ ←
  static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    char[][] map = new char[R][C];
    char[][] miniBombMap = new char[R][C];
    char[][] bigBombMap = new char[R][C];
    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().toCharArray();
      if (N > 1) {
        Arrays.fill(miniBombMap[i], 'O');
        Arrays.fill(bigBombMap[i], 'O');
      }
    }

    if (N % 2 == 0) {
      // 맵 전체에 폭탄 설치 맵
      map = miniBombMap;
    } else if (N > 1) {
      // 일부 폭탄 터진 후 맵(N % 4 == 3)
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (map[i][j] == 'O') {
            miniBombMap[i][j] = '.';
            for (int k = 0; k < 4; k++) {
              int nx = i + dx[k];
              int ny = j + dy[k];
              if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                continue;
              miniBombMap[nx][ny] = '.';
            }
          }
        }
      }
      map = miniBombMap;

      if (N % 4 == 1) {
        // 일부 제외한 나머지 폭탄 터진 후 맵 모양(N % 4 == 1)
        for (int i = 0; i < R; i++) {
          for (int j = 0; j < C; j++) {
            if (miniBombMap[i][j] == 'O') {
              bigBombMap[i][j] = '.';
              for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                  continue;
                bigBombMap[nx][ny] = '.';
              }
            }
          }
        }
        map = bigBombMap;
      }
    }

    for (char[] str : map) {
      System.out.println(str);
    }
  }
}
