package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "CJ", "agaragã@gmail.com", new Date(), 2000.00, department);
		//Inserir no banco de dados através do SellerDao
		sellerDao.insert(newSeller);
		System.out.println("OK! ID = " + newSeller.getId());
	}

}
