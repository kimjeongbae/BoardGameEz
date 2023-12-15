package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== 보드게임 추천 게시판 ==========");
        System.out.println("로그인 / 회원가입 / 게시판 / 리뷰 / 좋아요");
        System.out.println("===========================================");

        int lastId = 1;
        List<Board> boardList = new ArrayList<>();

        while (true) {
            System.out.printf("명령어 :  ");
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                break;
            }
            else if (command.equals("게시판")){
                System.out.println("==========================");
                System.out.println("게시판 작성 / 게시판 목록");
                System.out.println("==========================");
            }
            else if (command.equals("게시판 작성")) {
                System.out.println("보드게임 이름을 입력해주세요.");
                System.out.print("보드게임 이름 : ");
                String title = sc.nextLine();

                System.out.println("보드게임 난이도를 입력해주세요. ex) 상 중 하");
                System.out.print("보드게임 난이도 : ");
                String level = sc.nextLine();

                System.out.println("보드게임 플레이어 수 를 입력해주세요.");
                System.out.print("추천 플레이 인원 : ");
                String count =  sc.nextLine().trim();

                System.out.println("보드게임 플레이 타임을 입력해주세요");
                System.out.print("플레에 타임 : ");
                String time =  sc.nextLine().trim();

                Board board = new Board(lastId,title,level,count,time);
                boardList.add(board);

                lastId++;
            } else if (command.equals("게시판 목록")){
                System.out.println(boardList.size());

            }

        }



        sc.close();
    }
}