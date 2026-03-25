package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

	@Id
	@Column(name = "SSN")
	private Integer ssn;

	@Column(name = "Name", length = 30)
	private String name;

	@Column(name = "Address", length = 30)
	private String address;

	@Column(name = "Phone", length = 30)
	private String phone;
	@Column(name = "InsuranceID")
	private Integer insuranceId;

	// PCP = Primary Care Physician
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PCP", referencedColumnName = "EmployeeID")
	private Physician pcp;

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Physician getPcp() {
		return pcp;
	}

	public void setPcp(Physician pcp) {
		this.pcp = pcp;
	}

}
