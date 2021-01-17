package com.project.customwol.service;

import com.project.customwol.domain.DataInfo;
import com.project.customwol.repository.DataInfoRepository;

public class DataInfoService {
    private final DataInfoRepository dataInfoRepository;

    public DataInfoService(DataInfoRepository dataInfoRepository) {
        this.dataInfoRepository = dataInfoRepository;
    }

    public Long add(DataInfo dataInfo) {
        // mac 중복 필터링
        dataInfoRepository.findByMac(dataInfo.getMac())
                .ifPresent(di -> {
                    throw new IllegalStateException("이미 존재하는 MAC 주소 입니다.");
                });

        dataInfoRepository.save(dataInfo);
        return dataInfo.getId();
    }

    public void remove(DataInfo dataInfo) {
        dataInfoRepository.remove(dataInfo.getId());
    }
}
