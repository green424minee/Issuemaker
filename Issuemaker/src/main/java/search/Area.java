package search;

public class Area {
	private String areaName;

	public Area(String areaName) {
		super();
		this.areaName = areaName;
	}
	
	public Area() {}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "Area [areaName=" + areaName + "]";
	}
}
