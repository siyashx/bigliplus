package com.biglikuryer.bigliplus.dao.admin;

import com.biglikuryer.bigliplus.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
