package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {

    public User getUserByUserId(Integer userId);
}
