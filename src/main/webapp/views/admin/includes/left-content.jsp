<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="Admin">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">QUẢN LÝ</div>
	</a>
	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Trang chủ -->
	<li class="nav-item active"><a class="nav-link" href="Admin">
			<i class="fas fa-home"></i></i> <span>Trang chủ</span>
	</a></li>
	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Sinh Viên -->
	<li class="nav-item active"><a class="nav-link" href="Studentlist"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-graduation-cap"></i> <span>Sinh viên</span>
	</a>
		<div id="collapsePages" class="collapse show"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="Studentlist">Danh sách sinh viên</a>
				<a class="collapse-item" href="dotdangkysv">Tạo đợt đăng ký</a>
			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Giảng Viên -->
	<li class="nav-item active"><a class="nav-link"
		href="GiangVienList" data-toggle="collapse" data-target="#collapseTwo"
		aria-expanded="true" aria-controls="collapseTwo"> <i
			class="fas fa-fw fa-user"></i> <span>Giảng viên</span>
	</a>
		<div id="collapseTwo" class="collapse show"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="GiangVienlist">Danh sách Giảng
					viên</a> <a class="collapse-item" href="taodotDKGV">Tạo đợt đăng ký</a>
			</div>
		</div></li>
	<!-- Divider -->
	<hr class="sidebar-divider my-0">
	<!-- Nav Item - Account -->
	<li class="nav-item active"><a class="nav-link" href="AccountList">
			<i class="fas fa-fw fa-address-card"></i> <span>Account</span>
	</a></li>
	<!-- Divider -->
	<hr class="sidebar-divider my-0">
	<!-- Nav Item - KhoaHoc -->
	<li class="nav-item active"><a class="nav-link" href="listKhoahoc">
			<i class="fas fa-fw fa-address-card"></i> <span>Khóa học</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Quản Lý Dữ Liệu -->
	<li class="nav-item active"><a class="nav-link" href="listDetai">
			<i class="fas fa-fw fa-folder"></i> <span>Quản Lý Đề Tài</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>
</ul>