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

<title>Account List</title>

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
					<h1 class="h3 mb-2 text-gray-800">Quản Lý Tài Khoản</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">

						<div class="card-body">
							<div class="table-responsive">
								<div class="text-right my-2">
									<a href="AddAccount" class="btn btn-primary btn-icon-split">
										<span class="icon text-white-50"> <i
											class="fas fa-plus"></i>
									</span> <span class="text">Thêm Account</span>
									</a>
								</div>
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Username</th>
											<th>Password</th>
											<th>Role</th>
											<th>Actions</th>
										</tr>
										<c:forEach items="${svList}" var="sv" varStatus="STT">
											<tr class="odd gradeX">
												<td>${sv.username}</td>
												<td>${sv.password}</td>
												<td><c:choose>
														<c:when test="${sv.roleid == 1}">
															<strong>Admin</strong>
														</c:when>
														<c:when test="${sv.roleid == 4}">
															<strong>Sinh viên</strong>
														</c:when>
														<c:when test="${sv.roleid == 2}">
															<strong>Giảng viên</strong>
														</c:when>
														<c:when test="${sv.roleid == 3}">
															<strong>Trưởng bộ môn</strong>
														</c:when>
													</c:choose></td>
												<td>
													<div class="text-center">
														<button class="btn btn-primary " type="button">
															<a href="<c:url value='/editAccount?id=${sv.username}'/>"
																style="color: white">Sửa</a>
														</button>
														<button class="btn btn-danger " type="button">
															<a
																href="<c:url value='/DeleteAccount?id=${sv.username}'/>"
																onclick="return confirm('Are you sure you want to delete Account ${sv.username}?')"
																style="color: white">Xóa</a>
														</button>
													</div>
												</td>
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