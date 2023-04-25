<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/includes/header.jsp"%>
<body>
	<div id="wrapper">
		<div class="container">
			<div class="row">
				<div id="left-content">
					<%@include file="/includes/left-content.jsp"%>
				</div>

				<div class="col-md-9">
					<ol class="breadcrumb">
						<li><a href="Home">Home</a></li>
						<c:choose>
							<c:when test="${sessionScope.USER.username==null}">
								<div id="login-area">
									<button onclick="location.href='LoginWeb';"
										style="background-color: blue; color: white">
										Đăng Nhập <img src="Content/public/images/Login-icon.png"
											width="24" height="24" />
									</button>
								</div>
							</c:when>
							<c:when test="${sessionScope.USER.username!= null}">
								<div id="login-area">
									<button onclick="location.href='LoginWeb';"
										style="background-color: blue; color: white">
										Đăng xuất <img src="Content/public/images/Login-icon.png"
											width="24" height="24" />
									</button>
								</div>
							</c:when>
						</c:choose>

					</ol>
					<div class="well-sm"></div>
					<div class="panel panel-default">
						<div style="color: rgb(7, 132, 163);" class="panel-heading">
							<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Đăng
								ký đề tài</h4>
						</div>
						<form action="Dangkydetai" method="post"
							enctype="multipart/form-data">
							<div class="row" style="width: 50vw; margin-left: 15vw;">
								<div class="col-lg-6">
									<div class="p-5">
										<form class="user">
											<div class="form-group">
												<label>Tên đề tài</label> <input class="form-control"
													type="text" name="ten_detai">
											</div>
											<div class="form-group">
												<label for="ma_chuyennganh">Chuyên ngành:</label> <select
													class="custom-select custom-select-sm form-control form-control-sm"
													name="ma_chuyennganh" id="ma_chuyennganh">
													<option value=1>Công nghệ phần mềm</option>
													<option value=2>An toàn thông tin</option>
													<option value=3>Hệ thống thông tin</option>
												</select> <input type="hidden" value="${sessionScope.info.id}"
													name="gvhd"> <input type="hidden" value=0
													name="trangthai"> <input type="hidden" value=0
													name="soluongsinhviendangky">
											</div>
											<div class="form-group">
												<label>Năm</label> <input class="form-control" type="text"
													value="${nam}" name="nam_totnghiep">
											</div>
											<div class="text-center">
												<button class="btn btn-primary"
													href="Dangkydetai?id=${sessionScope.info.id}" type="submit">Đăng
													ký</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</form>
					</div>

					<div class="panel panel-default">
						<div style="color: rgb(7, 132, 163);" class="panel-heading">
							<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Danh
								sách đề tài đã đăng ký</h4>
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Đề tài</th>
											<th>Tên đề tài</th>
											<th>Trạng thái</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${detai}" var="dt" varStatus="STT">
											<tr class="odd gradeX">
												<td>${dt.ma_detai}</td>
												<td>${dt.ten_detai}</td>
												<td><c:choose>
														<c:when test="${dt.trangthai==0}">
															<strong>Chưa duyệt</strong>
														</c:when>
														<c:when test="${dt.trangthai == 1}">
															<strong>Đã duyệt</strong>
														</c:when>
													</c:choose></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>


					<ol class="breadcrumb">
						<li><a href="Home">Home</a></li>

					</ol>
					<div class="panel panel-default" id="thongke_right">
						<div class="panel-heading">
							<h4 id="mobile_thongke">Thống kê</h4>
						</div>
						<a class="list-group-item"><img
							src="Content/public/images/user-group-icon (1).png" width="24"
							height="24" /> Lượt truy cập : <span class="badge"></span></a> <a
							style="text-decoration: underline;" data-toggle="modal"
							data-target="#who_online" title="Who is online ?"
							href="javascript:void();" class="list-group-item"><img
							src="Content/public/images/online-icon.png" width="24"
							height="24" /> Đang trực tuyến: <span class="badge"></span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="/includes/footer.jsp"%>

