package com.project.customwol.repository;

import com.project.customwol.domain.DataInfo;

import java.util.Optional;

public class MemoryDataInfoRepository implements DataInfoRepository {
    @Override
    public DataInfo save(DataInfo dataInfo) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<DataInfo> findByMac(String mac) {
        return Optional.empty();
    }
}
