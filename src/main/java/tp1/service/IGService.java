package tp1.service;

import java.util.List;

import tp1.model.Departement;
import tp1.model.Employee;
import tp1.model.Projet;

public interface IGService {
	
	public List<Departement> getAllDepartement();
	public List<Projet> getAllProjets();
	public List<Employee> getAllEmployeByDept(int numdept);
	public List <Projet> getAllProjetByDept(int numdept);
	public List<Employee> getAllEmployeByProjet(int numproj);
	public void addProjet(Projet p);
	public void updateProjet(Projet p);

	public void addEmploye(Employee e1);
	
	public Projet getProjetByNum(int numproj);
	public Departement getDepartementByNum(int id);
	
	public void deleteProjet(Projet p);
	public void deleteEmploye(Employee e);


}
