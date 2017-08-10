package ru.pandn.processing.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pandn.model.User;
import ru.pandn.model.UserList;
import ru.pandn.processing.UserService;
import ru.pandn.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    public UserList getUsers() {
        logger.info("UserServiceImpl(): getUsers()");
        UserList userList = new UserList();
        try {
            List<User> users = userRepository.getUsers();
            if (!users.isEmpty())
                userList.setUsers(users);
        } catch (Exception e) {
            logger.error("getUsers(): error:{}",e.getMessage());
        }
        return userList;
    }

    public User getUserById(final Integer userId) {
        logger.info("UserServiceImpl(): getUserById(): userId:{}",userId);
        User user = null;
        try {
            user = userRepository.getUserById(userId);
        } catch (Exception e) {
            logger.error("getUserById(): error:{}",e.getMessage());
        }
        return user;
    }

}
