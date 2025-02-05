import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P11650_좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        // 배열에 넣기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2차원 배열 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                // 첫번째 원소가 같다면 두번째 원소끼리 비교(오름차순)
                if (e1[0] == e2[0]) {
                    return e1[1] - e2[1];
                // 첫번째 원소가 다르다면 첫번째 원소끼리 비교(오름차순)
                } else {
                    return e1[0] - e2[0];
                }
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);



    }
}