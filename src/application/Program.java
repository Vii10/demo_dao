package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//Test
		Department dp = new Department(1, "seller");
		System.out.println(dp);
		
		Seller seller = new Seller(21, "Bob","bobzola@gmail.com", new Date(), 3000.0, dp);
		
		/* Dessa forma o programa não conhece a implementação, mas sim a interface.
		 * É uma forma de realizar a injeção de dependências sem precisar explicitar
		 * a implementação */
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(seller);
	}

}
