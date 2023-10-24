package model;

import java.util.Objects;

public class SitesVO {
	private int no; // 사이트 일련번호
	private String site_id; // 사이트 아이디
	private String site_num; // 사이트 번호
	private String site_size; // 사이트 크기

	public SitesVO() {
		super();
	}

	public SitesVO(int no, String site_id, String site_num, String site_size) {
		super();
		this.no = no;
		this.site_id = site_id;
		this.site_num = site_num;
		this.site_size = site_size;
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

	public String getSite_size() {
		return site_size;
	}

	public void setSite_size(String site_size) {
		this.site_size = site_size;
	}

	@Override
	public int hashCode() {

		return Objects.hash(no, site_id, site_num);
	}

	@Override
	public boolean equals(Object obj) {
		SitesVO svo = (SitesVO) obj;
		if (!(obj instanceof SitesVO))
			return false;
		return svo.no == this.no && svo.site_id.equals(this.site_id) && svo.site_num.equals(this.site_num);
	}

}