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
							<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Không
								phải thời gian đăng ký</h4>
						</div>
					</div>
					<div class="panel panel-default">
						<c:choose>
							<c:when test="${sessionScope.sv.ma_detai != null}">
								<div style="color: rgb(7, 132, 163);" class="panel-heading">
									<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
										tin đề tài</h4>
									<div class="table-responsive">
										<table style="text-align: center;"
											class="table table-bordered" id="dataTable" width="100%"
											cellspacing="0">
											<thead>
												<tr style="text-align: center;">
													<th style="text-align: center;">Đề tài</th>
													<th style="text-align: center;">Tên đề tài</th>
													<th style="text-align: center;">GVHD</th>
													<th style="text-align: center;">GVPB</th>
												</tr>
											</thead>
											<thead>
												<tr>
													<td>${sessionScope.dt.ma_detai}</td>
													<td>${sessionScope.dt.ten_detai}</td>
													<td>${sessionScope.gvhd.hoten}</td>
													<td><c:choose>
															<c:when test="${sessionScope.dt.gvpb == null}">
																<strong style="color: red;">Chưa phân GVPB</strong>
															</c:when>
															<c:when test="${sessionScope.dt.gvpb != null}">
																<strong>${sessionScope.gvpb.hoten }</strong>
															</c:when>
														</c:choose></td>
												</tr>
											</thead>
										</table>
									</div>
								</div>
								<div style="color: rgb(7, 132, 163);" class="panel-heading">
									<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
										tin trưởng nhóm</h4>
									<div class="table-responsive">
										<table id="Table1" border="0" cellpadding="0" cellspacing="0"
											width="100%" style="vertical-align: top;">

											<tr>
												<td style="width: 100px"><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label4"
													class="StudentInfoText_dl">Mã số sinh viên</span></td>
												<td align="right" class="StudentInfoText" style="width: 1px">:</td>
												<td style="width: 50%;"><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbMaso"
													class="StudentInfoDetails_dl">${sessionScope.truongnhom.id}</span></td>
												<td style="background: #b5b6b5; width: 1px;"></td>
											</tr>
											<tr>
												<td style="width: 100px"><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label2"
													class="StudentInfoText_dl">Họ và tên</span></td>
												<td align="right" class="StudentInfoText_dl"
													style="width: 1px">:</td>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbHoVaTen"
													class="StudentInfoDetails_dl">${sessionScope.truongnhom.hoten}</span></td>
												<td style="background: #b5b6b5; width: 1px;"></td>
											</tr>
											<tr>
												<td style="width: 100px"><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label2"
													class="StudentInfoText_dl">Email</span></td>
												<td align="right" class="StudentInfoText_dl"
													style="width: 1px">:</td>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbHoVaTen"
													class="StudentInfoDetails_dl">${sessionScope.truongnhom.email}</span></td>
												<td style="background: #b5b6b5; width: 1px;"></td>
											</tr>
											<tr>
												<td style="width: 100px"><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label5"
													class="StudentInfoText_dl">Giới tính</span></td>
												<td align="right" class="StudentInfoText_dl"
													style="width: 1px">:</td>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_blGioiTinh"
													class="StudentInfoDetails_dl"> <c:choose>
															<%-- Khi tham số color == 'red' --%>
															<c:when test="${sessionScope.truongnhom.gioitinh == 1}">
																<strong>Nữ</strong>
															</c:when>
															<%-- Khi tham số color == 'red' --%>
															<c:when test="${sessionScope.truongnhom.gioitinh == 0}">
																<strong>Nam</strong>
															</c:when>
														</c:choose>
												</span></td>
												<td style="background: #b5b6b5; width: 1px;"></td>
											</tr>
										</table>
									</div>
								</div>
							</c:when>
						</c:choose>
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

