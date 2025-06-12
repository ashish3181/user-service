package com.user.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
public class UserRepositoryImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean saveUser(User user) {
		int val = jdbcTemplate.update("INSERT INTO user VALUES ('0',?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, user.getName());
			}

		});
		if (val > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> getAllUsers() {
		String sql = "SELECT * FROM user";

		List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id")); // Assuming the column name is 'id'
				user.setName(rs.getString("name")); // Assuming the column name is 'name'
				return user;
			}
		});

		return userList;
	}

}
