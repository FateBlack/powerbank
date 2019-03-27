package com.lz.power.repository;

import com.lz.power.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 白 on 2019/3/19.
 */
public interface UserRe extends JpaRepository<User, Integer> {
    List<User> findByPhoneAndPassword(String phone, String password);
}
