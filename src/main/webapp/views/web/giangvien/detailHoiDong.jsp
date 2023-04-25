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
						<div style="color: rgb(7, 132, 163);" class="panel-heading">
							<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
								tin đề tài</h4>
							<div class="table-responsive">
								<table style="text-align: center;" class="table table-bordered"
									id="dataTable" width="100%" cellspacing="0">
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
											<td>${dt.ma_detai}</td>
											<td>${dt.ten_detai}</td>
											<td>${gvhd.hoten}</td>
											<td><c:choose>
													<c:when test="${dt.gvpb == null}">
														<strong style="color: red;">Chưa phân GVPB</strong>
													</c:when>
													<c:when test="${dt.gvpb != null}">
														<strong>${gvpb.hoten}</strong>
													</c:when>
												</c:choose></td>
										</tr>
									</thead>
								</table>
							</div>
						</div>
						<div style="color: rgb(7, 132, 163);" class="panel-heading">
							<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Giảng viên - Hội đồng</h4>
							<div class="table-responsive">
								<table style="text-align: center;" class="table table-bordered"
									id="dataTable" width="100%" cellspacing="0">
									<thead>
										<tr style="text-align: center;">
											<th style="text-align: center;">Giảng viên 1</th>
											<th style="text-align: center;">Giảng viên 2</th>
											<th style="text-align: center;">Giảng viên 3</th>
											<th style="text-align: center;">Giảng viên 4</th>
											<th style="text-align: center;">Giảng viên 5</th>
										</tr>
									</thead>
									<thead>
										<tr>
											<td>${gv1.hoten}
											<br>${gv1.email}
											</td>
											<td>${gv2.hoten}
											<br>${gv2.email}
											</td>
											<td>${gv3.hoten}
											<br>${gv3.email}
											</td>
											<td>${gv4.hoten}
											<br>${gv4.email}
											</td>
											<td>${gv5.hoten}
											<br>${gv5.email}
											</td>
										</tr>
									</thead>
								</table>
							</div>
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

