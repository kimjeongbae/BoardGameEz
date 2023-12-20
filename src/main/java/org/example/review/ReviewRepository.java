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


    public int delete(Review review) {

        return review.getId();
    }

    public int update(Review review, String score, String content) {
        review.setScore(score);
        review.setContent(content);

        return review.getId();
    }
}
