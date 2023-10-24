package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SitesVO;

public class SitesDAO {

	// 사이트 목록

	public void getSitesTotalList() throws Exception {
	    String sql = "select * from reservationsites order by no";
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        con = DBUtil.makeConnection();
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        System.out.println("일련번호\t사이트 구역\t\t사이트 번호\t\t사이트 사이즈");

	        while (rs.next()) {
	            int no = rs.getInt("no");
	            String site_id = rs.getString("site_id");
	            String site_num = rs.getString("site_num");
	            String site_size = rs.getString("site_size");

	            System.out.println(no + "\t" + site_id + "\t" + site_num + "\t\t" + site_size);
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
	}

	// 사이트 등록
	public void setSitesRegiste(SitesVO svo) throws Exception {
		String sql = "insert into reservationsites values(reservationsites_no_seq.nextval, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getSite_id());
			pstmt.setString(2, svo.getSite_num());
			pstmt.setString(3, svo.getSite_size());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(svo.getSite_num() + "사이트 등록 완료.");
			} else {
				System.out.println("사이트 등록에 실패했습니다.");
			}

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
				System.out.println(se);
			}
		}

	}

	// 사이트 수정
	public void setSitesUpdate(SitesVO svo) throws Exception {
		String sql = "update reservationsites set site_id = ?, site_num = ?, site_size = ? where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getSite_id()); // 사이트 아이디
			pstmt.setString(2, svo.getSite_num()); // 사이트 번호
			pstmt.setString(3, svo.getSite_size()); // 사이트 크기
			pstmt.setInt(4, svo.getNo()); // 사이트 일련번호
			
			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("사이트 수정 완료.");
			} else {
				System.out.println("사이트 수정에 실패했습니다.");
			}

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
				System.out.println(se);
			}
		}

	}
	
	// 사이트 삭제
	public void setSitesDelete(int no) throws Exception {
	    String sql = "delete from reservationsites where no = " + no; 

	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBUtil.makeConnection();
	        pstmt = con.prepareStatement(sql);
	        
	        int i = pstmt.executeUpdate();

	        if (i == 1) {
	            System.out.println("사이트 삭제 완료.");
	        } else {
	            System.out.println("사이트 삭제에 실패했습니다.");
	        }
	    } catch (SQLException se) {
	        System.out.println(se);
	    } catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        try {
	            if (con != null)
	                con.close();
	            if (pstmt != null)
	                pstmt.close();
	        } catch (SQLException se) {
	            System.out.println(se);
	        }
	    }
	}


}