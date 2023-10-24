package controller;

import java.util.Scanner;

import model.InfoVO;

public class InfoRegisterManager {
	public Scanner scan = new Scanner(System.in);

	// 예약자 정보 등록

	public void infoRegister() throws Exception {
		SitesDAO sdo = new SitesDAO();
		InfoDAO ido = new InfoDAO();
		InfoVO ivo = new InfoVO();

		String reservation_id; // 예약자 아이디
		String reservation_pw; // 예약자 비밀번호
		String name; // 예약자 성함
		String phone; // 예약자 연락처

		boolean id_check; // 아이디 체크

		System.out.println("예약자 정보 입력");
		System.out.println("성함 : ");
		name = scan.nextLine();

		do {
			System.out.println("아이디 입력(20자 이내) :");
			reservation_id = scan.nextLine();
			id_check = ido.getInfoIdOverlap(reservation_id);
			if (id_check) {
				System.out.println("중복된 아이디 입니다. 다시 입력해주세요.");
			}

		} while (id_check);

		System.out.print("비밀번호(20자 이내) :");
		reservation_pw = scan.nextLine();

		System.out.println("연락처 : ");
		phone = scan.nextLine();

		ivo.setName(name);
		ivo.setPhone(phone);
		ivo.setReservation_id(reservation_id);
		ivo.setReservation_pw(reservation_pw);

		ido.setInfoRegiste(ivo);
		
		System.out.println();
		System.out.println("===========================================================");
		System.out.println("예약자 정보");
		ido.getInfo(reservation_id, reservation_pw);
		System.out.println("===========================================================");
		System.out.println();
	}

	// 예약자 정보 수정
	public void InfoUpdate() throws Exception {
		InfoDAO ido = new InfoDAO();
		InfoVO ivo = new InfoVO();

		String reservation_id;
		String reservation_pw;
		String name;
		String phone; // 수정 연락처
		String reservation_date; // 수정 예약날짜

		boolean flag = false;

		System.out.println("예약자 정보 수정");

		do {
			System.out.println("아이디 : ");
			reservation_id = scan.nextLine();
			System.out.println("비밀번호 : ");
			reservation_pw = scan.nextLine();
			flag = ido.getInfoLogin(reservation_id, reservation_pw);

			if (!flag) {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 입력해주세요.");
			}

		} while (!flag);

		// 기존 정보를 가져옴
		InfoVO originalInfo = ido.getInfo(reservation_id, reservation_pw);

		// 수정할 정보를 입력
		System.out.println("새로운 연락처 입력: ");
		phone = scan.nextLine();
		ivo.setPhone(phone);

		// 변경된 정보를 객체에 설정
		ivo.setName(originalInfo.getName());
		ivo.setReservation_id(reservation_id);
		ivo.setReservation_pw(reservation_pw);
		ivo.setNo(originalInfo.getNo());

		// 정보 업데이트
		ido.setInfoUpdate(ivo);

		System.out.println("예약자 정보 수정 완료!!");
		System.out.println("===========================================================");
		System.out.println("변경된 예약자 정보:");
		InfoVO updatedInfo = ido.getInfo(reservation_id, reservation_pw);
		System.out.println("===========================================================");

	}

	// 예약자 전체 목록
	public void infoTotalList() throws Exception {
		InfoDAO ido = new InfoDAO();

		String pw;
		System.out.println("예약자 전체 목록");
		System.out.println("관리자 비밀번호 : ");
		pw = scan.nextLine();

		if (pw.equals("admin")) {
			System.out.println("===========================================================");
			ido.getInfoTotalList();
			System.out.println("===========================================================");
		} else {
			System.out.println("관리자 비밀번호가 다릅니다.");
		}

	}

}