package ServicesImpl;

import java.io.File;
import java.util.List;

import DAO.IAccountDAO;
import DAOImpl.AccountDAOImpl;
import Services.AccountServices;
import entity.Account;

public class AccountServicesImpl implements AccountServices {
	IAccountDAO accountDAO = new AccountDAOImpl();

	@Override
	public List<Account> getAllAccount() {
		return accountDAO.getAllAccount();
	}

	@Override
	public int checkAccountAdmin(int userID) {
		return accountDAO.checkAccountAdmin(userID);
	}

	public int checkAccountShipper(int userID) {
		return accountDAO.checkAccountShipper(userID);
	}

	public int checkAccountSeller(int userID) {
		return accountDAO.checkAccountSeller(userID);
	}

	@Override
	public Account login(String user, String pass) {
		return accountDAO.login(user, pass);
	}

	@Override
	public Account checkAccountExist(String user) {
		return accountDAO.checkAccountExist(user);
	}

	@Override
	public Account checkAccountExistByUsernameAndEmail(String username, String email) {
		return accountDAO.checkAccountExistByUsernameAndEmail(username, email);
	}

	public Account checkCode(String code) {
		return accountDAO.checkCode(code);
	}

	@Override
	public void singup(String user, String pass, String email, String code) {
		accountDAO.singup(user, pass, email, code);
	}

	@Override
	public void deleteAccount(String id) {
		accountDAO.deleteAccount(id);
	}

	@Override
	public void editProfile(Account newAcccount) {
		Account oldAccount = accountDAO.get(newAcccount.getId());
		oldAccount.setUser(newAcccount.getUser());
		if (newAcccount.getImage() != null) {
			// XOA ANH CU DI
			String fileName = oldAccount.getImage();
			final String dir = "D:\\FinalProjectWeb";
			File file = new File(dir + "/account" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldAccount.setImage(newAcccount.getImage());
		}
		oldAccount.setPass(newAcccount.getPass());
		oldAccount.setEmail(newAcccount.getEmail());
		accountDAO.editProfile(oldAccount);
	}

	@Override
	public void insertAccount(String user, String pass, String isSell, String isAdmin, String isShipper, String email) {
		accountDAO.insertAccount(user, pass, isSell, isAdmin, isShipper, email);
	}

	@Override
	public void updateSeller(int id) {
		accountDAO.updateSeller(id);
	}

	@Override
	public void loginGoogle(String user, String pass, String email, String image) {
		accountDAO.loginGoogle(user, pass, email, image);
	}

}
