package com.kh.app.student.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	private int no;
	private String name;
	private String tel;
	private LocalDateTime createdAt;//mybatis가 알아서 변환해주기 때문에 sql.Date안써도 됨
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
	
	//0803 lombok도입. 기본생성자부터 toString 작성한거 삭제함
	
}
