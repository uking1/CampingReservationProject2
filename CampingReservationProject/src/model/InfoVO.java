package model;

import java.util.Objects;

public class InfoVO {
	private int no; // 예약자 일련번호
	private String reservation_id; // 예약자 아이디
	private String reservation_pw; // 예약자 비밀번호
	private String name; // 예약자 성함
	private String phone; // 예약자 연락처

	public InfoVO() {

	}

	public InfoVO(int no, String reservation_id, String reservation_pw, String name, String phone) {
		super();
		this.no = no;
		this.reservation_id = reservation_id;
		this.reservation_pw = reservation_pw;
		this.name = name;
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getReservation_pw() {
		return reservation_pw;
	}

	public void setReservation_pw(String reservation_pw) {
		this.reservation_pw = reservation_pw;
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
		return Objects.hash(no, phone, reservation_id);
	}

	@Override
	public boolean equals(Object obj) {
		InfoVO ivo = (InfoVO) obj;
		if (!(obj instanceof InfoVO))
			return false;
		return ivo.no == this.no && ivo.phone.equals(this.phone) && ivo.reservation_id.equals(this.reservation_id);
	}

}