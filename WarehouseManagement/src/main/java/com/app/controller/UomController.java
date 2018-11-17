package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator validator;

	@RequestMapping("/register")
	public String regUom(ModelMap map) {
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}

	@RequestMapping(value = "/save",method = POST)
	public String saveUom(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		validator.validate(uom, errors);
		if(!errors.hasErrors()) { //no errors
			Integer id=service.saveUom(uom) ;
			map.addAttribute("message","Uom created with Id:"+id);
			map.addAttribute("uom",new Uom()) ;
		}

		return "UomRegister";
	}

	@RequestMapping(value = "/update",method = POST)
	public String updateUom(@ModelAttribute Uom uom, ModelMap map) {
		service.updateUom(uom);
		map.addAttribute("message","Uom updated");
		return "UomData";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam Integer id,ModelMap map) {
		service.deleteUom(id);
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("uoms",uoms);
		map.addAttribute("message", "Uom '"+id+"' deleted successfully");
		return "UomData";
	}

	@RequestMapping("/edit")
	public String editUom(@RequestParam Integer id, ModelMap map) {
		Uom ob=service.getOneUom(id);
		map.addAttribute("uom",ob);
		return "UomEdit";
	}

	@RequestMapping("/getAll")
	public String getAllUoms(ModelMap map) {
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("uoms",uoms);
		return "UomData";
	}
}
