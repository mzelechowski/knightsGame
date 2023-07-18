package com.malarska.knightsgame;
import com.malarska.knightsgame.controllers.TaskController;
import com.malarska.knightsgame.domain.PlayerInformation;
import com.malarska.knightsgame.service.KnightService;
import com.malarska.knightsgame.service.TaskService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
public class WebContextTest {

    @Mock
    KnightService knightService;

    @Mock
    TaskService taskService;

    @Mock
    PlayerInformation playerInformation;

    @InjectMocks
    TaskController taskController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void testCheckTask() throws Exception {

        mockMvc.perform(get("/checkTasks"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/knights"));
    }

    @Test
    public void contextLoads() {
    }

}
