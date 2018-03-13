package com.ibreath;

import com.ibreath.config.SwaggerConfig;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@SuppressWarnings("EmptyClass")
@ContextConfiguration(classes = {IbreathApplication.class, SwaggerConfig.class})
@DirtiesContext
public class IbreathApplicationTests {

	@Test
	public void contextLoads() {
	}

}
