package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

//
public class SellerDaoJDBC implements SellerDao {

	// Dependencia com a conexção sem a necessidade de criar um objeto
	private Connection conn;

	// Construtor forcado para a conexão
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			//Iniciando o preparedstatement
			ps = conn.prepareStatement(
					//Configuração de pesquisa dentro do banco de dados
					"SELECT seller.* ,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.id = ?");
			
			//Passando id como parametro de filtragem
			ps.setInt(1, id);
			
			//Executando Query e guardando execução em uma ResultSet
			//Pode-se converter resultset em set
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//Se não retornar nenhum registro,
				//Essa condição será pulada
				
				//Chamando função para instanciar o departamento
				Department dep = Department(rs);
				
				//Chamando funão para instanciar o vendedor
				Seller seller = Seller(rs, dep);
				
				//Retorna um vendedor por id
				return seller;
			}
			
			//Se retornar nulo, então não havia vendedor com o id
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	private Seller Seller(ResultSet rs, model.entities.Department dep) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setDepartment(dep);
		return seller;
	}

	private Department Department(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
