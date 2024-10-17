package io.member;

import io.member.impl.MemoryMemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {

    public static final MemberRepository memberRepository = new MemoryMemberRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 회원 등록 | 2. 회원 목록 조회 | 3. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // new line 제거
            if (choice == 1) {
                registerMember(scanner);
            } else if (choice == 2) {
                displayMember(memberRepository);
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }

    private static void registerMember(Scanner scanner) {
        System.out.print("ID 입력: ");
        String id = scanner.next();

        System.out.print("Name 입력: ");
        String name = scanner.next();

        System.out.print("Age 입력: ");
        int age = scanner.nextInt();

        memberRepository.add(new Member(id, name, age));
        System.out.println("회원이 성공적으로 등록되었습니다.");
        System.out.println();
    }

    private static void displayMember(MemberRepository memberRepository) {
        System.out.println("회원 목록:");
        System.out.println(memberRepository.findAll());
        System.out.println();
    }
}
