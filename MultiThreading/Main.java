class Main{
	public static void main(String args[]) throws InterruptedException {
		
		MyThread th = new MyThread();
		th.start();
		th.sleep(10000);
		for(int i = 0;i < 5; i++) {
			System.out.println("Main Thread");
		}
	}
}

class MyThread extends Thread{
	
	public void run() {
		
		System.out.println("Child Thread");
	}
}
