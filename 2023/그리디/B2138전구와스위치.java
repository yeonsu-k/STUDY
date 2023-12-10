import java.io.*;

public class B2138전구와스위치 {
  static int N;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[] now = br.readLine().toCharArray();
    char[] want = br.readLine().toCharArray();

    boolean[] makeArr_1 = new boolean[N]; // 0번 스위치 on
    boolean[] makeArr_2 = new boolean[N]; // 0번 스위치 off
    boolean[] wantArr = new boolean[N];

    for (int i = 0; i < N; i++) {
      makeArr_1[i] = now[i] == '0';
      makeArr_2[i] = makeArr_1[i];
      wantArr[i] = want[i] == '0';
    }

    makeArr_1 = change(makeArr_1, 0);
    int cnt_1 = 1, cnt_2 = 0;
    for (int i = 1; i < N; i++) {
      if (makeArr_1[i - 1] != wantArr[i - 1]) {
        change(makeArr_1, i);
        cnt_1++;
      }
      if (makeArr_2[i - 1] != wantArr[i - 1]) {
        change(makeArr_2, i);
        cnt_2++;
      }
    }

    int result = Integer.MAX_VALUE;
    if (makeArr_1[N - 1] == wantArr[N - 1]) {
      result = Math.min(result, cnt_1);
    }
    if (makeArr_2[N - 1] == wantArr[N - 1]) {
      result = Math.min(result, cnt_2);
    }

    System.out.print(result == Integer.MAX_VALUE ? -1 : result);
  }

  private static boolean[] change(boolean[] arr, int idx) {
    for (int i = idx - 1; i <= idx + 1; i++) {
      if (i >= 0 && i < N) {
        arr[i] = !arr[i];
      }
    }

    return arr;
  }
}