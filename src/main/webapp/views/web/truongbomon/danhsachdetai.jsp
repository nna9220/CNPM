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
										sách đề tài</h4>
								</div>
								<div class="panel-body">
									<table id="Table1" border="0" cellpadding="0" cellspacing="0"
										width="100%" style="vertical-align: top;">
										<tr>
											<th style="text-align: center;">Mã đề tài</th>
											<th style="text-align: center;">Tên đề tài</th>
											<th style="text-align: center;">Chuyên ngành</th>
											<th style="text-align: center;">Giảng viên PB</th>
										</tr>
										<tr>

											<c:forEach items="${detais}" var="dt" varStatus="STT">
												<c:choose>
													<c:when test="${dt.trangthai == 1}">
														<tr class="odd gradeX">
															<td style="text-align: center;" name="id">${dt.ma_detai}</td>
															<td style="text-align: center;">${dt.ten_detai}</td>
															<td style="text-align: center;"><c:choose>
																	<c:when test="${dt.ma_chuyennganh == 1}">
																		<strong>Công nghệ phần mềm</strong>
																	</c:when>
																	<c:when test="${dt.ma_chuyennganh == 2}">
																		<strong>An toàn thông tin</strong>
																	</c:when>
																	<c:when test="${dt.ma_chuyennganh == 3}">
																		<strong>Hệ thống thông tin</strong>
																	</c:when>
																</c:choose></td>
															<td style="text-align: center;"><c:choose>
																	<c:when test="${dt.gvpb == null}">

																		<button class="btn btn-primary">
																			<a
																				href="<c:url value='/phangvpb?id=${dt.ma_detai}'/>"
																				style="color: white">Phân GVPB</a>
																		</button>
																	</c:when>
																	<c:when test="${dt.ma_chuyennganh != null}">
																		<strong>${dt.gvpb}</strong>
																	</c:when>
																</c:choose></td>
														</tr>
													</c:when>
												</c:choose>

											</c:forEach>
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

