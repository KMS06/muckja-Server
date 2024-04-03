package com.example.muckja.domain.user.domain.repositry;


import com.example.muckja.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
