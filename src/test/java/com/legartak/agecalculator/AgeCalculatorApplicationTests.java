package com.legartak.agecalculator;

import com.legartak.agecalculator.persistence.domain.PersonEntity;
import com.legartak.agecalculator.persistence.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class AgeCalculatorApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void beforeEachTest() {
		PersonEntity joe = new PersonEntity(999, "Joe", "Biden", LocalDate.parse("2001-09-11"));
		personRepository.save(joe);
	}

	@Test
	public void shouldReturnOurText() throws Exception {
		this.mockMvc
				.perform(get("/user/999"))
				.andDo(print())
				.andExpect(content().string(containsString("{\"name\":\"Joe\",\"surname\":\"Biden\",\"age\":21}")));
	}
}
