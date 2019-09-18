package com.seu.athorization.repository;

import com.seu.athorization.model.LoginToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginTokenRepository extends JpaRepository<LoginToken, String> {
}
