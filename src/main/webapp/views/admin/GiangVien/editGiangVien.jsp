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

<title>Edit Giang Vien</title>

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
											<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Thêm Giảng viên</h1>
					<div class="card shadow mb-4"
						style="width: 40vw; margin-left: 20vw; margin-right: 20vw;">

						<!-- Entries -->
						<div class="card-body">
							<c:url value="/editTeacher" var="edit"></c:url>
							<form role="form" action="${edit}" method="post"
								enctype="multipart/form-data" style="width: 75vw;">
								<div class="row">
									<div class="col-lg-6">
										<div class="p-5">
											<form class="user">
												<div class="form-group">
													<label>Teacher:</label> <input readonly
														class="form-control" value="${gv.id}" name="id" />
												</div>
												<div class="form-group">
													<label>Họ tên:</label> <input class="form-control"
														value="${gv.hoten}" name="hoten" />
												</div>
												<div class="form-group">
													<label>Ngày sinh:</label> <input placeholder="dd/mm/yy"
														class="form-control" value="${gv.ngaysinh}"
														name="ngaysinh" />
												</div>
												<div class="form-group">
													<label for="gioitinh" class="form-lablel">Giới
														tính:</label> <select
														class="custom-select custom-select-sm form-control form-control-sm"
														value="${gv.gioitinh}" name="gioitinh" id="gioitinh">
														<option value=0>Nam</option>
														<option value=1>Nữ</option>
													</select>
												</div>
												<div class="form-group">
													<label>Địa chỉ:</label> <input class="form-control"
														value="${gv.diachi}" name="diachi" />
												</div>
												<div class="form-group">
													<label>Số điện thoại:</label> <input
														placeholder="0.. or +84.." class="form-control"
														value="${gv.sdt}" name="sdt" />
												</div>
												<div class="form-group">
													<label>Email:</label> <input
														placeholder="id@student.hcmute.edu.vn"
														class="form-control" value="${gv.email}" name="email" />
												</div>
												<div class="text-right">
													<button type="submit" class="btn btn-primary">Sửa</button>
													<button type="reset" class="btn btn-danger">Huỷ</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</form>
						</div>
						</div>
						</div>
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