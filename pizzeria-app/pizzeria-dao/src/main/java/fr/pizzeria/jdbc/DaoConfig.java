package fr.pizzeria.jdbc;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("fr.pizzeria.dao")
public class DaoConfig {

	@Bean
	public DataSource dataSource() {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("database.driver");
		String url = "jdbc:" + bundle.getString("database.type") + "://" + bundle.getString("database.host") + ":"
				+ bundle.getString("database.port") + "/" + bundle.getString("database.name");
		String password = bundle.getString("database.password");
		String user = bundle.getString("database.user");

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}
}
