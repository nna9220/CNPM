<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/includes/header.jsp"%>
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
							<c:when test="${sessionScope.USER.username==null}">
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
					<div class="well-sm"></div>
					<div class="panel panel-default">
						<div style="color: rgb(7, 132, 163);" class="panel-heading">
							<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
								tin giảng viên</h4>
						</div>
						<div class="panel-body">
							<table id="Table1" border="0" cellpadding="0" cellspacing="0"
								width="100%" style="vertical-align: top;">

								<tr>
									<td style="width: 100px"><span
										id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label4"
										class="StudentInfoText_dl">Email</span></td>
									<td align="right" class="StudentInfoText" style="width: 1px">:</td>
									<td style="width: 70%;"><span
										id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbMaso"
										class="StudentInfoDetails_dl">${sessionScope.info.email}</span></td>
									<td style="background: #b5b6b5; width: 1px;"></td>
								</tr>
								<tr>
									<td style="width: 100px"><span
										id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label2"
										class="StudentInfoText_dl">Họ và tên</span></td>
									<td align="right" class="StudentInfoText_dl" style="width: 1px">:</td>
									<td><span
										id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbHoVaTen"
										class="StudentInfoDetails_dl">${sessionScope.info.hoten}</span></td>
									<td style="background: #b5b6b5; width: 1px;"></td>
								</tr>

								<tr>
									<td style="width: 100px"><span
										id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label29"
										class="StudentInfoText_dl">Chuyên ngành</span></td>
									<td align="right" class="StudentInfoText_dl" style="width: 1px">:</td>
									<td><span
										id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbLoaiSinhVien"
										class="StudentInfoDetails_dl"> <c:choose>
												<c:when test="${sessionScope.info.ma_chuyennganh == 1}">
													<strong>Công nghệ phần mềm</strong>
												</c:when>
												<c:when test="${sessionScope.info.ma_chuyennganh == 2}">
													<strong>An toàn thông tin</strong>
												</c:when>
												<c:when test="${sessionScope.info.ma_chuyennganh == 3}">
													<strong>Hệ thống thông tin</strong>
												</c:when>
											</c:choose>
									</span></td>
									<td style="background: #b5b6b5; width: 1px;"></td>
								</tr>
								<tr>
									<td><span
										id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label30"
										class="StudentInfoText_dl">Chức vụ</span></td>
									<td align="right" class="StudentInfoText_dl">:</td>
									<td><span
										id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbTinhTrangHoc"
										class="StudentInfoDetails_dl"> <c:choose>
												<c:when test="${sessionScope.info.roleid == 2}">
													<strong>Giảng viên</strong>
												</c:when>
												<c:when test="${sessionScope.info.roleid == 3}">
													<strong>Trưởng bộ môn</strong>
												</c:when>
											</c:choose>
									</span></td>
									<td style="background: #b5b6b5; width: 1px;"></td>
								</tr>

							</table>
						</div>
					</div>

					<ol class="breadcrumb">
						<li><a href="Home">Home</a></li>

					</ol>
					<div class="panel panel-default" id="thongke_right">
						<div class="panel-heading">
							<h4 id="mobile_thongke">Thống kê</h4>
						</div>
						<a class="list-group-item"><img
							src="Content/public/images/user-group-icon (1).png" width="24"
							height="24" /> Lượt truy cập : <span class="badge"></span></a> <a
							style="text-decoration: underline;" data-toggle="modal"
							data-target="#who_online" title="Who is online ?"
							href="javascript:void();" class="list-group-item"><img
							src="Content/public/images/online-icon.png" width="24"
							height="24" /> Đang trực tuyến: <span class="badge"></span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="/includes/footer.jsp"%>

