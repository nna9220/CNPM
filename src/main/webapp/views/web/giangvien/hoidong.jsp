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
							<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Danh
								sách hội đồng của bạn ${sessionSccope.info.id}</h4>
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead style="text-align: center;">
										<tr style="text-align: center;">
											<th style="text-align: center;">STT</th>
											<th style="text-align: center;">Đề tài</th>
											<th style="text-align: center;">Giảng viên 1</th>
											<th style="text-align: center;">Giảng viên 2</th>
											<th style="text-align: center;">Giảng viên 3</th>
											<th style="text-align: center;">Giảng viên 4</th>
											<th style="text-align: center;">Giảng viên 5</th>
										</tr>
									</thead>
									<tbody style="text-align: center;">
									<c:forEach items="${hds}" var="hd" varStatus="STT">
										<tr style="text-align: center;" class="odd gradeX">
											<td style="text-align: center;">${STT.index+1}</td>
											<td style="text-align: center;"><a
													href="<c:url value='/detailHoiDong?id=${hd.detai}'/>">Chi tiết</a></td>
											<td style="text-align: center;">${hd.giangvien1}</td>
											<td style="text-align: center;">${hd.giangvien2}</td>
											<td style="text-align: center;">${hd.giangvien3}</td>
											<td style="text-align: center;">${hd.giangvien4}</td>
											<td style="text-align: center;">${hd.giangvien5}</td>
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

