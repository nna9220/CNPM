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
							<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Đề
								tài : ${dt.ten_detai}</h4>
						</div>
						<div class="panel-body">

							<c:url value="/phangvpb" var="phangv"></c:url>
							<table id="Table1" border="0" cellpadding="0" cellspacing="0"
								width="100%" style="vertical-align: top;">
								<tr>
									<th style="text-align: center;">Mã giảng tên</th>
									<th style="text-align: center;">Tên giảng viên</th>
									<th style="text-align: center;">Chuyên ngành</th>
									<th style="text-align: center;">Chọn</th>
								</tr>
								<c:forEach items="${gvList}" var="gv">
									<tr>
										<td style="text-align: center;" value="${gv.id}" name="gvpb">${gv.id}</td>
										<td style="text-align: center;">${gv.hoten}</td>
										<td style="text-align: center;"><c:choose>
												<c:when test="${gv.ma_chuyennganh == 1}">
													<strong>Công nghệ phần mềm</strong>
												</c:when>
												<c:when test="${gv.ma_chuyennganh == 2}">
													<strong>An toàn thông tin</strong>
												</c:when>
												<c:when test="${gv.ma_chuyennganh == 3}">
													<strong>Hệ thống thông tin</strong>
												</c:when>
											</c:choose></td>
										<td style="text-align: center;">
											<form action="${phangv}" method="post"
												enctype="multipart/form-data">
												<input hidden value="${dt.ma_detai}" name="ma_detai"></input>
												<button class="btn btn-primary" type="submit" name="gvpb"
													value="${gv.id}">Chọn</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
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

