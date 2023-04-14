package ServicesImpl;

import java.util.List;

import DAO.IRequestDAO;
import DAOImpl.RequestDAOImpl;
import Services.RequestServices;
import entity.Request;

public class RequestServicesImpl implements RequestServices {
	IRequestDAO requestDAO = new RequestDAOImpl();

	@Override
	public void handleStatus(int rID) {
		requestDAO.handleStatus(rID);
	}

	@Override
	public void insertRequest(int sellID, int proID, String content, int status) {
		requestDAO.insertRequest(sellID, proID, content, status);
	}

	@Override
	public Request getRequestByProID(int proID) {
		// TODO Auto-generated method stub
		return requestDAO.getRequestByProID(proID);
	}

	@Override
	public List<Request> getAllRequestBySellID(int sellID) {
		// TODO Auto-generated method stub
		return requestDAO.getAllRequestBySellID(sellID);
	}

	@Override
	public List<Request> getAllRequest() {
		// TODO Auto-generated method stub
		return requestDAO.getAllRequest();
	}

	@Override
	public int countRequestBySellID(int sellID) {
		// TODO Auto-generated method stub
		return requestDAO.countRequestBySellID(sellID);
	}

	@Override
	public int countRequest() {
		// TODO Auto-generated method stub
		return requestDAO.countRequest();
	}

	@Override
	public Request getRequestByID(int id) {
		// TODO Auto-generated method stub
		return requestDAO.getRequestByID(id);
	}

	@Override
	public List<Request> getAllRequestByStatus(int status) {
		// TODO Auto-generated method stub
		return requestDAO.getAllRequestByStatus(status);
	}

	@Override
	public List<Request> getAllRequestBySellIDvStatus(int sID, int status) {
		// TODO Auto-generated method stub
		return requestDAO.getAllRequestBySellIDvStatus(sID, status);
	}

}
