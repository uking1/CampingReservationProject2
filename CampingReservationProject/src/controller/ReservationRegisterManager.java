package controller;

import java.util.List;
import java.util.Scanner;

import model.InfoVO;
import model.ReservationVO;
import model.SitesVO;

public class ReservationRegisterManager {
	public static Scanner scan = new Scanner(System.in);

	// 예약 신청 리스트
	public void reservationList() throws Exception {
		String name; // 이름
		String id; // 아이디
		String pw; // 비밀번호
		String mainMenu; // 메인메뉴

		boolean flag = false;

		ReservationDAO rd = new ReservationDAO();
		InfoDAO ido = new InfoDAO();
		SitesDAO sd = new SitesDAO();

		System.out.println("예약 확인을 위한 ID와 PW를 입력해주세요.");
		do {
			System.out.print("예약자 아이디 : ");
			id = scan.nextLine();
			System.out.print("예약자 비밀번호 : ");
			pw = scan.nextLine();
			flag = ido.getInfoLogin(id, pw);

			if (!flag) {
				System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력해주세요");
			} else {
				name = ido.getInfoName(id, pw);
				System.out.println();

				System.out
						.println("==================================================================================");
				System.out.println("\t\t\t\t내 예약 현황");
				System.out.println("==================================================================================");
				List<ReservationVO> reservationList = rd.getReservationTotalList(id, pw);
				System.out
						.println("==================================================================================");

			}

			System.out.print("메인 메뉴로 이동(Y) : ");
			mainMenu = scan.next();
			if (mainMenu.equalsIgnoreCase("y")) {
				return;
			}
			System.out.println();
		} while (!flag);
	}

	// 예약 신청 관리
	public void reservationRegister() throws Exception {
		ReservationDAO rd = new ReservationDAO();
		ReservationVO rv = new ReservationVO();

		SitesDAO sd = new SitesDAO();
		SitesVO sv = new SitesVO();

		InfoDAO ido = new InfoDAO();
		InfoVO iv = new InfoVO();

		String site_id; // 사이트 구역
		String site_num; // 사이트 번호
		String name; // 이름
		String id; // 아이디
		String pw; // 비밀번호
		String phone; // 연락처
		String date; // 예약날짜

		boolean flag = false;

		Scanner scan = new Scanner(System.in);

		System.out.println("예약 가능한 사이트 목록");
		sd.getSitesTotalList();
		System.out.println();

		System.out.println("예약 신청을 위한 정보 입력");

		do {
			System.out.print("예약자 아이디 : ");
			id = scan.nextLine();
			System.out.print("예약자 비밀번호 : ");
			pw = scan.nextLine();

			flag = ido.getInfoLogin(id, pw);

			if (!flag) {
				System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력해주세요.");
			}
		} while (!flag);

		name = ido.getInfoName(id, pw);

		System.out.println("성함 : " + name);
		System.out.println("");
		System.out.print("사이트 구역 : ");
		site_id = scan.nextLine();
		System.out.print("사이트 번호 : ");
		site_num = scan.nextLine();
		System.out.print("연락처 : ");
		phone = scan.nextLine();
		System.out.print("예약 희망일 (YYYY/MM/DD) : ");
		date = scan.nextLine();

		rv.setName(name);
		rv.setSite_id(site_id);
		rv.setSite_num(site_num);
		rv.setPhone(phone);
		rv.setDate(date);

		// 예약 신청 등록
		rd.setReservationRegiste(rv);

		System.out.println();
		System.out.println("==================================================================================");
		System.out.println("\t\t\t\t예약 신청 현황");
		System.out.println("==================================================================================");
		rd.getReservationTotalList(id, pw);
		System.out.println("==================================================================================");
		System.out.println();
	}

	// 예약 취소관리
	public void reservationDelete() throws Exception {

		InfoDAO ido = new InfoDAO();
		ReservationDAO rd = new ReservationDAO();

		String site_num; // 사이트 번호
		int no; // 예약번호
		String name;
		String id; // 아이디
		String pw; // 비밀번호
		String mainMenu; // 메인메뉴

		boolean flag = false;

		System.out.println("예약 취소를 위한 정보 입력");
		do {
			System.out.print("예약자 아이디 : ");
			id = scan.nextLine();
			System.out.print("예약자 비밀번호 : ");
			pw = scan.nextLine();

			flag = ido.getInfoLogin(id, pw);

			if (!flag) {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 입력해주세요.");

				System.out.print("메인 메뉴로 이동(Y) : ");
				mainMenu = scan.next();
				if (mainMenu.equalsIgnoreCase("Y")) {
					return;
				}
				System.out.println();
			}

		} while (!flag);

		name = ido.getInfoName(id, pw);

		System.out.println();
		System.out.println("==================================================================================");
		System.out.println("\t\t\t\t예약 신청 목록");
		System.out.println("==================================================================================");
		rd.getReservationTotalList(id, pw);
		System.out.println("==================================================================================");
		System.out.println();

		System.out.println("예약 취소할 일련번호 입력");
		System.out.print("일련번호 : ");
		no = scan.nextInt();
		
		rd.setReservationDelete(no);

		System.out.println("==================================================================================");
		System.out.println("\t\t\t\t예약 신청 목록 현황");
		System.out.println("==================================================================================");
		rd.getReservationTotalList(id, pw);
		System.out.println("==================================================================================");
		System.out.println();
		
	}
}
