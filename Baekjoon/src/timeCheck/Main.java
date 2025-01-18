package timeCheck;

public class Main {

	public static void main(String[] args) {

		// 시작 시간
		long timeStart = System.nanoTime() / 1000000;

		// 종료 시간
		long timeEnd = System.nanoTime() / 1000000;
		System.out.println("ArrayList 걸린 시간 : " + (timeEnd - timeStart) + "ms");
	}

}
