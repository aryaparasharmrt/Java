class Car{
	
	private int engine;
	private int seater;
	private String modal;
	
	private Car(CarBuilder carBuilder){
		this.engine = carBuilder.engine;
		this.seater = carBuilder.seater;
		this.modal = carBuilder.modal;
	}
	
	public static Car builder(){
		return new CarBuilder();
	}
	
	static class CarBuilder {
		
		private int engine;
	    private int seater;
	    private String modal;
		
		public CarBuilder engine(int engine) {
			this.engine = engine
			return this;
		}
		
		public CarBuilder seater(int seater) {
			this.seater = seater
			return this;
		}
		
		public CarBuilder modal(int modal) {
			this.modal = modal
			return this;
		}
		
		public Car build() {
			return new Car(this);
		}
	}
}

public class Main{
	public static void main(String[] args) {
		Car car = Car.builder()
		          .engine(1300)
				  .seater(4)
				  .modal("Maruti Etriga 2022")
				  .build();
				  
		System.out.println("Engine: "+car.engine);
		System.out.println("Seater: "+car.seater);
		System.out.println("Modal: "+car.modal);
	}
}