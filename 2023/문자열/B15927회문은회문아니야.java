import java.io.*;

/*
 * 회문일 때
 *    - 모두 같은 문자일 경우 : -1
 *    - 다른 문자일 경우 : (전체 길이 - 1)
 * 회문이 아닐 때 : 전체 길이
 */

public class B15927회문은회문아니야 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] word = br.readLine().toCharArray();
    boolean check = false;
    for (int i = 0; i < word.length / 2; i++) {
      if (word[i] != word[word.length - 1 - i]) { // 회문이 아니면
        System.out.print(word.length);
        return;
      } else if (word[0] != word[i + 1]) { // 회문일 때
        check = true; // 다른 문자 일 때
      }
    }

    if (check)
      System.out.print(word.length - 1);
    else
      System.out.print(-1);
  }
}
