package com.educacionIt.javase.KillaCoffee.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.educacionIt.javase.KillaCoffee.exception.UserNotFoundException;
import com.educacionIt.javase.KillaCoffee.model.dao.UserDao;
import com.educacionIt.javase.KillaCoffee.model.entity.User;
import com.educacionIt.javase.KillaCoffee.model.jdbc.DBConnection;

public class UserDaoImpl implements UserDao {

	private static final String FIND_BY_USERNAME = "select username, password from users where username = ?";
    private static final String CREATE = "insert into users (username, password) values(?, ?)";
    
	@Override
	 public boolean create(User user) {
        try (Connection connection = DBConnection.getInstance()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());

            // Ejecutar la inserción
            int rowsAffected = ps.executeUpdate();

            // Si se afectó al menos una fila, la inserción fue exitosa
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Si hubo una excepción, retornar false
    }

	 @Override
	    public User findByUserName(String userName) throws UserNotFoundException {
	        User user = null;
	        try (Connection connection = DBConnection.getInstance();
	             PreparedStatement ps = connection.prepareStatement(FIND_BY_USERNAME)) {

	            ps.setString(1, userName);
	            try (ResultSet rs = ps.executeQuery()) {

	                if (rs.next()) {
	                    String newUserName = rs.getString("username");
	                    String password = rs.getString("password");

	                    user = new User(newUserName, password);
	                    return user;
	                } else {
	                    throw new UserNotFoundException("User " + userName + " is not registered");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

}
