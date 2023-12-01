package Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HiringPost
 *
 */
@Entity
@Table(name = "HiringPost")
@NamedQuery(name = "HiringPost.findAll", query = "select p from HiringPost p")

public class HiringPost implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int")
	private int id;
	@Column(columnDefinition = "varchar(255)")
	private String company;
	@Column(columnDefinition = "int")
	private int salary;
	@Column(columnDefinition = "varchar(255)")
	private String position;
	@Column(columnDefinition = "varchar(255)")
	private String location;
	@Column(columnDefinition = "date")
	private Date startDate;
	@Column(columnDefinition = "date")
	private Date endDate;
	@Column(columnDefinition = "varchar(5000)")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HiringPost() {
		super();
	}

	public HiringPost(int id, String company, int salary, String position, String location, Date startDate,
			Date endDate, String description) {
		super();
		this.id = id;
		this.company = company;
		this.salary = salary;
		this.position = position;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}
}
