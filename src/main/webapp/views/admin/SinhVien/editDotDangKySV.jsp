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

<title>Edit Khóa học</title>

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
				<c:url value="/editDKSV" var="edit"></c:url>
				<form role="form" action="${edit}" method="post"
					enctype="multipart/form-data"
					style="width: 70vw; margin-left: 25vw;">
					<div class="row">
						<div class="col-lg-6">
							<div class="p-5">
								<form class="user">
									<div class="form-group">
										<label>Đợt ${dk.id}: </label>
									</div>
									<input hidden value="${dk.id}" name="id"></input>
									<div class="form-group">
										<label>Ngày bắt đầu:</label> <input class="form-control"
											name="ngaybatdau" />
									</div>
									<div class="form-group">
										<label>Ngày kết thúc:</label> <input class="form-control"
											name="ngayketthuc" />
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