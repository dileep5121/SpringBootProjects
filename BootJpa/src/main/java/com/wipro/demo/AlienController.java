package com.wipro.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.demo.dao.AlienRepo;
import com.wipro.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addalien(Alien alien) {
		
		repo.save(alien);
		return "home.jsp";
	}
	@RequestMapping("/getAlien")
	public ModelAndView getalien(@RequestParam int aid) {
		
		ModelAndView mv=new ModelAndView("ShowAlien.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		
		
		System.out.println(repo.findByTech("java"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByTechSorted("java"));
		mv.addObject(alien);
		return mv;
	}
//	@RequestMapping("/aliens")
//	@ResponseBody
//	public String getaliens(){
//		
//	
//		return repo.findAll().toString();
//	}
//	@RequestMapping("/aliens/{aid}")
//	@ResponseBody
//	public String getAlien(@PathVariable("aid") int aid){
//		
//		
//	
//		return repo.findById(aid).toString();
//	}
	
//	@RequestMapping(path="/aliens",produces={"application/xml"})
	@RequestMapping(path="/aliens")
	@ResponseBody
	public List<Alien> getaliens(){
		
	
		return repo.findAll();
	}
	@GetMapping("/aliens/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid){
		
		
	
		return repo.findById(aid);
	}
	@PostMapping(path="/alien",consumes= {"application/json"})
	@ResponseBody
	public Alien addAlien(@RequestBody Alien alien){
		repo.save(alien);
		
	
		return alien;
	}
	@DeleteMapping("/alien/{aid}")
	@ResponseBody
	
	public String deleteAlien(@PathVariable int aid) {
		Alien a=repo.getOne(aid);
		repo.delete(a);
		
		return "deleted";
	}
	@PutMapping(path="/alien",consumes= {"application/json"})
	@ResponseBody
	public Alien saveOrUpdate(@RequestBody Alien alien){
		repo.save(alien);
		
	
		return alien;
	}

}
