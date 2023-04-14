package entity;

public class Request {
	private int id;
	private int sellID;
	private int proID;
	private String content;
	private int status;

	public Request() {
		super();
	}

	public Request(int id, int sellID, int proID, String content, int status) {
		super();
		this.id = id;
		this.sellID = sellID;
		this.proID = proID;
		this.content = content;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSellID() {
		return sellID;
	}

	public void setSellID(int sellID) {
		this.sellID = sellID;
	}

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", sellID=" + sellID + ", proID=" + proID + ", content=" + content + ", status="
				+ status + "]";
	}

}
