package com.example.ghostvillageadmin.app.account.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAdminRepository extends JpaRepository<AccountAdmin, Long> {

}
