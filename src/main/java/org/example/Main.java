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

            System.out.print("명령어 :  ");
            String command = sc.nextLine().trim();
            System.out.println("===========================================");

            if (command.equals("종료")) {
                break;
            } else if (command.equals("게시판")) {
                System.out.println("======================================================");
                System.out.println("게시판 작성 / 게시판 목록 / 게시판 삭제 / 게시판 수정");
                System.out.println("======================================================");
            } else if (command.equals("게시판 작성")) {
                System.out.println("보드게임 이름을 입력해주세요.");
                System.out.print("보드게임 이름 : ");
                String title = sc.nextLine();
                System.out.println("===========================================");

                System.out.println("보드게임 난이도를 입력해주세요. ex) 상 중 하");
                System.out.print("보드게임 난이도 : ");
                String level = sc.nextLine();
                System.out.println("===========================================");

                System.out.println("보드게임 플레이어 수 를 입력해주세요.");
                System.out.print("추천 플레이 인원 : ");
                String count = sc.nextLine().trim();
                System.out.println("===========================================");

                System.out.println("보드게임 플레이 타임을 입력해주세요");
                System.out.print("플레이 타임 : ");
                String time = sc.nextLine().trim();
                System.out.println("===========================================");

                Board board = new Board(lastId, title, level, count, time);
                boardList.add(board);

                lastId++;

            } else if (command.equals("게시판 목록")) {
                System.out.println("번호 / 보드게임 이름 / 게임 난이도 / 추천 인원수 / 플레이 타임");
                System.out.println("===============================================================");
                for (Board board : boardList) {
                    System.out.printf("%d  /    %s  /    %s  /   %s   /    %s\n", board.getId(), board.getTitle(), board.getLevel(), board.getCount(), board.getTime());
                }

            } else if (command.equals("게시판 삭제")) {
                System.out.println("삭제할 게시판 번호를 입력하세요.");
                System.out.print("게시판 번호 : ");

                int removeId = Integer.parseInt(sc.nextLine().trim());

                for (int i = 0; i < boardList.size(); i++) {
                    if (removeId == boardList.get(i).getId()) {
                        boardList.remove(i);
                    }
                }
                System.out.println(removeId + " 번 게시글이 삭제 되었습니다.");
            } else if (command.equals("게시판 수정")) {
                System.out.println("수정할 게시판 번호를 입력하세요.");
                System.out.print("게시판 번호 : ");

                int modifyId = Integer.parseInt(sc.nextLine().trim());

                for (int i = 0; i < boardList.size(); i++) {
                    if (modifyId == boardList.get(i).getId()) {
                        Board board = boardList.get(i);

                        System.out.printf("보드게임 이름 : %s \n", board.getTitle());
                        System.out.print("수정할 이름 : ");
                        String title = sc.nextLine();
                        System.out.println("===========================================");

                        System.out.printf("보드게임 난이도 : %s \n", board.getLevel());
                        System.out.print("수정할 난이도 : ");
                        String level = sc.nextLine();
                        System.out.println("===========================================");

                        System.out.printf("추천 플레이 인원 : %s \n", board.getCount());
                        System.out.print("수정할 추천 인원수  : ");
                        String count = sc.nextLine();
                        System.out.println("===========================================");

                        System.out.printf("플레이 타임  : %s  \n", board.getTime());
                        System.out.print("수정할 플레이 타임 : ");
                        String time = sc.nextLine();
                        System.out.println("===========================================");


                        board.setTitle(title);
                        board.setLevel(level);
                        board.setCount(count);
                        board.setTime(time);
                    }

                }
                System.out.println(modifyId + " 번 게시글이 수정 되었습니다.");

            }
        }


            sc.close();
        }
    }