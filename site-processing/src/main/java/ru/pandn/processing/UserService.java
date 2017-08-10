package ru.pandn.processing;

import ru.pandn.model.User;
import ru.pandn.model.UserList;

public interface UserService {
    UserList getUsers ();
    User getUserById(final Integer userId);
}
