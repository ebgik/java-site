package ru.pandn.service;

import ru.pandn.model.User;
import ru.pandn.model.UserList;

public interface UserService {
    UserList getUsers ();

    User getUserById(final Integer userId);

    boolean addNewUser(final User user);

    boolean deleteUser(final Integer userId);
}
