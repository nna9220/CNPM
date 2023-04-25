<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Thêm khóa học</title>

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
					<h1 class="h3 mb-2 text-gray-800">Thêm khoá học</h1>

					<!-- Entries -->
					<div class="card shadow mb-4"
						style="width: 40vw; margin-left: 25vw; margin-right: 20vw;">
						<div class="card-body">

							<form role="form" action="addKhoaHoc" method="post"
								enctype="multipart/form-data" style="width: 75vw;">
								<div class="row">
									<div class="col-lg-6">
										<div class="p-5">
											<form class="user">
												<div class="form-group">
													<label>Tên khóa học:</label> <input
														class="form-control form-control-user" name="ten_khoahoc">
												</div>
												<div class="form-group">
													<label>Niên khóa:</label> <input
														class="form-control form-control-user" name="nienkhoa">
												</div>
												<div class="form-group">
													<label>Năm bắt đầu:</label> <input
														class="form-control form-control-user" name="nam_nhaphoc">
												</div>
												<div class="form-group">
													<label>Năm kết thúc:</label> <input
														class="form-control form-control-user" name="nam_ketthuc">
												</div>
												<div class="form-group">
													<label>Lớp sinh viên:</label> <input
														class="form-control form-control-user" name="lopsinhvien">
												</div>
												<div class="form-group">
													<label>Chương trình đào tạo:</label> <input
														class="form-control form-control-user" name="ctdt">
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