/**
 * 
 */
package org.mdacc.rists.cghub.ws.api;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdacc.rists.cghub.ws.CgApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author djiao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CgApplication.class)
@WebIntegrationTest
public class SeqControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void findById_ShouldReturnFoundSeqEntry() throws Exception{
		String getSeqUrl = new StringBuilder()
				.append("/samples?search=")
				.append("analysisId:{aid}")
				.toString();
		
		String aid = "fdebfd6e-d046-4192-8b97-ac9f65dc2009";
		
		mockMvc.perform(get(getSeqUrl, aid))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andDo(print())
		.andReturn();		
		
	}

}
