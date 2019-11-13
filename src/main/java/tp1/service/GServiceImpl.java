package tp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp1.dao.IGestion;
import tp1.model.Departement;
import tp1.model.Employee;
import tp1.model.Projet;

@Service
public class GServiceImpl implements IGService{
@Autowired 
IGestion dao;

public void setDao(IGestion dao) {
	this.dao = dao;
}
public List<Departement> getAllDepartement(){
	return dao.getAllDepartement();
}
public List<Projet> getAllProjets(){
	return dao.getAllProjet();
}
public List<Employee> getAllEmployeByDept(int numdept){
	return dao.getAllEmployeByDept(numdept);
}
public List <Projet> getAllProjetByDept(int numdept)
{
	return dao.getAllProjetByDept(numdept);
}


public List<Employee> getAllEmployeByProjet(int numproj){
	return dao.getAllEmployeByProjet(numproj);
}
public void addProjet(Projet p) {
	dao.addProjet(p);
}
public void addEmploye(Employee e1) {
	dao.addEmploye(e1);
}


public Projet getProjetByNum(int numproj) {
	return dao.getProjetByNum(numproj);
}
public Departement getDepartementByNum(int id) {
	return dao.getDepartementByNum(id);
}

public void deleteProjet(Projet p) {
	dao.deleteProjet(p);
}
public void deleteEmploye(Employee e) {
	dao.deleteEmploye(e);
}
public void updateProjet(Projet p) {
	dao.updateProjet(p);
}

}
