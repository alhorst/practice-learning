package com.techelevator.blog;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class PostJdbcDao implements PostDao {

	private JdbcTemplate jdbcTemplate;

	public PostJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Post newPost) {
		String sql = "INSERT INTO posts (name, body, published, created) " +
				"VALUES (?, ?, ?, ?) RETURNING id";
		Long postId = jdbcTemplate.queryForObject(sql, Long.class, newPost.getName(), newPost.getBody(),
				newPost.isPublished(), newPost.getCreated());

		newPost.setId(postId);
	}

	@Override
	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		String sql = "SELECT * FROM posts";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			posts.add(mapRowToPost(results));
		}

		return posts;
	}

	private Post mapRowToPost(SqlRowSet results) {
		Post postRow = new Post();
		postRow.setId(results.getLong("id"));
		postRow.setName(results.getString("name"));
		postRow.setBody(results.getString("body"));
		postRow.setPublished(results.getBoolean("published"));
		postRow.setCreated(results.getDate("created").toLocalDate());
		return postRow;
	}

}
