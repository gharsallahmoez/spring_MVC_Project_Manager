package tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import tp1.model.Departement;
import tp1.model.Employee;
import tp1.model.Projet;

@Repository
public class GestionImp implements IGestion{
	@Autowired 
	@Qualifier(value="dataSource")
	DataSource data;
	public void setData(DataSource data) {
		this.data = data;
	}
	
	
	public GestionImp() throws SQLException{
		super();
		
	}
	public List<Departement> getAllDepartement(){
		List<Departement> listDepartemnt = new ArrayList<Departement>();
		try {
			Connection con = data.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from departement");
		ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				Departement dep = new Departement(); 
				dep.setNumero(rs.getInt("num"));
				dep.setNom(rs.getString("nom"));
				listDepartemnt.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDepartemnt;
	}
	
	public List<Projet> getAllProjet(){
		List<Projet> listProjet = new ArrayList<Projet>();
		try {
			Connection con = data.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from projet");
		ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				Projet proj = new Projet(); 
				proj.setNumero(rs.getInt("num"));
				proj.setTitre(rs.getString("titre"));
				proj.setEtat(rs.getInt("etat"));
			
				proj.setDepartement(this.getDepartementByNum(rs.getInt("dept")));
				listProjet.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProjet;
	}
	
	public Departement getDepartementByNum(int id) {
		Departement dep = null;
		try {
			Connection con = data.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from departement where num = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dep = new Departement();
				dep.setNumero(rs.getInt("num"));
				dep.setNom(rs.getString("nom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dep;
	}
	
	public Projet getProjetByNum(int numproj) {
		Projet projet = null;
		try {
			Connection con = data.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from projet where num = ?");
		ps.setInt(1, numproj);
		ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				projet = new Projet();
				projet.setNumero(rs.getInt("num"));
				projet.setTitre(rs.getString("titre"));
				projet.setEtat(rs.getInt("etat"));
				projet.setDepartement(this.getDepartementByNum(rs.getInt("dept")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projet;
	}
	public List <Projet> getAllProjetByDept(int numdept){
		List<Projet> listProjet = new ArrayList<Projet>();
		try {
			Connection con = data.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from projet where dept = ?");
		ps.setInt(1, numdept);
		ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				Projet proj = new Projet(); 
				proj.setNumero(rs.getInt("num"));
				proj.setTitre(rs.getString("titre"));
				proj.setEtat(rs.getInt("etat"));
			
				proj.setDepartement(this.getDepartementByNum(rs.getInt("dept")));
				listProjet.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProjet;
		
	}
	public List<Employee> getAllEmployeByDept(int numdept){
		List<Employee> listEmployes = new ArrayList<Employee>();
		try {
			Connection con = data.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employe where dept = ?");
		ps.setInt(1, numdept);
		ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				Employee employee = new Employee(); 
				employee.setNumero(rs.getInt("num"));
				employee.setNom(rs.getString("nom"));
				employee.setFonction(rs.getString("fonction"));
				employee.setDepartement(this.getDepartementByNum(numdept));
				employee.setProjet(this.getProjetByNum(rs.getInt("proj")));
			
				listEmployes.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmployes;
	}
	public List<Employee> getAllEmployeByProjet(int numproj){
		List<Employee> listEmployes = new ArrayList<Employee>();
		try {
			Connection con = data.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employe where proj = ?");
		ps.setInt(1, numproj);
		ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				Employee employee = new Employee(); 
				employee.setNumero(rs.getInt("num"));
				employee.setNom(rs.getString("nom"));
				employee.setFonction(rs.getString("fonction"));
				employee.setDepartement(this.getDepartementByNum(rs.getInt("dept")));
				employee.setProjet(this.getProjetByNum(numproj));
				listEmployes.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmployes;
	}
	public void addProjet(Projet p) {
		try {
			Connection con = data.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into projet (num,titre,etat,dept) values (?,?,?,?)");
		stmt.setInt(1,p.getNumero());
		stmt.setString(2, p.getTitre());
		stmt.setInt(3, p.getEtat());
		stmt.setInt(4, p.getDepartement().getNumero());
		stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addEmploye(Employee e1) {
		try {
			Connection con = data.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into employe (num,nom,fonction,proj,dept) values (?,?,?,?,?)");
		stmt.setInt(1,e1.getNumero());
		stmt.setString(2, e1.getNom());
		stmt.setString(3, e1.getFonction());
		stmt.setInt(4, e1.getProjet().getNumero());
		stmt.setInt(5, e1.getDepartement().getNumero());
		stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteProjet(Projet p) {
		try {
			Connection con = data.getConnection();
		PreparedStatement stmt=con.prepareStatement("delete from projet where num=?");
		stmt.setInt(1,p.getNumero());
		stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteEmploye(Employee e) {
		try {
			Connection con = data.getConnection();
		PreparedStatement stmt=con.prepareStatement("delete from employe where num=?");
		stmt.setInt(1,e.getNumero());
		stmt.executeUpdate();

		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
	}
	public void updateProjet(Projet p) {
		try {
			Connection con = data.getConnection();
		PreparedStatement stmt=con.prepareStatement("update projet set titre = ? , etat = ? , dept = ? where num=?");
		stmt.setString(1,p.getTitre());
		stmt.setInt(2,p.getEtat());
		stmt.setInt(3,p.getDepartement().getNumero());
		stmt.setInt(4,p.getNumero());
		
		stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
