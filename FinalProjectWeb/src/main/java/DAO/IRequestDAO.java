package DAO;

import java.util.List;

import entity.Request;

public interface IRequestDAO {

	void handleStatus(int rID);

	void insertRequest(int sellID, int proID, String content, int status);

	Request getRequestByProID(int proID);

	List<Request> getAllRequestBySellID(int sellID);

	List<Request> getAllRequest();

	int countRequestBySellID(int sellID);

	int countRequest();

	Request getRequestByID(int id);

	List<Request> getAllRequestByStatus(int status);

	List<Request> getAllRequestBySellIDvStatus(int sID, int status);

}
