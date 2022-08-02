package com.kh.app.student.model.dto;

import java.time.LocalDateTime;

public class Student {
	private int no;
	private String name;
	private String tel;
	private LocalDateTime createdAt;//mybatis가 알아서 변환해주기 때문에 sql.Date안써도 됨
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int no, String name, String tel, LocalDateTime createdAt, LocalDateTime updatedAt,
			LocalDateTime deletedAt) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", tel=" + tel + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", deletedAt=" + deletedAt + "]";
	}
	
}
