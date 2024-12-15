package com.yinnohs.igrol.itemlist.infrastrucutre.config;

import com.yinnohs.igrol.itemlist.aplication.usecases.impl.ItemListUseCasesImpl;
import com.yinnohs.igrol.itemlist.domain.service.ItemListService;
import com.yinnohs.igrol.product.domain.service.ProductService;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ItemListBeanConfiguration {
    private final ItemListService itemListService;
    private final UserService userService;
    private final ProductService productService;

    @Bean
    public ItemListUseCasesImpl itemListWhereUserIsParticipantUsesCasesImpl(){
        return new ItemListUseCasesImpl(itemListService,userService,productService);
    }
}
