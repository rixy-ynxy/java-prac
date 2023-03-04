package com.rixy.javaproc.chat.chatbackend.api;

import org.junit.jupiter.api.Test;

// import java.net.URL;
// import java.nio.file.Paths;
// import java.util.stream.Stream;

// import javax.sql.DataSource;

// import org.dbunit.Assertion;
// import org.dbunit.DataSourceDatabaseTester;
// import org.dbunit.IDatabaseTester;
// import org.dbunit.dataset.csv.CsvDataSet;
// import org.junit.jupiter.api.Test;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class HelloApiTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void helloTest() throws Exception {
    mockMvc.perform(
      MockMvcRequestBuilders.get("/hello")
      .content("""
        {
          "name":"Rixy"
        }
      """)
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect((result) -> JSONAssert.assertEquals("""
        {
          "message": "Hello, world!"
        }
        """,
        result.getResponse().getContentAsString(),
        false));

  }
}
