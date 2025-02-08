import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;

		// 가로, 세로 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		// 상점 개수, 상점 좌표 입력
		int storeCount = Integer.parseInt(br.readLine());
		int[] store = new int[storeCount];

		for (int i = 0; i < storeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			// 배열에 저장
			store[i] = switchCoordinate(width, length, direction, distance);
		}

		// 동근이 좌표 입력
		st = new StringTokenizer(br.readLine());
		int direction = Integer.parseInt(st.nextToken());
		int distance = Integer.parseInt(st.nextToken());
		int switchDistance = switchCoordinate(width, length, direction, distance);

		// 최단 거리의 합
		for (int i : store) {
			int reverseClock = Math.abs(switchDistance - i);
			int Clock = (width * 2 + length * 2) - reverseClock;
			int min = Math.min(reverseClock, Clock);
			result += min;
		}

		System.out.println(result);

	}

	// 좌표 변환
	public static int switchCoordinate(int width, int length, int direction, int distance) {
		int switchDistance = 0;
		switch (direction) {
		case 1:
			switchDistance = length * 2 + width + (width - distance);
			break;
		case 2:
			switchDistance = length + distance;
			break;
		case 3:
			switchDistance = distance;
			break;
		case 4:
			switchDistance = length + width + (length - distance);
			break;
		}
		return switchDistance;
	}

}
