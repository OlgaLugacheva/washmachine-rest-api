package los.washmachine;


public class Program {
	private int id;
	private String name;
	private String wheels;
	private String temperature;
	private String status;

	public Program() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Program(int id, String name, String wheels, String temperature, String status) {
		this.id = id;
		this.name = name;
		this.wheels = wheels;
		this.temperature = temperature;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWheels() {
		return wheels;
	}

	public void setWheels(String wheels) {
		this.wheels = wheels;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Program program = (Program) o;

		if (id != program.id) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Program "+ name+
				" wheels "+wheels+
				" temperature " + temperature
				;
	}
}
