package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReservationVO;

public class ReservationDAO {
	// 예약 신청
	public void setReservationRegiste(ReservationVO rvo) throws Exception {
		String sql = "INSERT INTO reservation (no, site_id, site_num, name, phone, reservation_date) VALUES (reservation_no_seq.nextval, ?, ?, ?, ?, ?)";

	    try (Connection con = DBUtil.makeConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setString(1, rvo.getSite_id());
	        pstmt.setString(2, rvo.getSite_num());
	        pstmt.setString(3, rvo.getName());
	        pstmt.setString(4, rvo.getPhone());
	        pstmt.setString(5, rvo.getDate());

	        int i = pstmt.executeUpdate();

	        if (i == 1) {
	            System.out.println("예약 완료되었습니다.");
	        } else {
	            System.out.println("예약에 실패했습니다.");
	        }
	    } catch (SQLException se) {
	        throw new Exception("예약 신청 중 오류 발생", se);
	    }
	}


	// 예약 취소
	public void setReservationDelete(int no) throws Exception {
		String sql = "delete from reservation where no = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("예약 취소되었습니다.");
			} else {
				System.out.println("예약 취소에 실패했습니다.");
			}

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException se) {
				System.out.println(se);
			}
		}
	}

	// 예약자 신청 목록
	public List<ReservationVO> getReservationTotalList(String id, String pw) throws Exception {
	    String sql = "SELECT r.no, r.site_id, r.site_num, r.name, r.phone, r.reservation_date FROM reservation r " +
	                 "INNER JOIN reservationinfo i ON r.name = i.name AND i.reservation_id = ? AND i.reservation_pw = ?";

	    List<ReservationVO> reservationList = new ArrayList<>();

	    try (Connection con = DBUtil.makeConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setString(1, id); 
	        pstmt.setString(2, pw); 
	        try (ResultSet rs = pstmt.executeQuery()) {
	            System.out.println("일련번호\t사이트 구역\t\t사이트 번호\t\t성함\t\t연락처\t\t예약일자");
	            while (rs.next()) {
	                ReservationVO rvo = new ReservationVO();
	                rvo.setNo(rs.getInt("no"));
	                rvo.setSite_id(rs.getString("site_id"));
	                rvo.setSite_num(rs.getString("site_num"));
	                rvo.setName(rs.getString("name"));
	                rvo.setPhone(rs.getString("phone"));
	                rvo.setDate(rs.getString("reservation_date"));

	                reservationList.add(rvo);

	                System.out.println(rvo.getNo() + "\t" + rvo.getSite_id() + "\t" + rvo.getSite_num() + "\t\t"
	                        + rvo.getName() + "\t\t" + rvo.getPhone() + "\t" + rvo.getDate().split(" ")[0]);
	            }
	        }
	    } catch (SQLException se) {
	        throw new Exception("예약자 신청 목록 조회 중 오류 발생", se);
	    }
	    
	    return reservationList;
	}



}
