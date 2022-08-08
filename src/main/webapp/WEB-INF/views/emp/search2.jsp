<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis실습</title>
<style>
div#emp-container{text-align:center;}
table.tbl-emp{
	margin:0 auto;
	border:1px solid; 
	border-collapse:collapse;
}
table.tbl-emp th, table.tbl-emp td{
	border:1px solid;
	padding:5px;
}
div#search-container{
	padding:15px 0;
}
table#tbl-search { margin:0 auto; }
table#tbl-search th,table#tbl-search td {padding:5px 15px; font-weight: normal; }
table#tbl-search td {text-align:left;}
</style>
</head>
<body>
<div id="emp-container">
	<h2>사원정보 </h2>
    <div id="search-container">
        <form name="empSearchFrm">
	        <table id="tbl-search">
	        	<tr>
	        		<th colspan="2">
		        		<select name="searchType">
			                <option value="">검색타입</option>
			                <!-- required여부를 판단할 value="" 반드시 있어야함.-->
			                <option value="emp_id" ${param.searchType eq 'emp_id' ? 'selected': ''}>사번</option>
			                <option value="emp_name" ${param.searchType eq 'emp_name' ? 'selected': ''}>사원명</option>
			                <option value="email" ${param.searchType eq 'email' ? 'selected': ''}>이메일</option>
			                <option value="phone" ${param.searchType eq 'phone' ? 'selected': ''}>전화번호</option>
			            </select>
			            <input type="search" name="searchKeyword" value="${param.searchKeyword}"/>  
	        		</th>
	        	</tr>
	        	<tr>
	        		<th>성별</th>
	        		<td>
	        			<!-- (input:radio[name=gender][value]#gender$+label[for=gender$])*2 -->
	        			<input type="radio" name="gender" id="gender1" value="남" ${param.gender eq '남' ? 'checked' : ''}/>
	        			<label for="gender1">남</label>
	        			<input type="radio" name="gender" id="gender2" value="여" ${param.gender eq '여' ? 'checked' : ''}/>
	        			<label for="gender2">여</label>
	        		</td>
	        	</tr>
	        	<!-- 급여기준 -->
			    <tr>
			        <th>급여</th>
			        <td>
			            <input type="number" name="salary" min="0" step="500000" value="${param.salary}"/>
			            <input type="radio" name="salaryCompare" id="salaryCompareGE" value='ge' ${param.gender eq 'ge' ? 'checked' : ''}/>
			            <label for="salaryCompareGE">이상</label>
			            <input type="radio" name="salaryCompare" id="salaryCompareLE" value='le'${param.gender eq 'le' ? 'checked' : ''}/>
			            <label for="salaryCompareLE">이하</label>
			        </td>
			    </tr>
	        	<tr>
	        		<th colspan="2">
	        			<input type="submit" value="검색" />
	        			<!-- type="reset"은 서버에서 날려준 상태(사용자 검색조건 선택된 상태)로 돌아감. -->
	        			<input type="button" onclick="location.href='${pageContext.request.contextPath}/emp/search2.do'" value="초기화" />
	        		</th>
	        	</tr>
	        </table>
        </form>
    </div>
	<table class="tbl-emp">
		<tr>
			<th></th><!-- 1부터 넘버링 처리 -->
			<th>사번</th>
			<th>사원명</th>
			<th>주민번호</th><!--뒷6자리는 ******처리-->
			<th>성별</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서코드</th>
			<th>직급코드</th>
			<th>급여레벨</th>
			<th>급여</th><!--원화기호, 세자리마다 콤마표시-->
			<th>보너스율</th><!--percent로 표시-->
			<th>매니져 사번</th>
			<th>입사일</th><!--날짜형식 yyyy/MM/dd-->
			<th>퇴사여부</th>
		</tr>
		<!-- 조회된 데이터가 있는 경우와 없는 경우를 분기처리 하세요 -->
		<c:if test="${empty list}">
			<tr>
				<td colspan="14">사원정보가 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty list}">
			<c:forEach items="${list}" var="emp" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${emp.id}</td>
					<td>${emp.empName}</td>
					<td>${fn:substring(emp.empNo, 0, 8)}******</td><!--뒷6자리는 ******처리-->
					<td>${emp.gender}</td>
					<td>${emp.email}</td>
					<td>${emp.phone}</td>
					<td>${emp.deptCode}</td>
					<td>${emp.jobCode}</td>
					<td>${emp.salLevel}</td>
					<td><fmt:formatNumber value="${emp.salary}" type="currency"/></td><!--원화기호, 세자리마다 콤마표시-->
					<td><fmt:formatNumber value="${emp.bonus}" type="percent"/> </td><!--percent로 표시-->
					<td>${emp.managerId}</td>
					<td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy/MM/dd"/></td><!--날짜형식 yyyy/MM/dd-->
					<td>${emp.quitYn}</td>
				</tr>
			</c:forEach>
			
		</c:if>
	</table>
</div>

</body>
</html>
