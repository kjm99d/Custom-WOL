package com.project.customwol;

import com.project.customwol.repository.DataInfoRepository;
import com.project.customwol.repository.MemberRepository;
import com.project.customwol.repository.MemoryDataInfoRepository;
import com.project.customwol.repository.MemoryMemberRepository;
import com.project.customwol.service.DataInfoService;
import com.project.customwol.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public DataInfoService dataInfoService() {
        return new DataInfoService(dataInfoRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DataInfoRepository dataInfoRepository() {
        return new MemoryDataInfoRepository();
    }
}
