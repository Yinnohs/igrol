package com.yinnohs.igrol.itemlist.infrastrucutre.config;

import com.yinnohs.igrol.itemlist.aplication.usecases.impl.ItemListUseCasesImpl;
import com.yinnohs.igrol.itemlist.domain.ports.in.ItemListService;
import com.yinnohs.igrol.itemlist.domain.ports.out.ProductAdapter;
import com.yinnohs.igrol.itemlist.domain.ports.out.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ItemListBeanConfiguration {
    private final ItemListService itemListService;
    private final UserAdapter userAdapter;
    private final ProductAdapter productAdapter;

    @Bean
    public ItemListUseCasesImpl itemListWhereUserIsParticipantUsesCasesImpl(){
        return new ItemListUseCasesImpl(itemListService, userAdapter, productAdapter);
    }
}
