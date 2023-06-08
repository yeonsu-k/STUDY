import java.io.*;
import java.util.*;

public class B1620나는야포켓몬마스터이다솜 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    String[] arr = new String[N + 1];
    for (int i = 1; i <= N; i++) {
      String name = br.readLine();
      map.put(name, i);
      arr[i] = name;
    }

    for (int i = 0; i < M; i++) {
      String str = br.readLine();
      if (str.charAt(0) <= '9')
        sb.append(arr[Integer.parseInt(str)]);
      else
        sb.append(map.get(str));

      sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}