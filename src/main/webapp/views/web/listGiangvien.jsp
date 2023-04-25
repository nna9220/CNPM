<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/includes/header.jsp"%>
<html>
<body>
	<div id="wrapper">
		<div class="container">
			<div class="row">
				<div id="left-content">
					<%@include file="/includes/left-content.jsp"%>
				</div>

				<div class="col-md-9">
					<ol class="breadcrumb">
						<li><a href="Home">Home</a></li>
						<c:choose>
							<c:when test="${sessionScope.USER.username== null}">
								<div id="login-area">
									<button onclick="location.href='LoginWeb';"
										style="background-color: blue; color: white">
										Đăng Nhập <img src="Content/public/images/Login-icon.png"
											width="24" height="24" />
									</button>
								</div>
							</c:when>
							<c:when test="${sessionScope.USER.username!= null}">
								<div id="login-area">
									<button onclick="location.href='LoginWeb';"
										style="background-color: blue; color: white">
										Đăng xuất <img src="Content/public/images/Login-icon.png"
											width="24" height="24" />
									</button>
								</div>
							</c:when>
						</c:choose>

					</ol>
					<div id="left-content"></div>
					<c:choose>
						<c:when test="${sessionScope.USER.username== null}">
							<div class="panel-body">
								<div class="alert alert-warning">
									Vui lòng <a class="label label-warning" href="/DKDT/LoginWeb"
										data-toggle="modal">ĐĂNG NHẬP</a> vào hệ thống
								</div>
							</div>
						</c:when>
						<c:when test="${sessionScope.USER.username!= null}">
							<div class="panel panel-default">
								<div style="color: rgb(7, 132, 163);" class="panel-heading">
									<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Danh
										sách giảng viên</h4>
								</div>
								<div class="panel-body">
									<table id="Table1" border="0" cellpadding="0" cellspacing="0"
										width="100%" style="vertical-align: top;">

										<tr>
											<td><c:forEach items="${sessionScope.gv}" var="gv"
													varStatus="STT">
													<tr class="odd gradeX">
														<td>${gv.id}</td>
														<td>${gv.hoten}</td>
														<td>${gv.email}</td>
														<td><c:choose>
																<c:when test="${gv.ma_chuyennganh == 1}">
																	<strong>Công nghệ phần mềm</strong>
																</c:when>
																<c:when test="${gv.ma_chuyennganh == 2}">
																	<strong>An toàn thông tin</strong>
																</c:when>
																<c:when test="${gv.ma_chuyennganh == 3}">
																	<strong>Hệ thống thông tin</strong>
																</c:when>
															</c:choose></td>
													</tr>
												</c:forEach></td>
										</tr>
									</table>
								</div>
							</div>
						</c:when>
					</c:choose>
				</div>
			</div>

		</div>
	</div>

</body>
</html>
<%@include file="/includes/footer.jsp"%>

