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
					<div class="panel panel-default"></div>

					<div class="panel panel-default">
						<c:choose>
							<c:when test="${sessionScope.USER.username!=null}">
								<c:choose>
									<c:when test="${sessionScope.sv.ma_detai==null}">
										<div style="color: rgb(7, 132, 163);" class="panel-heading">
											<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Danh
												sách đề tài</h4>
											<div class="table-responsive">
												<table style="text-align: center;"
													class="table table-bordered" id="dataTable" width="100%"
													cellspacing="0">
													<thead>
														<tr style="text-align: center;">
															<th style="text-align: center;">Đề tài</th>
															<th style="text-align: center;">Tên đề tài</th>
															<th style="text-align: center;">GVHD</th>
															<th style="text-align: center;">SV Đăng ký</th>
															<th style="text-align: center;">Đăng ký</th>
														</tr>
													</thead>
													<c:forEach items="${detais}" var="dt" varStatus="STT">
														<c:choose>
															<c:when test="${dt.soluongsinhviendangky<=1}">
																<tr style="text-align: center;" class="odd gradeX">
																	<td style="text-align: center;">${dt.ma_detai}</td>
																	<td style="text-align: center;">${dt.ten_detai}</td>
																	<td style="text-align: center;">${dt.gvhd}</td>
																	<td style="text-align: center;">${dt.soluongsinhviendangky}</td>
																	<td style="text-align: center;"><c:choose>
																			<c:when test="${dt.soluongsinhviendangky<1}">
																				<form action="svDKDT" method="post"
																					enctype="multipart/form-data">
																					<input hidden name="ma_sinhvien"
																						value="${sessionScope.info.id}"></input> <input
																						hidden name="truongnhom"
																						value="${sessionScope.info.id}"></input>
																					<button type="submit" name="ma_detai"
																						value="${dt.ma_detai}">Đăng ký</button>
																				</form>
																			</c:when>
																			<c:when test="${dt.soluongsinhviendangky>=1}">
																				<form action="wait" method="post"
																					enctype="multipart/form-data">
																					<input hidden name="ma_sinhvien"
																						value="${sessionScope.info.id}"></input> <input
																						hidden name="thanhvien"
																						value="${sessionScope.info.id}"></input>
																					<button class="btn btn-primary" type="submit" name="ma_detai"
																						value="${dt.ma_detai}">Đăng ký</button>
																				</form>
																			</c:when>
																		</c:choose></td>
																</tr>
															</c:when>
														</c:choose>
													</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</c:when>
									<c:when test="${sessionScope.sv.ma_detai != null}">
										<div style="color: rgb(7, 132, 163);" class="panel-heading">
											<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
												tin đề tài ${sessionScope.sv.statusdetai}</h4>
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
										<c:choose>
											<c:when test="${sessionScope.sv.statusdetai==1}">
												<div style="color: rgb(7, 132, 163);" class="panel-heading">
													<c:choose>
														<c:when
															test="${sessionScope.info.id != sessionScope.truongnhom.id}">
															<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
																tin trưởng nhóm</h4>
															<div class="table-responsive">
																<table id="Table1" border="0" cellpadding="0"
																	cellspacing="0" width="100%"
																	style="vertical-align: top;">

																	<tr>
																		<td style="width: 100px"><span
																			id="ctl00_ContentPlaceHolder1_ctl00_ctl00_ctl00_Label4"
																			class="StudentInfoText_dl">Mã số sinh viên</span></td>
																		<td align="right" class="StudentInfoText"
																			style="width: 1px">:</td>
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
																</table>
															</div>
														</c:when>
														<c:when
															test="${sessionScope.info.id == sessionScope.truongnhom.id}">
															<div style="color: rgb(7, 132, 163);"
																class="panel-heading">
																<h4
																	style="font-family: verdana; color: rgb(87, 87, 87);">Quản
																	lý nhóm</h4>
																<c:choose>
																	<c:when test="${sessionScope.nsv.thanhvien!=null}">
																		<div class="table-responsive">
																			<table style="text-align: center;"
																				class="table table-bordered" id="dataTable"
																				width="100%" cellspacing="0">
																				<thead>
																					<tr style="text-align: center;">
																						<th style="text-align: center;">Thành viên</th>
																						<th style="text-align: center;">Hành động</th>
																					</tr>
																				</thead>

																				<tr style="text-align: center;" class="odd gradeX">
																					<td style="text-align: center;">${nsv.thanhvien}</td>
																					<td style="text-align: center;">
																						<form action="thanhvienDKDT" method="post"
																							enctype="multipart/form-data">
																							<input hidden name="ma_sinhvien"
																								value="${sessionScope.info.id}"></input> <input
																								hidden name="thanhvien"
																								value="${sessionScope.info.id}"></input>
																							<button type="submit" name="ma_detai">Xóa</button>
																						</form>
																					</td>
																				</tr>
																				</tbody>
																			</table>
																		</div>

																	</c:when>
																	<c:when test="${sessionScope.nsv.thanhvien==null}">
																		<div class="table-responsive">
																			<table style="text-align: center;"
																				class="table table-bordered" id="dataTable"
																				width="100%" cellspacing="0">
																				<thead>
																					<tr style="text-align: center;">
																						<th style="text-align: center;">Thành viên
																							chờ xét duyệt</th>
																						<th style="text-align: center;">Hành động</th>
																					</tr>
																				</thead>
																				<c:forEach items="${listsv}" var="sv"
																					varStatus="STT">
																					<c:choose>
																						<c:when
																							test="${sv.ma_sinhvien!=sessionScope.truongnhom.id}">
																							<tr style="text-align: center;"
																								class="odd gradeX">
																								<td style="text-align: center;">${sv.ma_sinhvien}</td>
																								<td style="text-align: center;">
																									<form action="thanhvienDKDT" method="post"
																										enctype="multipart/form-data">
																										<input hidden name="ma_detai"
																											value="${sessionScope.nsv.ma_detai}"></input>
																										<button type="submit" name="ma_sinhvien"
																											value="${sv.ma_sinhvien}">Xác nhận</button>
																									</form>
																								</td>
																							</tr>
																						</c:when>
																					</c:choose>
																				</c:forEach>
																				</tbody>
																			</table>
																		</div>
																	</c:when>
																</c:choose>
															</div>
														</c:when>
													</c:choose>
												</div>
											</c:when>
											<c:when test="${sessionScope.sv.statusdetai==0}">
												<a>Chờ xét duyệt</a>
											</c:when>
										</c:choose>
									</c:when>
								</c:choose>
							</c:when>
							<c:when test="${sessionScope.USER.username==null}">
								<div class="panel-body">
									<div class="alert alert-warning">
										Vui lòng <a class="label label-warning" href="/DKDT/LoginWeb"
											data-toggle="modal">ĐĂNG NHẬP</a> vào hệ thống
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

