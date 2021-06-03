package javaexp.a00_exp.teamP_03;

import java.util.Scanner;

public class UpdateinfoController {
	UpdateinfoService upService = new UpdateinfoService();

	// 회원정보 출력
	public String showMemberInform(MemberProfile mp, Model d) {
		d.addAttribute("회원정보 출력", upService.showMemberInfo(mp));

		// 데이터를 Model로 받아와서 출력하면
		System.out.println("--------------------");
		String[] memberInfo = upService.showMemberInfo(mp);
		System.out.println("이름: " + memberInfo[0]);
		System.out.println("휴대폰 번호: " + memberInfo[1]);
		System.out.println("통관 번호: " + memberInfo[2]);
		System.out.println("이메일: " + memberInfo[3]);
		System.out.println("정보제공 동의여부: " + memberInfo[4]);
		System.out.println("--------------------");

		return "호출화면";
	}

	// 휴대폰 번호 수정
	public String editPhone(MemberProfile mp, Model d) {
		d.addAttribute("휴대폰 번호 수정", upService.editPhone(mp, "010-1234-5678"));

		// 데이터를 Model로 받아와서 출력하면
		System.out.println("--------------------");
		System.out.println("# 휴대폰 번호 수정 #");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("새 휴대폰 번호 입력: ");
		String newPhone = sc1.nextLine();
		System.out.println(upService.editPhone(mp, newPhone));
		System.out.println("--------------------");
		return "호출화면";
	}

	// 통관번호 수정
	public String editPccc(MemberProfile mp, Model d) {
		d.addAttribute("통관 번호 수정", upService.editPccc(mp, ""));

		// 데이터를 Model로 받아와서 출력하면
		System.out.println("--------------------");
		System.out.println("# 통관 번호 수정 #");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("새 통관 번호 입력: ");
		String newPccc = sc1.nextLine();
		System.out.println(upService.editPccc(mp, newPccc));
		System.out.println("--------------------");
		return "호출화면";
	}

	// 이메일 수정
	public String editEmail(MemberProfile mp, Model d) {
		d.addAttribute("이메일 주소 수정", upService.editEmail(mp, "qwerty@gamil.com"));

		// 데이터를 Model로 받아와서 출력하면
		System.out.println("--------------------");
		System.out.println("# 이메일 주소 수정 #");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("새 이메일 주소 입력: ");
		String newEmail = sc1.nextLine();
		System.out.println(upService.editEmail(mp, newEmail));
		System.out.println("--------------------");
		return "호출화면";
	}

	// 동의여부 수정
	public String editAble(MemberProfile mp, Model d) {
		d.addAttribute("동의여부 수정", upService.editAble(mp, "true"));

		// 데이터를 Model로 받아와서 출력하면
		System.out.println("--------------------");
		System.out.println("# 정보제공 동의여부 수정 #");
		Scanner sc1 = new Scanner(System.in);
		System.out.print("true/false 입력: ");
		String newAble = sc1.nextLine();
		System.out.println(upService.editAble(mp, newAble));
		System.out.println("--------------------");
		return "호출화면";
	}
}
