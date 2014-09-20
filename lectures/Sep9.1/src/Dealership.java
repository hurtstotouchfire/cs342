
public class Dealership {

	private final int MAX_CARS = 100;
	private Car [] inventory = new Car[MAX_CARS];
	private int numCars = 0;
	
	public Dealership() {
		//for (int i = 0; i < MAX_CARS; i++) {
			//System.out.print(inventory[i]);
		//}
	}
	
	public boolean addCar(Car c) {
		if (numCars == MAX_CARS) {
			return false;
		}
		inventory[numCars++] = c;
		return true;
	}
	
	public String toString() {
		String rtn = "";
		
		rtn += "Number of Cars = " + numCars;
		
		return rtn;
	}
	
	public int getNumCars() {
		return numCars;
	}
	
	public Car getCar(int carNum) {
		// normalize to 1 indexed data
		if ((carNum > numCars) || (carNum < 1))  {
			return null;
		}
		
		//Car rtn = (Car) inventory[carNum-1].clone();
		Car rtn = inventory[carNum-1];
		return rtn;
	}
	
	
}
