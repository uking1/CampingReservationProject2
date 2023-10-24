package view;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class MenuViewer {
	public static Scanner scan = new Scanner(System.in);

	// 메인 메뉴

	public static void mainMenuView() {
		System.out.println("미래캠핑장 예약 프로그램");
		System.out.println("번호를 입력하세요.");
		System.out.println("1. 사이트 목록/추가/변경/삭제(관리자 전용)");
		System.out.println("2. 예약자 목록/입력/수정");
		System.out.println("3. 캠핑장 예약 목록/신청/취소");
		System.out.println("4. 종료");
		System.out.print("번호 선택 : ");
	}

	// 사이트 메뉴
	public static void reservationSitesMenuView() {
		System.out.println();
		System.out.println("메뉴 번호를 선택하세요.");
		System.out.println("1. 캠핑장 사이트 목록");
		System.out.println("2. 사이트 정보 추가");
		System.out.println("3. 사이트 정보 수정");
		System.out.println("4. 사이트 정보 삭제하기");
		System.out.println("5. 메인으로 돌아가기");
		System.out.print("번호 선택 : ");

	}

	// 예약자 메뉴
	public static void reservationInfoMenuView() {
		System.out.println();
		System.out.println("예약자 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 예약자 전체 목록(관리자 전용)");
		System.out.println("2. 예약자 정보 입력");
		System.out.println("3. 예약자 정보 수정");
		System.out.println("4. 메인으로 돌아가기");
		System.out.print("번호 선택 : ");

	}

	// 예약하기 메뉴
	public static void reservationMenuView() {
		System.out.println();
		System.out.println("예약 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 내 예약현황 확인");
		System.out.println("2. 예약 신청");
		System.out.println("3. 예악 취소");
		System.out.println("4. 메인으로 돌아가기");
		System.out.print("번호 선택 : ");

	}

}