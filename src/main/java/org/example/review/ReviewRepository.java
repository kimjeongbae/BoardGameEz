package org.example.review;



import org.example.container.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewRepository {

    public int save (String boardTitle, String score, String content) {

        String sql = String.format("INSERT INTO review SET boardTitle = '%s' , score = '%s' , content = '%s' , userId = '%d', created_date=now();" ,boardTitle,score,content,Global.getLogineUser().getId());

        int id = Global.getDBConnection().insert(sql);

        return id;
    }

    public List<ReviewDTO> joinMemberFindByAll() {
        List<ReviewDTO> reviewList = new ArrayList<>();

        List<Map<String, Object>> rows =  Global.getDBConnection().selectRows("SELECT R.*,U.nickname FROM review AS R INNER JOIN `user` AS U ON R.userId = U.id;");

        for (Map<String, Object> row : rows) {
            ReviewDTO review = new ReviewDTO(row);
            reviewList.add(review);
        }

        return reviewList;
    }


    public List<Review> findByAll() {
        List<Review> reviewList = new ArrayList<>();

        List<Map<String, Object>> rows =  Global.getDBConnection().selectRows("select * from review");
        for (Map<String, Object> row : rows) {
            Review review = new Review(row);

            reviewList.add(review);
    }
        return reviewList;
    }

    public Review reviewFindById(int id){
        List<Review> reviewList = this.findByAll();
        for (int i = 0; i < reviewList.size(); i++) {
            if (id == reviewList.get(i).getId()) {
                return reviewList.get(i);
            }
        }
        return null;
    }



    public void delete(Review review) {
        String sql = String.format("DELETE FROM review where id=%d;", review.getId());
        Global.getDBConnection().delete(sql);
    }

    public void update(Review review, String score, String content) {
        String sql = String.format("UPDATE review SET score='%s', content='%s' where id=%d;", score, content, review.getId());
        Global.getDBConnection().update(sql);
    }

    public List<ReviewDTO> searchByNickname(String searchKeyword) {
        List<ReviewDTO> reviewList = new ArrayList<>();

        String sql = String.format(
                "SELECT R.*, U.nickname FROM review AS R INNER JOIN `user` AS U ON R.userId = U.id WHERE U.nickname LIKE '%s%%';",
                searchKeyword);

        List<Map<String, Object>> rows = Global.getDBConnection().selectRows(sql);

        for (Map<String, Object> row : rows) {
            ReviewDTO review = new ReviewDTO(row);
            reviewList.add(review);
        }

        return reviewList;
    }

    public List<ReviewDTO> searchByTitlename(String searchKeyword) {
        List<ReviewDTO> reviewList = new ArrayList<>();

        String sql = String.format(
                "SELECT R.*, U.nickname FROM review AS R INNER JOIN `user` AS U ON R.userId = U.id WHERE `boardTitle` LIKE '%s%%';",
                searchKeyword);

        List<Map<String, Object>> rows = Global.getDBConnection().selectRows(sql);

        for (Map<String, Object> row : rows) {
            ReviewDTO review = new ReviewDTO(row);
            reviewList.add(review);
        }

        return reviewList;
    }

}

