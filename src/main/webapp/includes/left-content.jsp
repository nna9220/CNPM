<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div id="left-content">
		<div class="col-md-3">
			<!-- Menu desktop -->
			<div id="desktop-menu">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 id="mobile_home">Danh Mục</h4>
					</div>
					<c:choose>
						<c:when test="${sessionScope.USER.username == null}">
							<a href="Home" class="list-group-item"> <img
								src="Content/public/images/house-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Trang Chủ
							</a>
							<a href="ListGiangVien" class="list-group-item "> <img
								src="Content/public/images/Teacher-icon.png" width="24"
								height="24" /> <span class="pull-right"> <i
									class="icon-chevron-right"></i></span> Thông tin giảng viên
							</a>
							<a href="ThongTinSinhVien" class="list-group-item "> <img
								src="Content/public/images/Student-3-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Thông tin sinh viên
							</a>
						</c:when>
						<c:when test="${sessionScope.role == 4}">
							<a href="Home" class="list-group-item"> <img
								src="Content/public/images/house-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Trang Chủ
							</a>
							<a href="ListGiangVien" class="list-group-item "> <img
								src="Content/public/images/Teacher-icon.png" width="24"
								height="24" /> <span class="pull-right"> <i
									class="icon-chevron-right"></i></span> Thông tin giảng viên
							</a>
							<a href="ThongTinSinhVien" class="list-group-item "> <img
								src="Content/public/images/Student-3-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Thông tin sinh viên
							</a>

							<a href="svDKDT" class="list-group-item "> <img
								src="Content/public/images/Student-3-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Đăng ký đề tài
							</a>
						</c:when>
						<c:when test="${sessionScope.role == 2}">
							<a href="Home" class="list-group-item"> <img
								src="Content/public/images/house-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Trang Chủ
							</a>
							<a href="ThongtinGiangvien" class="list-group-item "> <img
								src="Content/public/images/Teacher-icon.png" width="24"
								height="24" /> <span class="pull-right"> <i
									class="icon-chevron-right"></i></span> Thông tin giảng viên
							</a>
							<a
								href="<c:url value='/Dangkydetai?id=${sessionScope.info.id}'/>"
								class="list-group-item "> <img
								src="Content/public/images/Student-3-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Đăng ký đề tài
							</a>
							<a href="<c:url value='/hoidong?id=${sessionScope.info.id}'/>" class="list-group-item "> 
							<img
								src="Content/public/images/Student-3-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Hội đồng
							</a>
						</c:when>
						<c:when test="${sessionScope.role == 3}">
							<a href="Home" class="list-group-item"> <img
								src="Content/public/images/house-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Trang Chủ
							</a>
							<a href="ThongtinGiangvien" class="list-group-item "> <img
								src="Content/public/images/Teacher-icon.png" width="24"
								height="24" /> <span class="pull-right"> <i
									class="icon-chevron-right"></i></span> Thông tin giảng viên
							</a>
							<a href="Dangkydetai" class="list-group-item "> <img
								src="Content/public/images/Student-3-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Đăng ký đề tài
							</a>
							<a href="listDeTai" class="list-group-item "> <img
								src="Content/public/images/Student-3-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Phân giảng viên phản biện
							</a>
							<a href="<c:url value='/hoidong?id=${sessionScope.info.id}'/>" class="list-group-item "> 
							<img
								src="Content/public/images/Student-3-icon.png" width="24"
								height="24" /> <span class="pull-right"><i
									class="icon-chevron-right"></i></span> Hội đồng
							</a>
						</c:when>
					</c:choose>

				</div>
				<!-- /panel-default -->
				<!--============================Bench==================-->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 id="mobile_thongke">Thống kê</h4>
					</div>

					<a class="list-group-item"><img
						src="Content/public/images/user-group-icon (1).png" width="24"
						height="24" /> Lượt truy cập : <span class="badge">109534</span></a>
					<a style="text-decoration: underline;" data-toggle="modal"
						data-target="#who_online" title="Who is online ?"
						href="javascript:void();" class="list-group-item"><img
						src="Content/public/images/online-icon.png" width="24" height="24" />
						Đang trực tuyến: <span class="badge">3</span></a>
				</div>
			</div>
			<!-- Modal Who online -->
			<div class="modal fade" id="who_online" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Online Users</h4>
						</div>
						<div class="modal-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<td>STT</td>
										<td>Tên SV</td>
									</tr>
								</thead>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
			<!-- ########################### Form ###########################-->
			<!-- =========================Tìm kiếm box================================ -->

		</div>
	</div>
</body>