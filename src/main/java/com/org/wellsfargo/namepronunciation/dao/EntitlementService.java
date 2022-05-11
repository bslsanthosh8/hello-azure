package com.org.wellsfargo.namepronunciation.dao;

import com.org.wellsfargo.namepronunciation.entity.Entitlement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntitlementService extends JpaRepository<Entitlement, String> {
}
