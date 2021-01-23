package com.project.customwol.repository;

import com.project.customwol.domain.Wol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WolRepository extends JpaRepository<Wol, Long> {
}
