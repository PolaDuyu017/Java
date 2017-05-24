package dao;

import javax.sql.DataSource;

import logic.User;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UserDaoImpl implements UserDao{
	
	private SimpleJdbcTemplate templete;

	public void setDataSource(DataSource dataSource) {
		this.templete = new SimpleJdbcTemplate(dataSource);
	}
	
	private static final String INSERT = 
			"INSERT INTO sin_user_account (user_id, user_name, password, postcode,"
			+ "address, email, job, birthday) "
			+ "VALUES(:userId, :userName, :password, :postCode, "
			+ ":address, :email, :job, :birthDay)";

	@Override
	public void create(User user) {
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		this.templete.update(UserDaoImpl.INSERT, parameterSource);
	}

}
