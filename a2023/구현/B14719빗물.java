import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719빗물 {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());

    int[] block = new int[W];
    int[] wall = new int[W];
    int maxHeight = 0;

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < W; i++) {
      block[i] = Integer.parseInt(st.nextToken());
      if (block[i] > maxHeight)
        maxHeight = block[i];
      wall[i] = maxHeight;
    }

    maxHeight = 0;
    for (int i = W - 1; i >= 0; i--) {
      if (block[i] > maxHeight)
        maxHeight = block[i];
      wall[i] = Math.min(wall[i], maxHeight);
    }

    int result = 0;
    for (int i = 0; i < W; i++) {
      result += (wall[i] - block[i]);
    }
    System.out.println(result);
  }
}
