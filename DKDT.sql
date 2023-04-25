USE [master]
GO

--DROP DATABASE [DKDT]
--GO

CREATE DATABASE [DKDT]
GO

USE [DKDT]
GO
--Create table
--Role
CREATE TABLE [dbo].[Roles](
	[roleid] INT PRIMARY KEY,
	[rolename] NVARCHAR(50) NOT NULL
)
GO
--Insert table Roles
INSERT [dbo].[Roles] ([roleid], [rolename]) VALUES (1, N'admin')
INSERT [dbo].[Roles] ([roleid], [rolename]) VALUES (2, N'giảng viên')
INSERT [dbo].[Roles] ([roleid], [rolename]) VALUES (3, N'trưởng bộ môn')
INSERT [dbo].[Roles] ([roleid], [rolename]) VALUES (4, N'sinh viên')
GO

--ChuyenNganh
CREATE TABLE [dbo].[ChuyenNganh](
	[ma_chuyennganh] INT IDENTITY(1,1) PRIMARY KEY,
	[ten_chuyennganh] NVARCHAR(20) NOT NULL
)
GO
--Insert table ChuyenNganh
SET IDENTITY_INSERT [dbo].[ChuyenNganh] ON 
INSERT [dbo].[ChuyenNganh] ([ma_chuyennganh], [ten_chuyennganh]) VALUES (1, N'Công nghệ phần mềm')
INSERT [dbo].[ChuyenNganh] ([ma_chuyennganh], [ten_chuyennganh]) VALUES (2, N'An toàn thông tin')
INSERT [dbo].[ChuyenNganh] ([ma_chuyennganh], [ten_chuyennganh]) VALUES (3, N'Hệ thống thông tin')
SET IDENTITY_INSERT [dbo].[ChuyenNganh] OFF
GO

--DangKyGiangVien
CREATE TABLE [dbo].[DangKyGiangVien](
	[id] [int] IDENTITY(1,1) PRIMARY KEY,
	[ngaybatdau] [date] NOT NULL,
	[ngayketthuc] [date] NOT NULL
)
GO

--insert table DangKyGiangVien
SET IDENTITY_INSERT [dbo].[DangKyGiangVien] ON 
INSERT [dbo].[DangKyGiangVien] ([id], [ngaybatdau], [ngayketthuc]) VALUES (1, CAST(N'2022-12-12' AS Date), CAST(N'2022-12-16' AS Date))
INSERT [dbo].[DangKyGiangVien] ([id], [ngaybatdau], [ngayketthuc]) VALUES (3, CAST(N'2022-12-19' AS Date), CAST(N'2022-12-21' AS Date))
SET IDENTITY_INSERT [dbo].[DangKyGiangVien] OFF
GO

--DangKySinhVien
CREATE TABLE [dbo].[DangKySinhVien](
	[id] [int] IDENTITY(1,1) PRIMARY KEY,
	[ngaybatdau] [date] NOT NULL,
	[ngayketthuc] [date] NOT NULL
)
GO

--insert table DangKySinhVien
SET IDENTITY_INSERT [dbo].[DangKySinhVien] ON 
INSERT [dbo].[DangKySinhVien] ([id], [ngaybatdau], [ngayketthuc]) VALUES (1, CAST(N'2022-12-19' AS Date), CAST(N'2022-12-21' AS Date))
INSERT [dbo].[DangKySinhVien] ([id], [ngaybatdau], [ngayketthuc]) VALUES (2, CAST(N'2022-12-20' AS Date), CAST(N'2022-12-30' AS Date))
SET IDENTITY_INSERT [dbo].[DangKySinhVien] OFF
GO

