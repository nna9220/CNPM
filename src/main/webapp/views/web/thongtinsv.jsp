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
									Vui lòng <a class="label label-warning" href="LoginWeb"
										data-toggle="modal">ĐĂNG NHẬP</a> vào hệ thống
								</div>
							</div>
						</c:when>
						<c:when test="${sessionScope.USER.username!= null}">
							<table id="Table1" border="0" cellpadding="0" cellspacing="0"
								width="100%" style="vertical-align: top;">

								<tr>
									<td>
										<div class="panel panel-default">
											<div style="color: rgb(7, 132, 163);" class="panel-heading">
												<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
													tin Sinh viên</h4>
											</div>
											<div class="panel-body">
												<table id="Table1" border="0" cellpadding="0"
													cellspacing="0" width="100%" style="vertical-align: top;">

													<tr>
														<td style="width: 100px"><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label4"
															class="StudentInfoText_dl">Mã số sinh viên</span></td>
														<td align="right" class="StudentInfoText"
															style="width: 1px">:</td>
														<td style="width: 50%;"><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbMaso"
															class="StudentInfoDetails_dl">${sessionScope.info.id}</span></td>
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
															class="StudentInfoDetails_dl">${sessionScope.info.hoten}</span></td>
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
																	<c:when test="${sessionScope.info.gioitinh == 1}">
																		<strong>Nữ</strong>
																	</c:when>
																	<%-- Khi tham số color == 'red' --%>
																	<c:when test="${sessionScope.info.gioitinh == 0}">
																		<strong>Nam</strong>
																	</c:when>
																</c:choose>
														</span></td>
														<td style="background: #b5b6b5; width: 1px;"></td>
													</tr>
													<tr>
														<td style="width: 100px"><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label29"
															class="StudentInfoText_dl">Loại sinh viên</span></td>
														<td align="right" class="StudentInfoText_dl"
															style="width: 1px">:</td>
														<td><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbLoaiSinhVien"
															class="StudentInfoDetails_dl">Chính thức</span></td>
														<td style="background: #b5b6b5; width: 1px;"></td>
													</tr>
													<tr>
														<td><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label30"
															class="StudentInfoText_dl">Tình trạng học</span></td>
														<td align="right" class="StudentInfoText_dl">:</td>
														<td><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbTinhTrangHoc"
															class="StudentInfoDetails_dl">Còn học</span></td>
														<td style="background: #b5b6b5; width: 1px;"></td>
													</tr>

												</table>
											</div>
											<div style="color: rgb(7, 132, 163);" class="panel-heading">
												<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
													tin Khóa học</h4>
											</div>
											<div class="panel-body">
												<table id="Table1" border="0" cellpadding="0"
													cellspacing="0" width="100%" style="vertical-align: top;">

													<tr>
														<td style="width: 100px"><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label4"
															class="StudentInfoText_dl">Khóa</span></td>
														<td align="right" class="StudentInfoText"
															style="width: 1px">:</td>
														<td style="width: 50%;"><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbMaso"
															class="StudentInfoDetails_dl">
																${sessionScope.kh.ten_khoahoc}</span></td>
														<td style="background: #b5b6b5; width: 1px;"></td>
													</tr>
													<tr>
														<td style="width: 100px"><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label2"
															class="StudentInfoText_dl">Niên khóa</span></td>
														<td align="right" class="StudentInfoText_dl"
															style="width: 1px">:</td>
														<td><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbHoVaTen"
															class="StudentInfoDetails_dl">${sessionScope.kh.nienkhoa}</span></td>
														<td style="background: #b5b6b5; width: 1px;"></td>
													</tr>

													<tr>
														<td style="width: 100px"><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label29"
															class="StudentInfoText_dl">CTDT</span></td>
														<td align="right" class="StudentInfoText_dl"
															style="width: 1px">:</td>
														<td><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbLoaiSinhVien"
															class="StudentInfoDetails_dl">${sessionScope.kh.ctdt}</span></td>
														<td style="background: #b5b6b5; width: 1px;"></td>
													</tr>
													<tr>
														<td><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label30"
															class="StudentInfoText_dl">Lớp sinh viên</span></td>
														<td align="right" class="StudentInfoText_dl">:</td>
														<td><span
															id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbTinhTrangHoc"
															class="StudentInfoDetails_dl">${sessionScope.kh.lopsinhvien}</span></td>
														<td style="background: #b5b6b5; width: 1px;"></td>
													</tr>

												</table>
											</div>
										</div>
									</td>
									<td align="left" valign="top" style="width: 55%;">
										<table id="Table23" border="0" cellpadding="3" cellspacing="1"
											width="97%">

											<tr>
												<td colspan="3" height="25" bgcolor="#FF3300"
													class="titlebar">THÔNG TIN LIÊN LẠC</td>
											</tr>
											<tr>
												<td colspan="3"><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label69"
													style="color: Red;">* Thông tin liên lạc của sinh
														viên:</span></td>
											</tr>
											<tr>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label39"
													class="StudentInfoText_dl">Điện thoại</span></td>
												<td align="right" class="StudentInfoText_dl">:</td>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbDienThoai"
													class="StudentInfoDetails_normal_dl">${sessionScope.info.sdt}</span></td>
											</tr>
											<tr>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label40"
													class="StudentInfoText_dl">Di động</span></td>
												<td align="right" class="StudentInfoText_dl">:</td>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbDiDong"
													class="StudentInfoDetails_normal_dl">${sessionScope.info.sdt}</span></td>
											</tr>
											<tr>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label41"
													class="StudentInfoText_dl">Email</span></td>
												<td align="right" class="StudentInfoText_dl">:</td>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbEmail"
													class="StudentInfoDetails_normal_dl">${sessionScope.info.email}</span></td>
											</tr>
											<tr>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label42"
													class="StudentInfoText_dl">Địa chỉ</span></td>
												<td align="right" class="StudentInfoText_dl">:</td>
												<td><span
													id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_lbKiCanLienLac"
													class="StudentInfoDetails_normal_dl">${sessionScope.info.diachi}</span></td>
											</tr>

										</table>
									</td>
								</tr>
							</table>
						</c:when>

					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div id="footer">
			<hr />
			<h5 class="text-center text-danger">Khoa Công nghệ Thông tin -
				Đại học Sư phạm Kỹ thuật TP. Hồ Chí Minh</h5>
			<h5 class="text-center text-danger">Số 1, Võ Văn Ngân, Thủ
				Đức,TP. Hồ Chí Minh</h5>
		</div>
	</div>
</body>
</html>

