package org.example.board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BoardController {
    List<Board> boardList = new ArrayList<>();
    int lastBoardId = 1;

    public void creat () {

        if (loginedUser == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            continue;
        }

        System.out.println("보드게임 이름을 입력해주세요.");
        System.out.print("보드게임 이름 : ");
        String title = sc.nextLine();
        System.out.println("======================================================");

        System.out.println("보드게임 난이도를 입력해주세요. ex) 상 중 하");
        System.out.print("보드게임 난이도 : ");
        String level = sc.nextLine();
        System.out.println("======================================================");

        System.out.println("보드게임 플레이어 수 를 입력해주세요.");
        System.out.print("추천 플레이 인원 (명) : ");
        int count = Integer.parseInt(sc.nextLine().trim());
        System.out.println("======================================================");

        System.out.println("보드게임 플레이 타임을 입력해주세요");
        System.out.print("플레이 타임 (분) : ");
        int time = Integer.parseInt(sc.nextLine().trim());
        System.out.println("======================================================");

        LocalDate now = LocalDate.now();

        Board board = new Board(lastBoardId, title, level, count, time , loginedUser.getNickname(),0,now.toString());
        boardList.add(board);

        lastBoardId++;

    }

    public void delete () {

        if (loginedUser == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            continue;
        }

        System.out.println("삭제할 게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");
        int removeId = Integer.parseInt(sc.nextLine().trim());

        Board board = null;
        for (int i = 0; i < boardList.size(); i++) {
            if (removeId == boardList.get(i).getId()) {
                board = boardList.get(i);
            }
        }

        if (board == null) {
            System.out.println("해당 게시글은 존재 하지 않습니다." );
            continue;
        }

        if (board.getAuthor() != loginedUser.getNickname()) {
            System.out.println("해당 작성자만 삭제가 가능합니다.");
            continue;
        }

        boardList.remove(board);

        System.out.println(removeId + " 번 게시글이 삭제 되었습니다.");

    }

    public void list () {
        System.out.println("번호 / 보드게임 이름 / 게임 난이도 / 추천 인원수 / 플레이 타임 / 작성자 / 좋아요 /등록일");
        System.out.println("=======================================================================================");

        for (Board board : boardList) {
            System.out.printf("%d  /    %s  /    %s     /    %s    /     %s   /    %s   /   %s   /  %s \n", board.getId(), board.getTitle(), board.getLevel(), board.getCount()+" 명" ,board.getTime()+" 분" , board.getAuthor(), board.getLike_count() ,board.getCreated_date());
        }
    }

    public void update () {

        if (loginedUser == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            continue;
        }

        System.out.println("수정할 게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");

        int modifyId = Integer.parseInt(sc.nextLine().trim());

        Board board = null;

        for (int i = 0; i < boardList.size(); i++) {
            if (modifyId == boardList.get(i).getId()) {
                board = boardList.get(i);
            }
        }

        if (board == null) {
            System.out.println("해당 게시글은 존재 하지 않습니다." );
            continue;
        }

        if (board.getAuthor() != loginedUser.getNickname()) {
            System.out.println("해당 작성자만 수정 가능합니다.");
            continue;
        }

        System.out.printf("보드게임 이름 : %s \n", board.getTitle());
        System.out.print("수정할 이름 : ");
        String title = sc.nextLine();
        System.out.println("======================================================");

        System.out.printf("보드게임 난이도 : %s \n", board.getLevel());
        System.out.print("수정할 난이도 : ");
        String level = sc.nextLine();
        System.out.println("======================================================");


        System.out.printf("추천 플레이 인원 : %s \n", board.getCount());
        System.out.print("수정할 추천 인원수  : ");
        int count = Integer.parseInt(sc.nextLine());
        System.out.println("======================================================");

        System.out.printf("플레이 타임  : %s  \n", board.getTime());
        System.out.print("수정할 플레이 타임 : ");
        int time = Integer.parseInt(sc.nextLine());
        System.out.println("======================================================");


        board.setTitle(title);
        board.setLevel(level);
        board.setCount(count);
        board.setTime(time);

        System.out.println(modifyId + " 번 게시글이 수정 되었습니다.");
    }

}
