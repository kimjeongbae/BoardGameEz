package org.example.board;

import org.example.container.Global;
import java.util.List;

public class BoardController {

    BoardService boardService;

    public BoardController () {

        boardService = new BoardService();
    }


    public void create () {

        if (Global.getLogineUser() == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            return;
        }

        System.out.println("보드게임 이름을 입력해주세요.");
        System.out.print("보드게임 이름 : ");
        String title = Global.getScanner().nextLine();
        System.out.println("======================================================");

        System.out.println("보드게임 난이도를 입력해주세요. ex) 상 중 하");
        System.out.print("보드게임 난이도 : ");
        String level = Global.getScanner().nextLine();
        System.out.println("======================================================");

        System.out.println("보드게임 플레이어 수 를 입력해주세요.");
        System.out.print("추천 플레이 인원 (명) : ");
        int count = Integer.parseInt(Global.getScanner().nextLine().trim());
        System.out.println("======================================================");

        System.out.println("보드게임 플레이 타임을 입력해주세요");
        System.out.print("플레이 타임 (분) : ");
        int time = Integer.parseInt(Global.getScanner().nextLine().trim());
        System.out.println("======================================================");

        int id = this.boardService.save(title,level,count,time);

        System.out.println(id +"번 게시글이 입력 되었습니다.");



    }

    public void delete () {

        if (Global.getLogineUser() == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            return;
        }

        System.out.println("삭제할 게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");
        int removeId = Integer.parseInt(Global.getScanner().nextLine().trim());

        Board board = this.boardService.boardFindId(removeId);

        if (board == null) {
            System.out.println("해당 게시글은 존재 하지 않습니다." );
            return;
        }

        if (board.getAuthor() != Global.getLogineUser().getNickname()) {
            System.out.println("해당 작성자만 삭제가 가능합니다.");
            return;
        }

        int id = this.boardService.delete(board);


        System.out.println(id + " 번 게시글이 삭제 되었습니다.");

    }

    public void list () {
        List<Board> boardList = this.boardService.findByAll();

        System.out.println("번호 / 보드게임 이름 / 게임 난이도 / 추천 인원수 / 플레이 타임 / 작성자 / 좋아요 /등록일");
        System.out.println("=======================================================================================");

        for (Board board : boardList) {
            System.out.printf("%d  /    %s  /    %s     /    %s    /     %s   /    %s   /   %s   /  %s \n", board.getId(), board.getTitle(), board.getLevel(), board.getCount()+" 명" ,board.getTime()+" 분" , board.getAuthor(), board.getLike_count() ,board.getCreated_date());
        }
    }

    public void update () {

        if (Global.getLogineUser() == null) {
            System.out.println("해당 기능은 로그인 후 이용 가능합니다.");
            return;
        }

        System.out.println("수정할 게시글 번호를 입력하세요.");
        System.out.print("게시글 번호 : ");

        int modifyId = Integer.parseInt(Global.getScanner().nextLine().trim());

        Board board= this.boardService.boardFindId(modifyId);

        if (board == null) {
            System.out.println("해당 게시글은 존재 하지 않습니다." );
            return;
        }

        if (board.getAuthor() != Global.getLogineUser().getNickname()) {
            System.out.println("해당 작성자만 수정 가능합니다.");
            return;
        }

        System.out.printf("보드게임 이름 : %s \n", board.getTitle());
        System.out.print("수정할 이름 : ");
        String title = Global.getScanner().nextLine();
        System.out.println("======================================================");

        System.out.printf("보드게임 난이도 : %s \n", board.getLevel());
        System.out.print("수정할 난이도 : ");
        String level = Global.getScanner().nextLine();
        System.out.println("======================================================");


        System.out.printf("추천 플레이 인원 : %s \n", board.getCount());
        System.out.print("수정할 추천 인원수  : ");
        int count = Integer.parseInt(Global.getScanner().nextLine());
        System.out.println("======================================================");

        System.out.printf("플레이 타임  : %s  \n", board.getTime());
        System.out.print("수정할 플레이 타임 : ");
        int time = Integer.parseInt(Global.getScanner().nextLine());
        System.out.println("======================================================");

        int id = this.boardService.update(board,title,level,count,time);

        System.out.println(id + " 번 게시글이 수정 되었습니다.");
    }

}