--NguoiDung
CREATE TABLE [dbo].[Peoples](
	[id] VARCHAR(50) PRIMARY KEY,
	[hoten] nvarchar(100) not null,
	[ngaysinh] DATE NOT NULL,
	[gioitinh] BIT NOT NULL,
	[diachi] nvarchar(200),
	[sdt] varchar(12) not null,
	[email] varchar(50) not null unique,
	[ma_chuyennganh] INT NOT NULL REFERENCES ChuyenNganh(ma_chuyennganh),
	[roleid] INT NOT NULL REFERENCES Roles(roleid),
)
--Insert table Peoples
GO
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110111', N'Hoàng Bách', CAST(N'2002-12-12' AS Date), 1, N'01 Lê Văn Chí', N'0987654328', N'20110111@student.hcmute.edu.vn', 1, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110223', N'Đào Thị Thanh Vi', CAST(N'2002-6-10' AS Date), 1, N'31 Đình Phong Phú', N'0987654328', N'20110223@student.hcmute.edu.vn', 1, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110618', N'Trần Ngô Bích Du', CAST(N'2002-9-23' AS Date), 1, N'11 Tăng Nhơn Phú', N'0987654328', N'20110618@student.hcmute.edu.vn', 1, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110678', N'Nguyễn Thị Na', CAST(N'2002-12-12' AS Date), 1, N'5/1 Lã Xuân Oai', N'0987654328', N'20110678@student.hcmute.edu.vn', 1, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110666', N'Nguyễn Minh Trí', CAST(N'2002-8-12' AS Date), 1, N'14/4A Quang Trung', N'0987654323', N'20110666@student.hcmute.edu.vn', 2, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110777', N'Nguyễn Tiến Minh', CAST(N'2001-8-12' AS Date), 1, N'14/4 Lê Lợi', N'0987654323', N'20110777@student.hcmute.edu.vn', 2, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110789', N'Trần Đình Quang', CAST(N'2001-8-2' AS Date), 1, N'14 Phạm Văn Đồng', N'0987654323', N'20110789@student.hcmute.edu.vn', 2, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110676', N'Phạm Tiến Dũng', CAST(N'2002-11-22' AS Date), 0, N'01 Võ Văn Tần', N'0987654323', N'20110676@student.hcmute.edu.vn', 3, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'20110555', N'Đặng Tấn Phát', CAST(N'2002-11-22' AS Date), 0, N'484 Lê Văn Việt', N'0987654323', N'20110555@student.hcmute.edu.vn', 3, 4)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'chinhhn', N'Huỳnh Nguyên Chính', CAST(N'1978-12-12' AS Date), 0, N'Ngã tư Bình Thái', N'0987654323', N'chinhhn@hcmute.edu.vn', 3, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'khoimt', N'Mai Tuấn Khôi', CAST(N'1978-12-12' AS Date), 0, N'12/5 Chương Dương', N'0987654323', N'khoimt@hcmute.edu.vn', 2, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'ngocpq', N'Phùng Quang Ngọc', CAST(N'2002-12-12' AS Date), 1, N'01 Lê Văn Chí', N'0987654323', N'ngocpq@hcmute.edu.vn', 2, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'admin1', N'Admin', CAST(N'1998-12-12' AS Date), 1, N'01 Võ Văn Ngân', N'0987654321', N'admin@gmail.com', 1, 1)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'ductt', N'Trần Tiến Đức', CAST(N'1978-12-12' AS Date), 0, N'01 Linh Trung', N'0987654323', N'ductt@hcmute.edu.vn', 1, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'chaultm', N'Lê Thị Minh Châu', CAST(N'1978-12-12' AS Date), 0, N'Xa lộ Hà Nội', N'0987654323', N'chaultm@hcmute.edu.vn', 2, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'quangtn', N'Trần Nhật Quang', CAST(N'1978-12-12' AS Date), 0, N'Xa lộ Đại Hàn', N'0987654323', N'quangtn@hcmute.edu.vn', 3, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'thoma', N'Mai Anh Thơ', CAST(N'1978-12-12' AS Date), 0, N'01 Tô Vĩnh Diện', N'0987654323', N'thoma@hcmute.edu.vn', 1, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'tutc', N'Trần Công Tú', CAST(N'1978-12-12' AS Date), 0, N'01 Chân Lý', N'0987654323', N'tutc@hcmute.edu.vn', 1, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'vinhlv', N'Lê Văn Vinh', CAST(N'1978-12-12' AS Date), 0, N'01 Lương Định Của', N'0987654323', N'vinhlv@hcmute.edu.vn', 1, 2)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'vanntt', N'Nguyễn Thị Thanh Vân', CAST(N'1978-12-12' AS Date), 1, N'01 Thống Nhất', N'0987654323', N'vanntt@hcmute.edu.vn', 2, 3)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'phunghx', N'Huỳnh Xuân Phụng', CAST(N'1978-12-12' AS Date), 0, N'23 Bác Ái', N'0987654323', N'phunghx@hcmute.edu.vn', 1, 3)
INSERT [dbo].[Peoples] ([id], [hoten], [ngaysinh], [gioitinh], [diachi], [sdt], [email], [ma_chuyennganh], [roleid]) VALUES (N'sonnt', N'Nguyễn Thành Sơn', CAST(N'1978-12-12' AS Date), 0, N'Trần Hưng Đạo', N'0987654328', N'sonnt@hcmute.edu.vn', 3, 3)
GO

