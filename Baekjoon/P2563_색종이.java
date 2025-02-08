import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2563_색종이 {

	static int[][] whitePaper = new int[100][100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int area = 0;
		StringTokenizer st;
		// 색종이의 수
		int N = Integer.parseInt(br.readLine());

		// 색종이를 붙인 위치
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 해당하는 위치에 10x10 색종이를 붙임 (1로 표시)
			for (int row = x; row < x + 10; row++) {
				for (int col = y; col < y + 10; col++) {
					whitePaper[row][col] = 1;
				}
			}
		}

		// 색종이의 영역 출력
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (whitePaper[i][j] == 1)
					area++;
			}
		}

		System.out.println(area);

	}

}
