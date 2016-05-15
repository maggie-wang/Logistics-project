package prjX.entities;

import java.io.Serializable;

public class ShipDAO implements Serializable {
	private int id;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getVolumeType() {
		return volumeType;
	}
	public void setVolumeType(String volumeType) {
		this.volumeType = volumeType;
	}
	private String name;
    private String company;
    private String volumeType;

    public ShipDAO(int id, String name, String company, String volumeType) {
        super();
        this.id = id;
        this.name = name;
        this.company = company;
        this.volumeType = volumeType;
    }
    public ShipDAO() {
        super();
    }
}