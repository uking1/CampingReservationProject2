package model;

import java.util.Objects;

public class ReservationVO {
	private int no; // 예약 일련번호
	private String site_id; // 사이트 아이디
	private String site_num; // 사이트 번호
	private String name; // 예약자 성함
	private String phone; // 예약자 연락처
	private String date; // 예약일자

	public ReservationVO() {

	}

	public ReservationVO(int no, String site_id, String site_num, String name, String phone, String date) {
	    super();
	    this.no = no;
	    this.site_id = site_id;
	    this.site_num = site_num;
	    this.name = name;
	    this.phone = phone;
	    this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public String getSite_num() {
		return site_num;
	}

	public void setSite_num(String site_num) {
		this.site_num = site_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, no);
	}

	@Override
	public boolean equals(Object obj) {
		ReservationVO rvo = (ReservationVO) obj;
		if (!(obj instanceof ReservationVO))
			return false;
		return rvo.no == this.no && rvo.name.equals(name);
	}

}