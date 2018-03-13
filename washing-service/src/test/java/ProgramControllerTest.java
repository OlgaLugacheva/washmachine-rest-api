import los.washmachine.ProgramController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ProgramControllerTest {
    @InjectMocks
    private ProgramController programController;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private MockMvc mockMvc;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(programController)
                .build();
    }

    @Test
    public void shouldSaveProgram() throws Exception {
        this.mockMvc
                .perform(
                        post("/api/wash/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"Gentle\",\"wheels\":\"1000\",\"temperature\":\"60\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$name", is("Gentle")))
                .andExpect(jsonPath("$wheels", is("1000")))
                .andExpect(jsonPath("$temperature", is("60")));
    }


    @Test
    public void shouldUpdateProgram() throws Exception {
        this.mockMvc
                .perform(
                        put("/api/wash/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"status\":\"Finished\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$status", is("Finished")));
    }

    @Test
    public void shouldGetEmptyList() throws Exception {
        this.mockMvc
                .perform(
                        get("/api/"))
                .andExpect(status().isOk());
    }
    @Test
    public void shouldDeleteProgram() throws Exception {
        this.mockMvc
                .perform(
                        post("/api/wash/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"Gentle\",\"wheels\":\"1000\",\"temperature\":\"60\"}"));
        this.mockMvc
                .perform(
                        delete("/api/wash/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"Gentle\",\"wheels\":\"1000\",\"temperature\":\"60\"}"));
    }
}