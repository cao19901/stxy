package com.bootdo.clouddoadmin.config.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.autoconfigure.ConfigurationCustomizer;

@Configuration
public class MybatisConfig {
	
	@Bean
	public ConfigurationCustomizer mybatisConfigurationCustomizer(){
		return new ConfigurationCustomizer() {
			@Override
			public void customize(org.apache.ibatis.session.Configuration configuration) {
				configuration.setObjectWrapperFactory(new MapWrapperFactory());
			}
		};
	}
	
}