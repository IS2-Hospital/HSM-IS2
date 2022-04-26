
package model;

public class Treatment {

	private int id;
	private String name;
	private String description;
	private String startDate;
	private String endDate;

	public Treatment(int id, String name, String description, String startDate, String endDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setId(int id) {
		this.id = id;
	}

}
