package com.yinnohs.igrol.itemlist.infrastrucutre.config;

import com.yinnohs.igrol.itemlist.aplication.usecases.impl.ItemListWhereUserIsParticipantUsesCasesImpl;
import com.yinnohs.igrol.itemlist.domain.service.ItemListService;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ItemListBeanConfiguration {
    private final ItemListService itemListService;
    private final UserService userService;

    @Bean
    public ItemListWhereUserIsParticipantUsesCasesImpl itemListWhereUserIsParticipantUsesCasesImpl(){
        return new ItemListWhereUserIsParticipantUsesCasesImpl(itemListService,userService);
    }
}