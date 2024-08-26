package com.study.spring_basics;

import com.study.spring_basics.beans.PrototypeBean;
import com.study.spring_basics.beans.UserDetails;
import com.study.spring_basics.configuration.BeanConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBasicsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testRequestScopedBean() throws Exception {
		mockMvc.perform(get("/request-scope"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Request Scoped Bean ID: RequestScope-")));

		// Simulate a second request to ensure a new bean instance is created
		mockMvc.perform(get("/request-scope"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Request Scoped Bean ID: RequestScope-")));
	}

	@Test
	public void testSessionScopedBean() throws Exception {

		// Create a new mock session
		MockHttpSession session = new MockHttpSession();

		// Perform first request and store the session-scoped bean ID
		mockMvc.perform(get("/session-scope").session(session))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Session ID: " + session.getId())))
				.andExpect(content().string(containsString("Bean ID: ")));

		// Perform a second request with the same session
		mockMvc.perform(get("/session-scope").session(session))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Session ID: " + session.getId())))
				.andExpect(content().string(containsString("Bean ID: ")));

		// Create a new session to ensure a new bean instance is created
		MockHttpSession newSession = new MockHttpSession();
		mockMvc.perform(get("/session-scope").session(newSession))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Session ID: " + newSession.getId())))
				.andExpect(content().string(not(containsString(session.getId())))); // Ensure it's a different session

	}

	@Test
	public void testPrototypeScope() {
		// Create the first application context
		AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		PrototypeBean bean1Context1 = context1.getBean(PrototypeBean.class);
		PrototypeBean bean2Context1 = context1.getBean(PrototypeBean.class);
		System.out.println("bean1Context1"+bean1Context1.hashCode());
		System.out.println("bean2Context1"+bean2Context1.hashCode());

		// Verify that within the same context, the bean is the same (singleton)
		assertNotEquals(bean1Context1.getBeanType(), bean2Context1.getBeanType(), "Beans in the same context should not have the same ID");



	}


	@Test
	public void testSingletonScopeInTwoContexts() {
		// Create the first application context
		AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		UserDetails bean1Context1 = context1.getBean(UserDetails.class);
		UserDetails bean2Context1 = context1.getBean(UserDetails.class);

		System.out.println("bean1Context1"+bean1Context1.hashCode());
		System.out.println("bean2Context1"+bean2Context1.hashCode());


		// Verify that within the same context, the bean is the same (singleton)
		assertEquals(bean1Context1.getUsername(), bean2Context1.getUsername(), "Beans in the same context should have the same ID");

		// Create the second application context
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		UserDetails bean1Context2 = context2.getBean(UserDetails.class);
		UserDetails bean2Context2 = context2.getBean(UserDetails.class);
		System.out.println("bean2Context2"+bean2Context2.hashCode());
		System.out.println("bean2Context2"+bean2Context2.hashCode());
		// Verify that within the second context, the bean is the same (singleton)
		assertEquals(bean1Context2.getUsername(), bean2Context2.getUsername(), "Beans in the same context should have the same ID");

		// Verify that beans from different contexts are not the same (different singletons)
		assertNotEquals(bean1Context1.getUsername(), bean1Context2.getUsername(), "Beans in different contexts should have different IDs");

		// Close the contexts
		context1.close();
		context2.close();
	}
}
