package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.IAccountDAO;
import context.DBContext;
import entity.Account;

public class AccountDAOImpl extends DBContext implements IAccountDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Account> getAllAccount() {
		List<Account> list = new ArrayList<>();
		String query = "select * from Account";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Account get(int id) {
		String sql = "SELECT * FROM Account WHERE uID = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int checkAccountAdmin(int userID) {
		String query = "select isAdmin from Account where [uID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);

			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;

	}

	public int checkAccountShipper(int userID) {
		String query = "select isShipper from Account where [uID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);

			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;

	}

	public int checkAccountSeller(int userID) {
		String query = "select isSell from Account where [uID]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);

			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public Account login(String user, String pass) {
		String query = "select * from Account\n" + "where [user] = ?\n" + "and pass = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public Account checkAccountExist(String user) {
		String query = "select * from Account\n" + "where [user] = ?\n";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
		}
		return null;

	}

	@Override
	public Account checkAccountExistByUsernameAndEmail(String username, String email) {
		String query = "select * from Account where [user]=? and [email]=?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
		}
		return null;

	}

	public Account checkCode(String code) {
		String query = "select * from Account where code = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void singup(String user, String pass, String email, String code) {
		String query = "insert into Account values(?,?,0,0,0,?,null,?)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setString(4, code);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void loginGoogle(String user, String pass, String email, String image) {
		String query = "insert into Account values(?,?,0,0,0,?,?,null)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setString(4, image);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	@Override
	public void deleteAccount(String id) {
		String query = "delete from Account where uID= ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void insertAccount(String user, String pass, String isSell, String isAdmin, String isShipper, String email) {
		String query = "insert Account([user], pass, isSell, isAdmin, isShipper,email,images,code) values(?,?,?,?,?,?,null,null)";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, isSell);
			ps.setString(4, isAdmin);
			ps.setString(5, isShipper);
			ps.setString(6, email);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void editProfile(Account account) {
		String query = "update Account set [user]=? ,[pass]= ?,[email]= ?,[images]= ? where [uID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, account.getUser());
			ps.setString(2, account.getPass());
			ps.setString(3, account.getEmail());
			ps.setString(4, account.getImage());
			ps.setInt(5, account.getId());
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	public void updateSeller(int id) {
		String query = "update Account set isSell = 1  where [uID] = ?";
		try {
			conn = new DBContext().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
}
