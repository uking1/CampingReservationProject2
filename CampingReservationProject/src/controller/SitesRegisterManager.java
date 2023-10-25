package controller;

import java.util.Scanner;

import model.SitesVO;

public class SitesRegisterManager {

	// 사이트 목록
	public void sitesList() throws Exception {
		SitesDAO sd = new SitesDAO();
		System.out.println("=================================================");
		System.out.println("\t\t사이트 목록");
		System.out.println("=================================================");
		sd.getSitesTotalList();
		System.out.println("=================================================");
		System.out.println();

	}

	// 사이트 등록 관리
	public void sitesRegister() throws Exception {
		Scanner scan = new Scanner(System.in);

		SitesDAO sd = new SitesDAO();
		SitesVO svo = new SitesVO();

		int no; // 사이트 일련번호
		String site_id; // 사이트 구역
		String site_num; // 사이트 번호
		String site_size; // 사이트 크기

		System.out.println("=================================================");
		System.out.println("\t\t사이트 목록");
		System.out.println("=================================================");
		sd.getSitesTotalList();
		System.out.println("=================================================");
		System.out.println();

		System.out.println("사이트 정보 입력 ");
		System.out.println("일련번호 : ");
		no = Integer.parseInt(scan.nextLine());

		System.out.print("사이트 구역 : ");
		site_id = scan.nextLine();
		System.out.println("사이트 번호 : ");
		site_num = scan.nextLine();
		System.out.println("사이트 사이즈 : ");
		site_size = scan.nextLine();

		svo.setSite_id(site_id);
		svo.setSite_num(site_num);
		svo.setSite_size(site_size);

		sd.setSitesRegiste(svo);

		System.out.println();
		System.out.println("=================================================");
		System.out.println("\t\t사이트 목록");
		System.out.println("=================================================");
		sd.getSitesTotalList();
		System.out.println("=================================================");
		System.out.println();

	}

	// 사이트 수정 관리
	public void sitesUpdate() throws Exception {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		SitesDAO sd = new SitesDAO();
		SitesVO svo = new SitesVO();

		int no; // 입력한 일련번호
		String site_id; // 사이트 구역
		String site_num; // 사이트 번호
		String site_size; // 사이트 사이즈

		System.out.println("=================================================");
		System.out.println("\t\t사이트 목록");
		System.out.println("=================================================");
		sd.getSitesTotalList();
		System.out.println("=================================================");
		System.out.println();

		System.out.println("수정할 사이트 일련번호를 입력 해주세요.");
		System.out.print("일련번호 : ");
		no = scan2.nextInt();

		System.out.println();
		System.out.println("수정할 정보를 입력해주세요. ");
		System.out.print("사이트 구역 : ");
		site_id = scan.nextLine();
		System.out.println("사이트 번호 : ");
		site_num = scan.nextLine();
		System.out.println("사이트 사이즈 : ");
		site_size = scan.nextLine();

		svo.setNo(no);
		svo.setSite_id(site_id);
		svo.setSite_num(site_num);
		svo.setSite_size(site_size);

		sd.setSitesUpdate(svo);

		System.out.println();
		System.out.println("=================================================");
		System.out.println("\t\t사이트 목록");
		System.out.println("=================================================");
		sd.getSitesTotalList();
		System.out.println("=================================================");
		System.out.println();

	}

	// 사이트 삭제 관리
	public void sitesDelete() throws Exception {
		Scanner scan = new Scanner(System.in);

		SitesDAO sd = new SitesDAO();
		SitesVO svo = new SitesVO();

		int no; // 입력한 일련번호
		System.out.println("=================================================");
		System.out.println("\t\t사이트 목록");
		System.out.println("=================================================");
		sd.getSitesTotalList();
		System.out.println("=================================================");
		System.out.println();

		System.out.println("삭제할 사이트 일련번호를 입력 해주세요.");
		System.out.print("일련번호 : ");
		no = scan.nextInt();

		sd.setSitesDelete(no);

		System.out.println();
		System.out.println("=================================================");
		System.out.println("\t\t사이트 목록");
		System.out.println("=================================================");
		sd.getSitesTotalList();
		System.out.println("=================================================");
		System.out.println();

	}

}