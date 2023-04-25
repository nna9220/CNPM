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

<title>Detail Teacher</title>

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
				<c:url value="/editStudent" var="edit"></c:url>
				<div>
					<form role="form" action="${edit}" method="post"
						enctype="multipart/form-data"
						style="width: 78vw; margin-left: 3vw; background: white; border: 1px solid blue; color: black">
						<label style="width: 78vw; background: #0040ff; color: white">Thông
							tin giảng viên</label>
						<table border="1" style="text-align: center;">
							<tr>
								<th style="width: 8vw; text-align: center;">Mã giảng viên</th>
								<th style="width: 10vw; text-align: center;">Họ tên</th>
								<th style="width: 16vw; text-align: center;">Email</th>
								<th style="width: 8vw; text-align: center;">SĐT</th>
								<th style="width: 16vw; text-align: center;">Địa chỉ</th>
								<th style="width: 10vw; text-align: center;">Chuyên ngành</th>
								<th style="width: 10vw; text-align: center;">Chức vụ</th>
							</tr>
							<tr>
								<td>${sv.id}</td>
								<td>${sv.hoten}</td>
								<td>${sv.email}</td>
								<td>${sv.sdt}</td>
								<td>${sv.diachi}</td>
								<td><c:choose>
										<c:when test="${sv.ma_chuyennganh == 1}">
										Công nghệ phần mềm
									</c:when>
										<c:when test="${sv.ma_chuyennganh == 2}">
										An toàn thông tin
									</c:when>
										<c:when test="${sv.ma_chuyennganh == 3}">
										Hệ thống thông tin
									</c:when>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${sv.roleid == 2}">
										Giảng viên
									</c:when>
										<c:when test="${sv.roleid == 3}">
										Trưởng bộ môn
									</c:when>
									</c:choose></td>
							</tr>
						</table>

					</form>
					<form
						style="width: 78vw; margin-left: 3vw; margin-top: 1vw; background: white; border: 1px solid blue; color: black">
						<label style="width: 78vw; background: #0040ff; color: white">Thông
							tin Account</label>
						<table border="1" style="text-align: center;">
							<tr>
								<th style="width: 39vw; text-align: center;">Account</th>
								<th style="width: 39vw; text-align: center;">Mật khẩu</th>
							</tr>
							<tr>
								<td><c:choose>
										<c:when test="${acc.username == null}">
											<a href="<c:url value='/addAccTeacher?id=${sv.id}'/>">Tạo
												Account</a>
										</c:when>
										<c:when test="${acc.username!= null}">
										${acc.username}
									</c:when>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${acc.username == null}">
										Chưa có
									</c:when>
										<c:when test="${acc.username != null}">
										${acc.password}
									</c:when>
									</c:choose></td>
							</tr>
						</table>
					</form>
					<form role="form" action="${edit}" method="post"
						enctype="multipart/form-data"
						style="width: 78vw; margin-left: 3vw; margin-top: 1vw; background: white; border: 1px solid blue; color: black">
						<label style="width: 78vw; background: #0040ff; color: white">Thông
							tin đề tài</label>
						<table border="1" style="text-align: center;">
							<thead>
								<tr>
									<th style="width: 26vw; text-align: center;">Đề tài</th>
									<th style="width: 26vw; text-align: center;">Tên đề tài</th>
									<th style="width: 26vw; text-align: center;">Trạng thái</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dts}" var="dt" varStatus="STT">
									<tr class="odd gradeX">
										<td>${dt.ma_detai}</td>
										<td>${dt.ten_detai}</td>
										<td><c:choose>
												<c:when test="${dt.trangthai==0}">
													<strong style="color: red">Chưa duyệt</strong>
												</c:when>
												<c:when test="${dt.trangthai == 1}">
													<strong style="color: green">Đã duyệt</strong>
												</c:when>
											</c:choose></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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

	<!-- End of Page Wrapper -->

	<!-- Scroll button and Logout Modal -->
	<%@include file="/views/admin/includes/scrl-btn-lgout-model.jsp"%>
</body>

</html>