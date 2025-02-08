import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2578_빙고 {

	static int[][] board = new int[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 빙고판
		int count = 0;
		// 빙고판 입력
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자가 부르는 수 입력
		Loop1: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				count++;
				// 사회자가 부르는 수는 0으로 표시
				markZero(num);
				// 0으로 마킹 후에 3빙고인지 판단
				boolean bingo = isBingo();
				// 3빙고가 맞다면 반복문 종료
				if (bingo == true) {
					break Loop1;
				}
			}
		}

		System.out.println(count);

	}

	// 사회자가 부르는 수를 빙고판에서 0으로 표시하는 메소드
	public static void markZero(int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == n)
					board[i][j] = 0;
			}
		}
	}

	// 3빙고인지 판단해주는 메소드
	public static boolean isBingo() {
		boolean result = false;
		int bingoCount = 0;
		// 가로
		for (int i = 0; i < 5; i++) {
			int zeroCount = 0;
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == 0)
					zeroCount++;
			}
			if (zeroCount == 5)
				bingoCount++;
		}

		// 세로
		for (int i = 0; i < 5; i++) {
			int zeroCount = 0;
			for (int j = 0; j < 5; j++) {
				if (board[j][i] == 0)
					zeroCount++;
			}
			if (zeroCount == 5)
				bingoCount++;
		}

		// 대각선 \
		int zeroCount = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][i] == 0)
				zeroCount++;
		}
		if (zeroCount == 5)
			bingoCount++;

		// 대각선 /
		zeroCount = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][4 - i] == 0)
				zeroCount++;
		}
		if (zeroCount == 5)
			bingoCount++;

		// 빙고가 3개라면 true
		if (bingoCount >= 3)
			result = true;

		return result;
	}

}
