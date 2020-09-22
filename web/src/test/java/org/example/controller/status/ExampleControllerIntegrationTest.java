package org.example.controller.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ExampleControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void whenGetRequestSentToController_thenReturnsStatusNotAcceptable() throws Exception {
		mvc.perform(get("/controller")).andExpect(status().isNotAcceptable());
	}

	@Test
	public void whenGetRequestSentToException_thenReturnsStatusForbidden() throws Exception {
		mvc.perform(get("/exception")).andExpect(status().isForbidden());
	}
}
