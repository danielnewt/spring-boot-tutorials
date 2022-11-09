package com.example.restapi.exampleRestApi.greeting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GreetingController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class}) //excludeAutoConfiguration allows us to test without security enabled
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class GreetingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void index_shouldReturnMessage() throws Exception{
        this.mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")))
                .andDo(document("index"));
    }

    @Test
    public void greeting_shouldReturnDefaultMessage() throws Exception{
        this.mockMvc.perform(get("/greeting/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")))
                .andDo(document("greeting", responseFields(
                        fieldWithPath("id").description("The id of the greeting."),
                        fieldWithPath("content").description("The content of the greeting.")
                )));
    }

    @Test
    public void greeting_shouldReturnMessageWithName() throws Exception{
        var name = "Bobby";

        this.mockMvc.perform(get("/greeting/hello?name=" + name))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, " + name)))
                .andDo(document("greeting", responseFields(
                        fieldWithPath("id").description("The id of the greeting."),
                        fieldWithPath("content").description("The content of the greeting.")
                )));
    }
}
