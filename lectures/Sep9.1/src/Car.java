
public class Car implements Cloneable {

	private int year;
	private String color;
	private int doors;
	private boolean isHatchback;
	private double engineSize;  // in Liters
	private boolean isTurbo;
	private int seats;
	private String manufacturer;
	private String model;
	private boolean isAutomatic;
	
	@Override
	public String toString() {
		return "Car [year=" + year + ", color=" + color + ", doors=" + doors
				+ ", isHatchback=" + isHatchback + ", engineSize=" + engineSize
				+ ", isTurbo=" + isTurbo + ", seats=" + seats
				+ ", manufacturer=" + manufacturer + ", Model=" + model
				+ ", isAutomatic=" + isAutomatic + "]";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if (year < 1897) {
			this.year = 1897;
		} else {
			this.year = year;
		}
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		if (doors < 0) {
			this.doors = 0;
		} else {
			this.doors = doors;
		}
	}
	public boolean isHatchback() {
		return isHatchback;
	}
	public void setHatchback(boolean isHatchback) {
		this.isHatchback = isHatchback;
	}
	public double getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(double engineSize) {
		if (engineSize < 0) {
			this.engineSize = 0;
		} else {
			this.engineSize = engineSize;
		}
	}
	public boolean isTurbo() {
		return isTurbo;
	}
	public void setTurbo(boolean isTurbo) {
		this.isTurbo = isTurbo;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		if (seats < 1) {
			this.seats = 1;
		} else {
			this.seats = seats;
		}
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isAutomatic() {
		return isAutomatic;
	}
	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}
	
	public Object clone() {
		Car rtn = new Car();
		rtn.color = this.color;
		rtn.doors = this.doors;
		rtn.engineSize = this.engineSize;
		rtn.isAutomatic = this.isAutomatic;
		rtn.isHatchback = this.isHatchback;
		rtn.isTurbo = this.isTurbo;
		rtn.manufacturer = this.getManufacturer();
		rtn.model = this.model;
		rtn.seats = this.seats;
		rtn.year = this.year;
		
		return rtn;
	}
}
