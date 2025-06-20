class Car{
	
	public int engine;
	public int seater;
	public String modal;
	
	private Car(CarBuilder carBuilder){
		this.engine = carBuilder.engine;
		this.seater = carBuilder.seater;
		this.modal = carBuilder.modal;
	}
	
	
	public static CarBuilder builder(){
		return new CarBuilder();
	}
	
	static class CarBuilder {
		
		private int engine;
	    private int seater;
	    private String modal;
		
		public void engine(int engine) {
			this.engine = engine;
			return;
		}
		
		public CarBuilder seater(int seater) {
			this.seater = seater;
			return this;
		}
		
		public CarBuilder modal(String modal) {
			this.modal = modal;
			return this;
		}
		
		public Car build() {
			return new Car(this);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Car car1 = Car.builder()
		          .engine(1300)
//				  .seater(4)
//				  .modal("Maruti Etriga 2022")
				  .build();
				  
//		Car.CarBuilder car2 = Car.builder();
//		          .engine(1300)
//				  .seater(4)
//				  .modal("Maruti Etriga 2022")
//				  .build();
				  
		System.out.println("Engine: "+ car1.engine);
		System.out.println("Seater: "+ car1.seater);
		System.out.println("Modal: "+ car1.modal);
//		System.out.println("car1 base address: "+System.identityHashCode(car1));
		System.out.println("\n");
//	    System.out.println("Engine: "+ car1.engine);
//		System.out.println("Seater: "+ car1.seater);
//		System.out.println("Modal: "+ car1.modal);
//		System.out.println("car2 base address: "+System.identityHashCode(car2));
	}
}