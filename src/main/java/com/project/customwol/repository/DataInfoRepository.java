package com.project.customwol.repository;

import com.project.customwol.domain.DataInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface DataInfoRepository {
    DataInfo save(DataInfo dataInfo);
    void remove(Long id);
    Optional<DataInfo> findByMac(String mac);
}
