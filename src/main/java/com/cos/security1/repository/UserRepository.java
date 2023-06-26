package com.cos.security1.repository;

import com.cos.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository라는 어노테이션이 없어도 IoC된다. JpaRepository를 상속했기 때문에!
public interface UserRepository extends JpaRepository<User, Integer> {

}