--Admin
CREATE TABLE [dbo].[Admin](
	[admin_id] VARCHAR(50) PRIMARY KEY references Peoples(id)
)
GO
--Insert table Admin
INSERT INTO [dbo].[Admin] VALUES('admin1')
GO

--KhoaHoc
CREATE TABLE [dbo].[KhoaHoc](
	[ma_khoahoc] INT IDENTITY(1,1) PRIMARY KEY,
	[ten_khoahoc] NVARCHAR(20) NOT NULL,
	[nienkhoa] VARCHAR(10) NOT NULL,
	[nam_nhaphoc] CHAR(4) NOT NULL,
	[nam_ketthuc] CHAR(4) NOT NULL,
	[ctdt] CHAR(10) NOT NULL,
	[lopsinhvien] CHAR(10) NOT NULL
)
GO
--Insert table KhoaHoc
SET IDENTITY_INSERT [dbo].[KhoaHoc] ON 
INSERT [dbo].[KhoaHoc] ([ma_khoahoc], [ten_khoahoc], [nienkhoa], [nam_nhaphoc], [nam_ketthuc], [ctdt], [lopsinhvien]) VALUES (1, N'2020', N'2020-2024', N'2020', N'2028', N'20110ST1  ', N'20110ST1  ')
INSERT [dbo].[KhoaHoc] ([ma_khoahoc], [ten_khoahoc], [nienkhoa], [nam_nhaphoc], [nam_ketthuc], [ctdt], [lopsinhvien]) VALUES (2, N'2021', N'2021-2025', N'2021', N'2029', N'21110ST1  ', N'21110ST1  ')
SET IDENTITY_INSERT [dbo].[KhoaHoc] OFF 
GO

--GiangVien
CREATE TABLE [dbo].[GiangVien](
	[ma_giangvien] VARCHAR(50) PRIMARY KEY references Peoples(id),
	[chucvu] NVARCHAR(100)
)
GO
--Insert table GiangVien
GO
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'ductt', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'thoma', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'chinhhn', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'vanntt', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'quangtn', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'tutc', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'chaultm', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'ngocpq', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'khoimt', N'Giảng viên')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'vinhlv', N'Trưởng bộ môn')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'phunghx', N'Trưởng bộ môn')
INSERT [dbo].[GiangVien] ([ma_giangvien], [chucvu]) VALUES (N'sonnt', N'Trưởng bộ môn')
GO

--DeTai
CREATE TABLE [dbo].[DeTai](
	[ma_detai] [int] IDENTITY(1,1) PRIMARY KEY,
	[ten_detai] [nvarchar](100) NOT NULL,
	[ma_chuyennganh] [int] NOT NULL REFERENCES [dbo].[ChuyenNganh](ma_chuyennganh),
	[gvhd] [varchar](50) NOT NULL REFERENCES [dbo].[GiangVien](ma_giangvien),
	[gvpb] [varchar](50) NULL REFERENCES [dbo].[GiangVien](ma_giangvien),
	[trangthai] [bit] NULL,
	[nam_totnghiep] [int] NOT NULL,
	[soluongsinhviendangky] [smallint] NULL
)
GO
--Insert table DeTai
SET IDENTITY_INSERT [dbo].[DeTai] ON 
INSERT [dbo].[DeTai] ([ma_detai], [ten_detai], [ma_chuyennganh], [gvhd], [gvpb], [trangthai], [nam_totnghiep], [soluongsinhviendangky]) VALUES (1, N'Website thương mại điện tử', 1, N'tutc', NULL, 1, 2022, 1)
INSERT [dbo].[DeTai] ([ma_detai], [ten_detai], [ma_chuyennganh], [gvhd], [gvpb], [trangthai], [nam_totnghiep], [soluongsinhviendangky]) VALUES (2, N'Nhận diện chữ viết tay', 1, N'ductt', NULL, 0, 2021, 0)
INSERT [dbo].[DeTai] ([ma_detai], [ten_detai], [ma_chuyennganh], [gvhd], [gvpb], [trangthai], [nam_totnghiep], [soluongsinhviendangky]) VALUES (3, N'Nhận diện khuôn mặt', 1, N'quangtn', NULL, 0, 2022, 0)
INSERT [dbo].[DeTai] ([ma_detai], [ten_detai], [ma_chuyennganh], [gvhd], [gvpb], [trangthai], [nam_totnghiep], [soluongsinhviendangky]) VALUES (5, N'Nhận diện khuôn mặt', 1, N'chaultm', NULL, 0, 2022, 0)
SET IDENTITY_INSERT [dbo].[DeTai] OFF
GO

