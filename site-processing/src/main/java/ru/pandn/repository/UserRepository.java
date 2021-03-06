package ru.pandn.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.pandn.mapper.UserMapper;
import ru.pandn.model.User;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository extends InitRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public List<User> getUsers() throws SQLException{
        final String SQL = "SELECT * FROM users ORDER BY id DESC";
        List<User> userDB = jdbc.query(SQL,new UserMapper());
        return userDB;
    }

    public User getUserById(final Integer id) throws SQLException{
        final String SQL = "SELECT * FROM users WHERE id = ?";
        User userDB = jdbc.queryForObject(SQL,new Object[]{ id },new UserMapper());
        return userDB;
    }

    public boolean addNewUser(final User user) throws SQLException{
        final String SQL = "INSERT INTO users(name) VALUES (?)";
        jdbc.update(SQL, user.getName());
        return true;
    }

    public boolean deleteUser(final Integer id) throws SQLException{
        final String SQL = "DELETE FROM users WHERE id = ?";
        jdbc.update(SQL,id);
        return true;
    }
}
