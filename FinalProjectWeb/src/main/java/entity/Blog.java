package entity;

import java.sql.Date;

public class Blog {
	private int blog_id;
	private String title;
	private String content1;
	private String content2;
	private String content3;
	private String content4;
	private String image;
	private Date date;
	public Blog() {
		super();
	}
	public Blog(int blog_id, String title, String content1, String content2, String content3, String content4,
			String image, Date date) {
		super();
		this.blog_id = blog_id;
		this.title = title;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
		this.content4 = content4;
		this.image = image;
		this.date = date;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}
	public String getContent4() {
		return content4;
	}
	public void setContent4(String content4) {
		this.content4 = content4;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Blog [blog_id=" + blog_id + ", title=" + title + ", content1=" + content1 + ", content2=" + content2
				+ ", concent3=" + content3 + ", content4=" + content4 + ", image=" + image + ", date=" + date + "]";
	}

	
}
