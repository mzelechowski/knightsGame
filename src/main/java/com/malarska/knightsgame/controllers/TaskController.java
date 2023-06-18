package com.malarska.knightsgame.controllers;

import com.malarska.knightsgame.domain.Knight;
import com.malarska.knightsgame.domain.Task;
import com.malarska.knightsgame.service.KnightService;
import com.malarska.knightsgame.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Queue;

@Controller
public class TaskController {

    @Autowired
    KnightService knightService;

    @Autowired
    TaskService taskService;

    @RequestMapping("assignTask")
        public String assignQuest(@RequestParam("knightId")  Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        List<Task> notStartedTasks = taskService.getAllNotStartedTasks();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedTasks", notStartedTasks);
        return "assignTask";
    }

    @RequestMapping(value = "/assignTask", method = RequestMethod.POST)
    public String assignTask(Knight knight) {
        knightService.updateKnight(knight);
        Task task = knight.getTask();
        if(task!=null)
            taskService.update(task);
        return "redirect:/knights";
    }
}
