<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 실습</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
<style>
div#student-container{text-align:center;}
table.tbl-student{margin:10px auto;border:1px solid; border-collapse:collapse;}
table.tbl-student th,table.tbl-student td{
	border:1px solid;
	padding:5px;
	line-height: 2em; /*input태그로 인해 cell이 높이가 길어져 border 두줄현상방지 */
}
table.tbl-student th{text-align:right;}
table.tbl-student td{text-align:left;}
table.tbl-student tr:last-of-type td:first-child{text-align:center;}
</style>
</head>
<body>
	<div id="student-container">
		<h2>학생정보 검색</h2>
		<p>등록된 학생수는 <span id="totalCount">${totalCount}</span>명입니다.</p>
		<form name="studentSearchFrm">
			<table class="tbl-student">
				<tr>
					<th>학생번호</th>
					<td>
						<input type="number" name="no" value="" required/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="검색" />
					</td>
				</tr>
			</table>
		</form>
		<hr />
		<h2>학생 정보 수정</h2>
        <form name="studentUpdateFrm">
            <table class="tbl-student">
                <tr>
                    <th>학생번호</th>
                    <td>
                        <input type="number" name="no" required readonly/>
                    </td>
                </tr>
                <tr>
                    <th>학생이름</th>
                    <td>
                        <input type="text" name="name" required/>
                    </td>
                </tr>
                <tr>
                    <th>학생전화번호</th>
                    <td>
                        <input type="tel" name="tel"  required/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" value="수정" onclick="updateStudent();"/>
                        <input type="button" value="삭제" onclick="deleteStudent();" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<script>
		/* 실습문제풀이 */	
		const deleteStudent = () => {
		const frm = document.studentUpdateFrm;
		
		$.ajax({
			url : '${pageContext.request.contextPath}/student/studentDelete.do',
			data : {no : frm.no.value},
			method : 'POST',
			success(response){
				console.log(response);
				alert(response.msg);
				location.reload();
			},
			error : console.log
		});
	}
	
	const updateStudent = () => {
		const frm = document.studentUpdateFrm;
		const student = {
			no : frm.no.value,
			name : frm.name.value,
			tel : frm.tel.value
		};
		console.log(student);
		
		$.ajax({
			url : '${pageContext.request.contextPath}/student/studentUpdate.do',
			data : student,
			method : 'POST',
			success(response){
				console.log(response);
				alert(response.msg);
				frm.reset();
			},
			error : console.log
		});
		
	};
	
		document.studentSearchFrm.addEventListener('submit', (e)=>{
			e.preventDefault();
			const no = e.target.no.value;
			$.ajax({
//				url: '${pageContext.request.contextPath}/student/student.do',
				url: '${pageContext.request.contextPath}/student/studentMap.do',
				data: {no},
				success(student){
					console.log(student);
					const frm = document.studentUpdateFrm;
					if(student){
						const {no, name, tel} = student;
						frm.no.value = no;
						frm.name.value = name;
						frm.tel.value = tel;
					}
					else{
						alert('해당하는 학생이 없습니다.');
						frm.reset();
					}
				},
				error: console.log
			});
		});
	</script>
</body>
</html>
