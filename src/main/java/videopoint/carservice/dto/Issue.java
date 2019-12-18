package videopoint.carservice.dto;

public class Issue {
	private Long id;
	private String brand;
	private String plateNo;
	private String personName;
	private String title;
	private String description;
	private Boolean approved;

	public Issue() {
		super();
		this.approved = Boolean.FALSE;
	}

	public Issue(Long id, String brand, String plateNo, String personName, String title, String description) {
		super();
		this.id = id;
		this.brand = brand;
		this.plateNo = plateNo;
		this.personName = personName;
		this.description = description;
		this.title = title;
		this.approved = Boolean.FALSE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String registerNo) {
		this.plateNo = registerNo;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}


}
