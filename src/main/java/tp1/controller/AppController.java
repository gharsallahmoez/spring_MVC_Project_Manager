package tp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp1.model.Departement;
import tp1.model.Employee;
import tp1.model.Projet;
import tp1.service.IGService;

@Controller
public class AppController {
@Autowired
IGService service;

public void setService(IGService service) {
	this.service = service;
}

@RequestMapping(value="/home", method = RequestMethod.GET)
public String Departement(Model m ) {
	List<Departement> LD = service.getAllDepartement();
	
	m.addAttribute("deps",LD);
	return "home";
}
@RequestMapping(value = "/employes/dept/{num}", method = RequestMethod.GET)
public String getAllEmployesByDept(Model model, @PathVariable("num") int num) {
	List<Employee> employeeList = service.getAllEmployeByDept(num);
	Departement departement = service.getDepartementByNum(num);
	model.addAttribute("departement",departement);
model.addAttribute("employesDept",employeeList);
return "employes";
}


@RequestMapping(value = "/projets/{num}", method = RequestMethod.GET)
	public String getAllProjets(Model model, @PathVariable("num") int numDep) {
	List <Projet> LP = service.getAllProjetByDept(numDep);
	Departement departement = service.getDepartementByNum(numDep);
	model.addAttribute("departement",departement);
	model.addAttribute("projets",LP);
	return "projets";
}


@RequestMapping(value = "/employes/proj/{num}", method = RequestMethod.GET)
public String getAllEmployesByProj(Model model, @PathVariable("num") int num) {

	List<Employee> employeeList = service.getAllEmployeByProjet(num);
	
	Projet projet = service.getProjetByNum(num);
	model.addAttribute("projet",projet);
	
model.addAttribute("employesProj",employeeList);
return "employeByProj";
}

@RequestMapping(value="/ajoutProjet", method = RequestMethod.GET)
public String addProjet(Model model) {
	Projet projet = new Projet() ; 
	List<Departement> listD = service.getAllDepartement(); 
	model.addAttribute("projet", projet);
	model.addAttribute("departements", listD);
	return ("addProjet");
}
@RequestMapping(value="saveProjet", method = RequestMethod.POST)
public String saveProjet(Model model, @ModelAttribute("projet") Projet p) {
	service.addProjet(p);
	return ("redirect:/home");
}

@RequestMapping(value="/ajoutEmploye", method = RequestMethod.GET)
public String addEmploye(Model model) {
	Employee employee = new Employee();
	List<Departement> listD = service.getAllDepartement(); 
	List<Projet> listP = service.getAllProjets(); 
	model.addAttribute("projets", listP);
	model.addAttribute("departements", listD);
	model.addAttribute("employe", employee);
	return ("addEmploye");
}


@RequestMapping(value = "/deleteProjet/{num}", method = RequestMethod.GET)
public String deleteProjet(Model model, @PathVariable("num") int num) {

	Projet p = service.getProjetByNum(num);
	service.deleteProjet(p);

	
return ("redirect:/home");
}

@RequestMapping(value = "/deleteEmploye/{num}", method = RequestMethod.GET)
public String deleteEmploye(Model model, @PathVariable("num") int num) {

	//Employee p = service.get(num);
//	service.deleteEmploye(p);

	
return ("redirect:/home");
}

@RequestMapping(value = "/updateProjet/{num}", method = RequestMethod.GET)
public String getProjet(Model model, @PathVariable("num") int num) {
	List<Departement> listD = service.getAllDepartement(); 

	Projet p = service.getProjetByNum(num);
	model.addAttribute("projet", p);
	model.addAttribute("departements", listD);
return ("updateProjet");
}

@RequestMapping(value="updateProject", method = RequestMethod.POST)
public String updateProjet(Model model, @ModelAttribute("projet") Projet p) {
	service.updateProjet(p);
	return ("redirect:/home");
}


}