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

<title>Add Giang Vien</title>

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
				<%@include file="/views/admin/includes/header.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Thêm Giảng viên</h1>
					<div class="card shadow mb-4"
						style="width: 40vw; margin-left: 20vw; margin-right: 20vw;">

						<!-- Entries -->
						<div class="card-body">

							<form role="form" action="AddTeacher" method="post"
								enctype="multipart/form-data" style="width: 75vw;">
								<div class="row">
									<div class="col-lg-6">
										<div class="p-5">
											<form class="user">
												<div class="form-group">
													<label>Mã giảng viên:</label> <input
														class="form-control form-control-user"
														placeholder="Nhập mã giảng viên ..." name="ma_giangvien">
												</div>
												<div class="form-group">
													<label>Họ và tên:</label> <input
														class="form-control form-control-user" name="hoten">
												</div>
												<div class="form-group">
													<label>Ngày sinh:</label> <input
														class="form-control form-control-user"
														placeholder="dd / mm / yy ..." name="ngaysinh">
												</div>
												<div class="form-group">
													<label for="gioitinh">Giới tính:</label> <select
														class="custom-select custom-select-sm form-control form-control-sm"
														name="gioitinh" id="gioitinh">
														<option value=0>Nam</option>
														<option value=1>Nữ</option>
													</select>
												</div>
												<div class="form-group">
													<label>Địa chỉ:</label> <input
														class="form-control form-control-user" name="diachi">
												</div>
												<div class="form-group">
													<label>Số điện thoại:</label> <input
														class="form-control form-control-user"
														placeholder="0.. | +84.. " name="sdt">
												</div>
												<div class="form-group">
													<label>Email:</label> <input
														class="form-control form-control-user"
														placeholder="name@hcmute.edu.vn" name="email">
												</div>
												<div class="form-group">
													<label for="roleid">Chức vụ:</label> <select
														class="custom-select custom-select-sm form-control form-control-sm"
														name="roleid" id="roleid">
														<option value=2>Giảng Viên</option>
														<option value=3>Trưởng bộ môn</option>
													</select>
												</div>
												<div class="form-group">
													<label for="ma_chuyennganh">Chuyên ngành:</label> <select
														class="custom-select custom-select-sm form-control form-control-sm"
														name="ma_chuyennganh" id="ma_chuyennganh">
														<option value=1>Công nghệ phần mềm</option>
														<option value=2>An toàn thông tin</option>
														<option value=3>Hệ thống thông tin</option>
													</select>
												</div>
												<div class="text-center">
													<button class="btn btn-primary " type="submit">Lưu</button>
													<button class="btn btn-danger " type="reset">Xoá</button>
												</div>
										</div>
									</div>
								</div>
							</form>

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