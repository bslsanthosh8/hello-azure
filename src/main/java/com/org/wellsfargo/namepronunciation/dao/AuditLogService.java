package com.org.wellsfargo.namepronunciation.dao;

import com.org.wellsfargo.namepronunciation.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogService extends JpaRepository<AuditLog, String> {
}

