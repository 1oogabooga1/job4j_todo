package ru.job4j.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("tasks", service.getAllTasks());
        return "tasks/list";
    }

    @GetMapping("/create")
    public String getCreationPage() {
        return "tasks/create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task) {
        service.createNewTask(task);
        return "redirect:/tasks/list";
    }

    @GetMapping("/newTasks")
    public String getNewTasks(Model model) {
        model.addAttribute("newTasks", service.getNewOrDoneTasks(false));
        return "tasks/newTasks";
    }

    @GetMapping("/doneTasks")
    public String getDoneTasks(Model model) {
        model.addAttribute("doneTasks", service.getNewOrDoneTasks(true));
        return "tasks/doneTasks";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var taskOptional = service.findById(id);
        if (taskOptional.isEmpty()) {
            model.addAttribute("message", "Задача не найдена");
            return "errors/404";
        }
        model.addAttribute("task", taskOptional.get());
        return "tasks/task";
    }

    @PostMapping("/edit/{id}")
    public String editTask(Model model, @PathVariable int id, @ModelAttribute Task task) {
        var isEdited = service.editTask(task, id);
        if (!isEdited) {
            model.addAttribute("message", "Ошибка при редактировании задачи");
            return "errors/404";
        }
        return "redirect:/tasks/list";
    }

    @GetMapping("/doneTask/{id}")
    public String doneTask(Model model, @PathVariable int id) {
        boolean result = service.doneTask(true, id);
        if (!result) {
            model.addAttribute("message", "The task is already done");
            return "errors/404";
        }
        return "redirect:/tasks/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        boolean result = service.deleteTask(id);
        if (!result) {
            model.addAttribute("message", "Некорректный номер задания");
            return "errors/404";
        }
        return "redirect:/tasks/list";
    }
}
