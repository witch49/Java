package sec04;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	// 계산기 메모리에 값을 저장하는 메소드
	/* 1 */
//	public synchronized void setMemory(int memory) {
//		this.memory = memory;
//		try {
//			Thread.sleep(2000); // thread 2초간 정지
//		} catch (Exception e) {
//
//		}
//		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
//	}

	/* 2 */
	public void setMemory(int memory) {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			this.memory = memory;
			try {
				Thread.sleep(2000); // thread 2초간 정지
			} catch (Exception e) {

			}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);
		}
	}

}
