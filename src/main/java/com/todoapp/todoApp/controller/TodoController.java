package com.todoapp.todoApp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todoapp.todoApp.model.Todo;
import com.todoapp.todoApp.service.LoginService;
import com.todoapp.todoApp.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	@RequestMapping(value= "/list-todos", method=RequestMethod.GET)
	public String showTodo(ModelMap map)
	{
		String name = (String) map.get("name");
		map.put("todos",service.retrieveTodos(name));
		return "list-todos";
	}
	
	@RequestMapping(value= "/add-todo", method=RequestMethod.GET)
	public String addTodo(ModelMap map)
	{
		map.addAttribute("todo",new Todo(0,(String) map.get("name"),"",new Date(),false));
		return "Todo";
	}
	
	@RequestMapping(value= "/add-todo", method=RequestMethod.POST)
	public String showaddTodo(ModelMap map, Todo todo)
	{
		System.out.println("calling");
		service.addTodo((String) map.get("name"), todo.getDesc(), new Date(), false);	
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value= "/deletetodo", method=RequestMethod.GET)
	public String deleteTodo(ModelMap map,@RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
}