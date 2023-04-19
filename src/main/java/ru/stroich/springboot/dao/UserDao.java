package ru.stroich.springboot.dao;


import ru.stroich.springboot.model.User;

import java.util.List;

public interface UserDao {

    //Метод для сохранения пользователя
    public void saveUser(User user);

    //Метод для обновления пользователя
    public void updateUser (User user);

    //Метод для получения пользователя по id
    public User getUserById (Long id);

    //Метод для удаления пользователя
    public void deleteUser(Long id);

    //Метод для получения списка пользователей
    public List<User> getAllUsers();

}
