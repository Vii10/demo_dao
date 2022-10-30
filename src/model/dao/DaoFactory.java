package model.dao;

import model.dao.impl.SellerDaoJDBC;

//Classe responsável por instanciar os DAOS
public class DaoFactory {

	// Operações estáticas para criar os DAOS
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	/* A classe irá expor o tipo da interface, mas internamente
	 * ela vai instanciar uma implementação. Assim não é necessário 
	 * expor a implementação, deixando só a interface */
		
	}
}
