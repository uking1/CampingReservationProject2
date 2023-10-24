package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.InfoVO;

public class InfoDAO {

	// 예약자 등록
	public void setInfoRegiste(InfoVO ivo) throws Exception {
		String sql = "insert into reservationinfo values(reservationinfo_no_seq.nextval,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ivo.getReservation_id());
			pstmt.setString(2, ivo.getReservation_pw());
			pstmt.setString(3, ivo.getName());
			pstmt.setString(4, ivo.getPhone());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(ivo.getName() + "님 예약자 등록 완료.");
			} else {
				System.out.println("예약자 등록에 실패했습니다. 다시 입력해주세요.");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void setInfoUpdate(InfoVO ivo) throws Exception {
		String sql = "update reservationinfo set reservation_pw=?, phone=? where reservation_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ivo.getReservation_pw());
			pstmt.setString(2, ivo.getPhone());
			pstmt.setString(3, ivo.getReservation_id());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(ivo.getName() + "님 정보가 수정되었습니다.");
			} else {
				System.out.println(ivo.getName() + "님 정보 수정에 실패했습니다.");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// 예약자 아이디 중복 체크
	public boolean getInfoIdOverlap(String idOverlap) throws Exception {
		String sql = "select * from reservationinfo where reservation_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idOverlap);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true; // 중복된 아이디가 존재
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

	// 예약자 로그인
	public boolean getInfoLogin(String id, String pw) throws Exception {
		String sql = "select * from reservationinfo where reservation_id = ? and reservation_pw = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean login = false;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				login = true; // 로그인 성공
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return login;
	}

	// 예약자 정보
	public InfoVO getInfo(String id, String pw) throws Exception {
		String sql = "select * from reservationinfo where reservation_id = ? and reservation_pw = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		InfoVO ivo = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			System.out.println("일련번호\t예약자ID\t\t예약자PW\t\t성함\t 연락처");

			if (rs.next()) {
				ivo = new InfoVO();
				ivo.setNo(rs.getInt("no"));
				ivo.setReservation_id(rs.getString("reservation_id"));
				ivo.setReservation_pw(rs.getString("reservation_pw"));
				ivo.setName(rs.getString("name"));
				ivo.setPhone(rs.getString("phone"));

				System.out.println(ivo.getNo() + "\t" + ivo.getReservation_id() + "\t\t" + ivo.getReservation_pw()
						+ "\t\t" + ivo.getName() + "\t" + ivo.getPhone());
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return ivo;
	}

	// 예약자 전체 목록
	public void getInfoTotalList() throws Exception {
		String sql = "select * from reservationinfo";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 결과 출력
			System.out.println("일련번호\t예약자ID\t\t예약자PW\t\t성함\t 연락처");

			while (rs.next()) {
				InfoVO ivo = new InfoVO();
				ivo.setNo(rs.getInt("no"));
				ivo.setReservation_id(rs.getString("reservation_id"));
				ivo.setReservation_pw(rs.getString("reservation_pw"));
				ivo.setName(rs.getString("name"));
				ivo.setPhone(rs.getString("phone"));

				System.out.println(ivo.getNo() + "\t" + ivo.getReservation_id() + "\t\t" + ivo.getReservation_pw()
						+ "\t\t" + ivo.getName() + "\t" + ivo.getPhone());
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// 예약자 찾기
	public String getInfoName(String id, String pw) throws Exception {

		String sql = "select name from reservationinfo where reservation_id= ? and reservation_pw = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = "";
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
			}

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se);
			}
		}
		return name;
	}

}