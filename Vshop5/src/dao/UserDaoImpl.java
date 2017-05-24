package dao;

import javax.sql.DataSource;

import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	private SimpleJdbcTemplate templete;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.templete = new SimpleJdbcTemplate(dataSource);
	}
	
	private static final String SELECT_BY_USERID_PASSWORD = 
			"SELECT user_id, password, user_name, postcode, address,"
			+ " email, job, birthday FROM sin_user_account WHERE user_id = ? AND password = ?";

	
	private static final String INSERT = 
			"INSERT INTO sin_user_account (user_id, user_name, password, postcode,"
			+ "address, email, job, birthday) "
			+ "VALUES(:userId, :userName, :password, :postCode, "
			+ ":address, :email, :job, :birthDay)";
	
	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.templete.queryForObject(SELECT_BY_USERID_PASSWORD, mapper, userId, password);
	}
	
	@Override
	public void create(User user) {
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		this.templete.update(UserDaoImpl.INSERT, parameterSource);
	}

}
