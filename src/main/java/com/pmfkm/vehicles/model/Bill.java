package com.pmfkm.vehicles.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the BILL database table.
 * 
 */
@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="BILL_NUM")
	private double billNum;

	@Column(name="IMG_PATH")
	private String imgPath;

	@Column(name="\"SUM\"")
	private double sum;

	//bi-directional many-to-one association to TravelOrder
	@ManyToOne
	@JoinColumn(name="TRAVEL_ORDER_ID")
	private TravelOrder travelOrder;

	public Bill() {
	}
	
	public Bill(int id, int billNum, String imgPath, double sum, TravelOrder travelOrder) {
		this.id = id;
		this.billNum = billNum;
		this.imgPath = imgPath;
		this.sum = sum;
		this.travelOrder = travelOrder;
	}

	public Bill(int billNum, String imgPath, double sum, TravelOrder travelOrder) {
		this.billNum = billNum;
		this.imgPath = imgPath;
		this.sum = sum;
		this.travelOrder = travelOrder;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBillNum() {
		return this.billNum;
	}

	public void setBillNum(double billNum) {
		this.billNum = billNum;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public double getSum() {
		return this.sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public TravelOrder getTravelOrder() {
		return this.travelOrder;
	}

	public void setTravelOrder(TravelOrder travelOrder) {
		this.travelOrder = travelOrder;
	}

}