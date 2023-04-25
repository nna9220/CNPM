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
					<h1 class="h3 mb-2 text-gray-800">Quản Lý Đề Tài</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">

						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr style="text-align: center;">
											<th>Tên đề tài</th>
											<th>Chuyên ngành</th>
											<th>Giảng viên hướng dẫn</th>
											<th>Giảng viên phản biện</th>
											<th>Trạng thái</th>
											<th>Hành động</th>
											<th>Hội đồng</th>
										</tr>
									</thead>
									<c:forEach items="${detai}" var="dt" varStatus="STT">
										<tr style="text-align: center;">
											<td>${dt.ten_detai}</td>
											<td><c:choose>
													<c:when test="${dt.ma_chuyennganh == 1}">
														<strong>Công nghệ phần mềm</strong>
													</c:when>
													<c:when test="${dt.ma_chuyennganh == 2}">
														<strong>An toàn thông tin</strong>
													</c:when>
													<c:when test="${dt.ma_chuyennganh == 3}">
														<strong>Hệ thống thông tin</strong>
													</c:when>
												</c:choose></td>
											<td>${dt.gvhd}</td>
											<td><c:choose>
													<c:when test="${dt.gvpb == null}">
														<strong style="color: red;">Chưa phân GVPB</strong>
													</c:when>
													<c:when test="${dt.gvpb != null}">
														<strong style="color: green;">${dt.gvpb }</strong>
													</c:when>
												</c:choose></td>
											<td><c:choose>
													<c:when test="${dt.trangthai==0}">
														<strong style="color: red;">Chưa duyệt</strong>
													</c:when>
													<c:when test="${dt.trangthai == 1}">
														<strong style="color: green;">Đã duyệt</strong>
													</c:when>
												</c:choose></td>
											<td><c:choose>
													<c:when test="${dt.trangthai==0}">
														<c:url value="/listDetai" var="access"></c:url>
														<form action="${access}" method="post"
															enctype="multipart/form-data">
															<button class="btn btn-primary" type="submit"
																name="ma_detai" value="${dt.ma_detai}">Duyệt</button>
														</form>
														<button class="btn btn-danger" type="button">
															<a href="<c:url value='/DeleteDetai?id=${dt.ma_detai}'/>"
																onclick="return confirm('Are you sure you want to delete Đề tài ${dt.ten_detai}?')"
																style="color: white">Xoá</a>
														</button>
													</c:when>
													<c:when test="${dt.trangthai == 1}">
														<button class="btn btn-danger " type="button">
															<a href="<c:url value='/DeleteDetai?id=${dt.ma_detai}'/>"
																onclick="return confirm('Are you sure you want to delete Đề tài ${dt.ten_detai}?')"
																style="color: white">Xoá</a>
														</button>
													</c:when>
												</c:choose></td>
											<td>
												<button class="btn btn-danger " type="button">
													<a href="<c:url value='/taohoidong?id=${dt.ma_detai}'/>"
														style="color: white">Tạo hội đồng</a>
												</button>
											</td>
										</tr>
									</c:forEach>
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