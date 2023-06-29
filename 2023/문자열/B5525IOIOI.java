import java.io.*;

public class B5525IOIOI {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    char str[] = br.readLine().toCharArray();

    int cnt = 0, res = 0;
    for (int i = 0; i < M - 2; i++) {
      if (str[i] == 'I' && str[i + 1] == 'O' && str[i + 2] == 'I') {
        cnt++;
        i++; // 다음 'I' 위치에서 탐색
      } else
        cnt = 0; // 겹쳐지 않을 경우
      if (cnt >= N)
        res++;
    }

    System.out.print(res);
  }
}
