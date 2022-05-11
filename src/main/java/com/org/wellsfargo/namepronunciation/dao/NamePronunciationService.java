package com.org.wellsfargo.namepronunciation.dao;

import com.org.wellsfargo.namepronunciation.entity.NamePronunciation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NamePronunciationService extends JpaRepository<NamePronunciation, Integer> {
}
