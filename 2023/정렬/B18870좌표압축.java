import java.io.*;
import java.util.*;

/* 
 * 정렬된 배열에서 값 위치 찾기
 * Arrays.binarySearch(numbers,i) -> numbers : 정렬된 배열, i : 찾을 값
 * 찾는 값이 존재하면 최초의 인덴스 값을 리턴
 * 찾는 값이 존재하지 않으면 (i보다 큰 최초의 인덴스(index)*-1)-1 값 리턴 
 */

public class B18870좌표압축 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      list.add(num);
      set.add(num);
    }
    int[] numbers = new int[set.size()];
    int idx = 0;
    for (int i : set) {
      numbers[idx++] = i;
    }
    Arrays.sort(numbers);

    for (int i : list) {
      int j = Arrays.binarySearch(numbers, i);
      sb.append(j + " ");
    }

    System.out.print(sb);
  }
}