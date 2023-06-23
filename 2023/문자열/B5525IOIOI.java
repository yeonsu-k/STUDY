import java.io.*;

public class B5525IOIOI {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    char str[] = br.readLine().toCharArray();
    int result = 0;
    int count = 0;

    for (int i = 0; i < M - 2; i++) {
      if (str[i] == 'I' && str[i + 1] == 'O' && str[i + 2] == 'I') {
        count++;
        i++; // 다음 'O' 위치에서 탐색
        if (count == N) {
          count--; // 겹쳐지는 부분 IOIOI => IOI 2개
          result++;
        }
      } else { // 겹쳐지 않을 경우
        count = 0;
      }
    }

    System.out.print(result);
  }
}
