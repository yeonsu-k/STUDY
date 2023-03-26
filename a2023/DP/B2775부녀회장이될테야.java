import java.io.*;

public class B2775부녀회장이될테야 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int[][] APT = new int[15][15]; // 1~14호
    for (int i = 0; i < 15; i++) {
      APT[i][1] = 1; // i층 1호
      APT[0][i] = i; // 0층 i호
    }

    for (int i = 1; i < 15; i++) {
      for (int j = 2; j < 15; j++) {
        APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
      }
    }

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      sb.append(APT[k][n]).append('\n');
    }
    System.out.print(sb);
  }
}