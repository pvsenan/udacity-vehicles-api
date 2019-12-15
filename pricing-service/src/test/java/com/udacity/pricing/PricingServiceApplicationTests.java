package com.udacity.pricing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {


	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllPrices() throws Exception{
		mockMvc.perform(get("/prices/"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}

	@Test
	public void getOnePrice() throws Exception{
		MvcResult result = mockMvc.perform(get("/prices/1"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		Assert.assertNotNull(result.getResponse().toString());
	}
}
