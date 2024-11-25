package com.yinnohs.igrol;

import com.yinnohs.igrol.auth.infrastructure.configuration.RsaKeyConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfigProperties.class)
public class IgrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgrolApplication.class, args);
	}

}
