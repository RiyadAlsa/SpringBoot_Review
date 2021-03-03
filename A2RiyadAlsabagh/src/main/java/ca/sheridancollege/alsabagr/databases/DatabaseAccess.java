package ca.sheridancollege.alsabagr.databases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.alsabagr.beans.Review;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void inputReview(Review review) {
		MapSqlParameterSource namedParameter = new MapSqlParameterSource();
		String query = "INSERT INTO REVIEW(resName, resReview, showDay, showTime) VALUES(:resName, :resReview, :showDay, :showTime)";

		namedParameter.addValue("resName", review.getResName());
		namedParameter.addValue("resReview", review.getResReview());
		namedParameter.addValue("showDay", review.getShowDay());
		namedParameter.addValue("showTime", review.getShowTime());

		int rowsAffected = jdbc.update(query, namedParameter);
		if (rowsAffected > 0) {
			System.out.println("Added " + review.getResName() + " review to the database");
		}

	}

	public List<Review> viewReviews() {

		String query = "SELECT * FROM REVIEW";
		List<Review> viewReviews = jdbc.query
				(query, new BeanPropertyRowMapper<Review>
				(Review.class));
		
		return viewReviews;
	}
}
