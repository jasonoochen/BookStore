package bookstore.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Book implements Serializable {
	private static final long serialVersionUID = -3019927257853432614L;
	private int id;
	private String name;
	private String description;
	private int grade;
	private float purchasePrice;
	private float sellingPrice;
	private String image;
	private String instruction;
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	private String isbn;
	private String bookConcern;
	private Date publishingDate;
	private String author;
	private String auhtoIntroduction;
//	private List<BookChapter> chapters = new ArayList<>(0);
//	
//	
//	public List<BookChapter> getChapters() {
//		return chapters;
//	}
//	public void setChapters(List<BookChapter> chapters) {
//		this.chapters = chapters;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public float getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookConcern() {
		return bookConcern;
	}
	public void setBookConcern(String bookConcern) {
		this.bookConcern = bookConcern;
	}
	public Date getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuhtoIntroduction() {
		return auhtoIntroduction;
	}
	public void setAuhtoIntroduction(String auhtoIntroductioon) {
		this.auhtoIntroduction = auhtoIntroductioon;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