--SinhVien
CREATE TABLE [dbo].[SinhVien](
	[ma_sinhvien] [varchar](50) PRIMARY KEY,
	[khoa] [int] NOT NULL,
	[ma_detai] [int] REFERENCES [dbo].[DeTai](ma_detai),
	[diem_pb] [nvarchar](50) NULL,
	[statusdetai] INT NULL
) 
GO

INSERT [dbo].[SinhVien] ([ma_sinhvien], [khoa], [ma_detai], [diem_pb], [statusdetai]) VALUES (N'20110666', 1, NULL, NULL, NULL)
INSERT [dbo].[SinhVien] ([ma_sinhvien], [khoa], [ma_detai], [diem_pb], [statusdetai]) VALUES (N'20110789', 1, NULL, NULL, NULL)
INSERT [dbo].[SinhVien] ([ma_sinhvien], [khoa], [ma_detai], [diem_pb], [statusdetai]) VALUES (N'20110555', 1, NULL, NULL, NULL)
INSERT [dbo].[SinhVien] ([ma_sinhvien], [khoa], [ma_detai], [diem_pb], [statusdetai]) VALUES (N'20110777', 1, NULL, NULL, NULL)
INSERT [dbo].[SinhVien] ([ma_sinhvien], [khoa], [ma_detai], [diem_pb], [statusdetai]) VALUES (N'20110223', 1, NULL, NULL, NULL)
INSERT [dbo].[SinhVien] ([ma_sinhvien], [khoa], [ma_detai], [diem_pb], [statusdetai]) VALUES (N'20110678', 1, NULL, NULL, NULL)
INSERT [dbo].[SinhVien] ([ma_sinhvien], [khoa], [ma_detai], [diem_pb], [statusdetai]) VALUES (N'20110618', 1, NULL, NULL, NULL)
GO

--NhomSinhVien
CREATE TABLE [dbo].[NhomSinhVien](
	[ma_nhom] [int] IDENTITY(1,1) PRIMARY KEY,
	[truongnhom] [varchar](50) NOT NULL REFERENCES [dbo].[SinhVien](ma_sinhvien),
	[thanhvien] [varchar](50) NULL REFERENCES [dbo].[SinhVien](ma_sinhvien),
	[ma_detai] [int] NOT NULL REFERENCES [dbo].[DeTai](ma_detai),
	[ngay_nopdetai] [date] NULL
)
GO

--HoiDong
CREATE TABLE [dbo].[HoiDong](
	[ma_hd] [int] IDENTITY(1,1) PRIMARY KEY,
	[ma_detai] [int] NOT NULL REFERENCES [dbo].[DeTai](ma_detai),
	[soluong] [int] NULL,
	[giangvien1] [varchar](50) NOT NULL REFERENCES [dbo].[GiangVien](ma_giangvien),
	[giangvien2] [varchar](50) NULL REFERENCES [dbo].[GiangVien](ma_giangvien),
	[giangvien3] [varchar](50) NULL REFERENCES [dbo].[GiangVien](ma_giangvien),
	[giangvien4] [varchar](50) NULL REFERENCES [dbo].[GiangVien](ma_giangvien),
	[giangvien5] [varchar](50) NULL REFERENCES [dbo].[GiangVien](ma_giangvien)
) 
GO

--Account
CREATE TABLE [dbo].[Accounts](
	[username] VARCHAR(50) REFERENCES Peoples(email),
	[password] VARCHAR(100) NOT NULL,
	[roleid] INT NOT NULL REFERENCES Roles(roleid),
)
GO
--Insert table Accounts
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'20110111@student.hcmute.edu.vn', N'123', 4)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'20110676@student.hcmute.edu.vn', N'123', 4)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'20110789@student.hcmute.edu.vn', N'123', 4)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'phunghx@hcmute.edu.vn', N'1234567890', 3)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'sonnt@hcmute.edu.vn', N'1234567890', 3)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'vinhlv@hcmute.edu.vn', N'1234567890', 3)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'sonnt@hcmute.edu.vn', N'123', 3)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'admin@gmail.com', N'1232', 1)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'ductt@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'vanntt@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'chinhhn@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'quangtn@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'tutc@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'thoma@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'khoimt@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'ngocpq@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'chaultm@hcmute.edu.vn', N'1233', 2)
INSERT [dbo].[Accounts] ([username], [password], [roleid]) VALUES (N'ductt@hcmute.edu.vn', N'1233', 2)
GO

