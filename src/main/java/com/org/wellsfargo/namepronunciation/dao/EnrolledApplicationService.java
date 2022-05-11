package com.org.wellsfargo.namepronunciation.dao;

import com.org.wellsfargo.namepronunciation.entity.EnrolledApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolledApplicationService extends JpaRepository<EnrolledApplication, String> {
}

