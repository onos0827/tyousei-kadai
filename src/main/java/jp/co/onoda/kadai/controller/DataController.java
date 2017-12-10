package jp.co.onoda.kadai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.onoda.kadai.form.DataForm;
import jp.co.onoda.kadai.service.DataService;

@Controller
public class DataController {

	@Autowired
	DataService service;

	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/view/input")
	public String input(Model model){
		model.addAttribute("inputForm", new DataForm());
		return "view/input";
	}

	@RequestMapping("/view/answer")
	public String answer(Model model){

		return "view/answer";
	}

    @PostMapping("/view/create")
	public String create(@ModelAttribute @Validated DataForm eventdata, Model model){
		service.create(eventdata);
		model.addAttribute("inputForm", new DataForm());
		return "view/input";
	}



}
