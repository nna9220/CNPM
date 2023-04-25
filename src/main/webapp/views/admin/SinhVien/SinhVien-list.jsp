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
				<%@include file="/views/admin/includes/header.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Danh sách sinh viên</h1>
					<div class="card shadow mb-4">

						<!-- Entries -->
						<div class="card-body">
							<div class="table-responsive">
								<div class="text-right my-2">
									<a href="AddStudent" class="btn btn-primary btn-icon-split">
										<span class="icon text-white-50"> <i
											class="fas fa-plus"></i>
									</span> <span class="text">Thêm sinh viên</span>
									</a>
								</div>
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Mã sinh viên</th>
											<th>Họ tên</th>
											<th>Giới tính</th>
											<th>Địa chỉ</th>
											<th>Email</th>
											<th>Mã chuyên ngành</th>
											<th>Thao tác</th>
										</tr>

										<c:forEach items="${svList}" var="sv" varStatus="STT">
											<tr class="odd gradeX">
												<td><a
													href="<c:url value='/detailStudent?id=${sv.id}'/>">${sv.id}</a></td>
												<td>${sv.hoten}</td>
												<td><c:choose>
														<%-- Khi tham số color == 'red' --%>
														<c:when test="${sv.gioitinh == 1}">
															<strong>Nữ</strong>
														</c:when>
														<%-- Khi tham số color == 'red' --%>
														<c:when test="${sv.gioitinh == 0}">
															<strong>Nam</strong>
														</c:when>
													</c:choose></td>
												<td>${sv.diachi}</td>
												<td>${sv.email}</td>
												<td><c:choose>
														<c:when test="${sv.ma_chuyennganh == 1}">
															<strong>Công nghệ phần mềm</strong>
														</c:when>
														<c:when test="${sv.ma_chuyennganh == 2}">
															<strong>An toàn thông tin</strong>
														</c:when>
														<c:when test="${sv.ma_chuyennganh == 3}">
															<strong>Hệ thống thông tin</strong>
														</c:when>
													</c:choose></td>
												<td>
													<div class="text-center">
														<button class="btn btn-primary " type="button">
															<a href="<c:url value='/editStudent?id=${sv.id}'/>"
																style="color: white">Sửa</a>
														</button>
														<button class="btn btn-danger " type="button">
															<a href="<c:url value='/DeleteStudent?id=${sv.id}'/>"
																onclick="return confirm('Are you sure you want to delete student ${sv.id}?')"
																style="color: white">Xoá</a>
														</button>
													</div>
												</td>
												<br>
											</tr>
										</c:forEach>

									</thead>
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