package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import spring5.ChangePasswordService;
import spring5.DuplicateMemberException;
import spring5.MemberNotFoundException;
import spring5.MemberRegisterService;
import spring5.RegisterRequest;
import spring5.WrongIdPasswordException;

public class MainForAssembler {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}

	private static Assembler assembler = new Assembler();
	//Assembler 클래스의 생성자에서 필요한 객체를 생서앟고 의존을 주업힌다. 따라서 Assembler객체를 생성하는 시점에 사용할 객체가 모두 생성된다.
	//Assembler는 자신이 생성하고 조립한 객체를 리턴하는 메서드를 제공한다.
	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = assembler.getMemberRegisterService();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("?뷀샇? ?뺤씤???쇱튂?섏? ?딆뒿?덈떎.\n");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("?깅줉?덉뒿?덈떎.\n");
		} catch (DuplicateMemberException e) {
			System.out.println("?대? 議댁옱?섎뒗 ?대찓?쇱엯?덈떎.\n");
		}
	}

	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc = 
				assembler.getChangePasswordService();
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("?뷀샇瑜?蹂寃쏀뻽?듬땲??\n");
		} catch (MemberNotFoundException e) {
			System.out.println("議댁옱?섏? ?딅뒗 ?대찓?쇱엯?덈떎.\n");
		} catch (WrongIdPasswordException e) {
			System.out.println("?대찓?쇨낵 ?뷀샇媛 ?쇱튂?섏? ?딆뒿?덈떎.\n");
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("?섎せ??紐낅졊?낅땲?? ?꾨옒 紐낅졊???ъ슜踰뺤쓣 ?뺤씤?섏꽭??");
		System.out.println("紐낅졊???ъ슜踰?");
		System.out.println("new ?대찓???대쫫 ?뷀샇 ?뷀샇?뺤씤");
		System.out.println("change ?대찓???꾩옱鍮꾨쾲 蹂寃쎈퉬踰?");
		System.out.println();
	}
}