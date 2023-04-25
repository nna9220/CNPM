<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin Home</title>

<!-- Custom fonts for this template-->
<link href="templates/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="templates/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="/views/admin/includes/left-content.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form action="searchTeacher" method="get"
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input name="txt" type="text"
								class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="submit">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter">3+</span>
						</a> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">Thông báo</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-primary">
											<i class="fas fa-file-alt text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 12, 2019</div>
										<span class="font-weight-bold">A new monthly report is
											ready to download!</span>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-success">
											<i class="fas fa-donate text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 7, 2019</div>
										$290.29 has been deposited into your account!
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 2, 2019</div>
										Spending Alert: We've noticed unusually high spending for your
										account.
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Hiển thị tất cả thông báo</a>
							</div></li>


						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">
									${sessionScope.USER.username} </span> <img
								class="img-profile rounded-circle"
								src="templates/img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Tài
									khoản
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Cài đặt
									<div class="dropdown-divider"></div> <a class="dropdown-item"
									href="#" data-toggle="modal" data-target="#logoutModal"> <i
										class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
										Đăng xuất
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->


				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Đề tài: ${detai.ten_detai}</h1>

					<!-- DataTales Example -->

					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Mã GV</th>
											<th>Họ tên</th>
											<th>Chức vụ</th>
											<th>Địa chỉ</th>
											<th>Số điện thoại</th>
											<th>Email</th>
											<th>Chuyên ngành</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<c:forEach items="${gvList}" var="gv" varStatus="STT">
										<c:choose>
											<c:when
												test="${gv.id!=hd.giangvien1 && gv.id!=hd.giangvien2 && 
														gv.id!=hd.giangvien3 && gv.id!=hd.giangvien4 && 
														gv.id!=hd.giangvien5}">
												<tr class="odd gradeX">
													<td>${gv.id}</td>
													<td>${gv.hoten}</td>
													<td><c:choose>
															<c:when test="${gv.roleid == 2}">
																<strong>Giảng viên</strong>
															</c:when>
															<c:when test="${gv.roleid == 3}">
																<strong>Trưởng bộ môn</strong>
															</c:when>
														</c:choose></td>
													<td>${gv.diachi}</td>
													<td>${gv.sdt}</td>
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
													<td><c:choose>
															<c:when test="${hd == null}">
																<form action="taohoidong" method="post"
																	enctype="multipart/form-data">

																	<input hidden name="ma_detai" value="${detai.ma_detai}"></input>

																	<button class="btn btn-primary" type="submit"
																		name="ma_giangvien" value="${gv.id}">Chọn</button>
																</form>
															</c:when>
															<c:when test="${hd.soluong==1 }">
																<form action="taohoidong2" method="post"
																	enctype="multipart/form-data">

																	<input hidden name="ma_detai" value="${detai.ma_detai}"></input>

																	<button class="btn btn-primary" type="submit"
																		name="ma_giangvien" value="${gv.id}">Chọn2</button>
																</form>
															</c:when>
															<c:when test="${hd.soluong==2 }">
																<form action="taohoidong3" method="post"
																	enctype="multipart/form-data">

																	<input hidden name="ma_detai" value="${detai.ma_detai}"></input>

																	<button class="btn btn-primary" type="submit"
																		name="ma_giangvien" value="${gv.id}">Chọn3</button>
																</form>
															</c:when>
															<c:when test="${hd.soluong==3 }">
																<form action="taohoidong4" method="post"
																	enctype="multipart/form-data">

																	<input hidden name="ma_detai" value="${detai.ma_detai}"></input>

																	<button class="btn btn-primary" type="submit"
																		name="ma_giangvien" value="${gv.id}">Chọn4</button>
																</form>
															</c:when>
															<c:when test="${hd.soluong==4 }">
																<form action="taohoidong5" method="post"
																	enctype="multipart/form-data">

																	<input hidden name="ma_detai" value="${detai.ma_detai}"></input>

																	<button class="btn btn-primary" type="submit"
																		name="ma_giangvien" value="${gv.id}">Chọn5</button>
																</form>
															</c:when>
															<c:when test="${hd.soluong==5 }">
																<strong>Đủ số lượng GV</strong>
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
					</div>

					<h1 class="h3 mb-2 text-gray-800">Hội đồng</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Mã HĐ</th>
											<th>Giảng viên 1</th>
											<th>Giảng viên 2</th>
											<th>Giảng viên 3</th>
											<th>Giảng viên 4</th>
											<th>Giảng viên 5</th>
										</tr>
									</thead>
									<tr class="odd gradeX">
										<td>${hd.ma_hd}</td>
										<td>${gv1.hoten}</td>
										<td>${gv2.hoten}</td>
										<td>${gv3.hoten}</td>
										<td>${gv4.hoten}</td>
										<td>${gv5.hoten}</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>

			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<%@include file="/includes/footer.jsp"%>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll button and Logout Modal -->
	<%@include file="/views/admin/includes/scrl-btn-lgout-model.jsp"%>

</body>

</html>