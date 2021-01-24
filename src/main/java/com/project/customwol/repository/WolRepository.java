package com.project.customwol.repository;

import com.project.customwol.domain.User;
import com.project.customwol.domain.Wol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WolRepository extends JpaRepository<Wol, Long> {
   List<Wol> findAllByUser_id(Long user_id);
}
