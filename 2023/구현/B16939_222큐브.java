import java.io.*;
import java.util.*;

public class B16939_222큐브 {
  static int[] cube = new int[25];
  static int[][][][] rubiks = {
      { { { 13, 14 }, { 5, 6 }, { 17, 18 }, { 21, 22 } },
          { { 15, 16 }, { 7, 8 }, { 19, 20 }, { 23, 24 } } },
      { { { 1, 3 }, { 5, 7 }, { 9, 11 }, { 22, 24 } },
          { { 2, 4 }, { 6, 8 }, { 10, 12 }, { 21, 23 } } },
      { { { 1, 2 }, { 18, 20 }, { 11, 12 }, { 13, 15 } },
          { { 3, 4 }, { 17, 19 }, { 9, 10 }, { 14, 16 } } }
  };

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i < 25; i++) {
      cube[i] = Integer.parseInt(st.nextToken());
    }

    // 가로 세로 회전중 어디일지 type 구하기
    // 각 1~4, 9~12 같은 색일 경우 가로 회전
    // 각 13~16, 17~20 같은 색일 경우 세로 회전
    // 각 5~8, 21,24 같은 색일 경우 옆사이드로 회전
    int type = setType();
    if (type != 3 && !(testSetting(rubiks[type][0], rubiks[type][1]) ^ testSetting(rubiks[type][1], rubiks[type][0]))) {
      type = 3;
    }

    System.out.println(type == 3 ? 0 : 1);
  }

  private static boolean testSetting(int[][] x, int[][] y) {
    for (int i = 0; i < 4; i++) {
      if (!(cube[x[i][0]] == cube[x[i][1]]
          & cube[x[i][0]] == cube[y[i + 1 == 4 ? 0 : i + 1][0]]
          & cube[x[i][0]] == cube[y[i + 1 == 4 ? 0 : i + 1][1]])) {
        return false;
      }
    }
    return true;
  }

  private static int setType() {
    int[][] all = { { 1, 9 }, { 13, 17 }, { 5, 21 } };
    int color = 0;
    int type = 3;
    boolean[] setting = { true, true, true };

    for (int i = 0; i < 3; i++) {
      set: for (int j = 0; j < 2; j++) {
        color = cube[all[i][j]];
        for (int k = 0; k < 4; k++) {
          if (color != cube[all[i][j] + k]) {
            setting[i] = false;
            break set;
          }
        }
      }
    }

    // 셋 중 하나만 true 일 때
    if (setting[0] ^ setting[1] ^ setting[2]) {
      type = setting[0] ? 0 : setting[1] ? 1 : 2;
    }

    return type;
  }

}