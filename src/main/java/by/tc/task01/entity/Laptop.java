package by.tc.task01.entity;

public class Laptop extends Appliance {
	private double batteryCapacity;
	private String os;
	private int memoryROM;
	private int systemMemory;
	private double cpu;
	private int displayInchs;

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public int getMemoryROM() {
		return memoryROM;
	}

	public void setMemoryROM(int memoryROM) {
		this.memoryROM = memoryROM;
	}

	public int getSystemMemory() {
		return systemMemory;
	}

	public void setSystemMemory(int systemMemory) {
		this.systemMemory = systemMemory;
	}

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	public int getDisplayInchs() {
		return displayInchs;
	}

	public void setDisplayInchs(int displayInchs) {
		this.displayInchs = displayInchs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		Laptop that = (Laptop) o;
		if (getBatteryCapacity() != that.getBatteryCapacity()) {
			return false;
		}
		if (getCpu() != that.getCpu()) {
			return false;
		}
		if (getDisplayInchs() != that.getDisplayInchs()) {
			return false;
		}
		if (getMemoryROM() != that.getMemoryROM()) {
			return false;
		}
		if (getOs() == null) {
			if (that.getOs() != null) {
				return false;
			}
		} else if (!getOs().equals(that.getOs())) {
			return false;
		}
		return getSystemMemory() == that.getSystemMemory();
	}

	@Override
	public int hashCode() {
		int result = getDisplayInchs();
		result = 31 * result + Double.hashCode(getBatteryCapacity());
		result = 31 * result + Double.hashCode(getCpu());
		result = 31 * result + getDisplayInchs();
		result = 31 * result + getMemoryROM();
		result = 31 * result + (getOs() == null ? 0 : getOs().hashCode());
		return result;
	}
}
