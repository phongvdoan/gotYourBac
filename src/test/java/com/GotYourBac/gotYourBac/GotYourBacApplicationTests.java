package com.GotYourBac.gotYourBac;

import com.GotYourBac.gotYourBac.controllers.UserController;
import com.GotYourBac.gotYourBac.models.ApplicationUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class GotYourBacApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserController userController;

	@Test
	void contextLoads() {
//		assertThat();
	}

	//Test homepage rendering
	@Test
	public void shouldHaveHomePage() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h2>Welcome to GotYourBAC</h2>")));
	}

	@Test
	public void shouldHaveRegistrationPage() throws Exception {
		this.mockMvc.perform(get("/registration"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h2>Register new user</h2>")));
	}



}
