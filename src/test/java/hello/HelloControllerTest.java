package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getHelloGet() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hi").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Greetings from my first springboot controller")));
	}

	@Test
	public void getHelloPost() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/hi").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Greetings from my first springboot controller")));
	}

	@Test
	public void getHelloPostParam() throws Exception {
		String nameParam = "Fabio";
		mvc.perform(MockMvcRequestBuilders.post("/hi").param("name", nameParam).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo(String.join(", ", "Greetings from my first springboot controller", nameParam))));
	}
}
