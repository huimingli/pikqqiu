package com.celt.estation.template.bean;

import java.util.List;

public class FreeApply{
	private String id;
	private String name;
	private String number;
	private String price;
	private String apply_start_time;
	private String apply_end_time;
	private int point;
	private List<String> img_url;
	private String detail_url;
	private int status;
	private String apply_num;
	private String share_link;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getApply_start_time() {
		return apply_start_time;
	}

	public void setApply_start_time(String apply_start_time) {
		this.apply_start_time = apply_start_time;
	}

	public String getApply_end_time() {
		return apply_end_time;
	}

	public void setApply_end_time(String apply_end_time) {
		this.apply_end_time = apply_end_time;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public List<String> getImg_url() {
		return img_url;
	}

	public void setImg_url(List<String> img_url) {
		this.img_url = img_url;
	}

	public String getDetail_url() {
		return detail_url;
	}

	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getApply_num() {
		return apply_num;
	}

	public void setApply_num(String apply_num) {
		this.apply_num = apply_num;
	}

	public String getShare_link() {
		return share_link;
	}

	public void setShare_link(String share_link) {
		this.share_link = share_link;
	}
}
