// 1. Define class
// 2. define instance variable and then modify according to use 
// 3. Define private Constructor
// 4. create static method getInstance


class DesignPatternSingleton {
	private static volatile DesignPatternSingleton instance;
	private DesignPatternSingleton(){};
	
	public static DesignPatternSingleton getInstance(){
		if(instance == null){
		synchronized(DesignPatternSingleton.class){
			if(instance == null){
				System.out.println("Creating Instance... ");
			    instance = new DesignPatternSingleton();
			} else {
				System.out.println("Instance has already in use.");
			}
		}		
	}
	System.out.println("Got instance..");
	
	return instance;
	}
	
	public void showMessage() {
        System.out.println("Singleton Instance: " + this.hashCode());
    }
}

class SingletonRunnable implements Runnable{
	
	@Override
	public void run() {
		DesignPatternSingleton dPS = DesignPatternSingleton.getInstance();
		dPS.showMessage();
	}
}

public class Main{
    public static void main(String[] args){
				        
		Thread thread1 = new Thread(new SingletonRunnable());
		Thread thread2 = new Thread(new SingletonRunnable());
		thread1.start();
		thread2.start();
		DesignPatternSingleton dPS2 = DesignPatternSingleton.getInstance();
		dPS2.showMessage();
	}
}