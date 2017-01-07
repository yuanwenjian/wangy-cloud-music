package com.yuanwj.repository;

import com.yuanwj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yuanwj on 2017/1/7.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
