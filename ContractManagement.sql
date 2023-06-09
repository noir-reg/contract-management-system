USE [master]
GO
/****** Object:  Database [ContractManager]    Script Date: 4/8/2023 7:42:59 PM ******/
CREATE DATABASE [ContractManager]
 CONTAINMENT = NONE
GO
ALTER DATABASE [ContractManager] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ContractManager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ContractManager] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ContractManager] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ContractManager] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ContractManager] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ContractManager] SET ARITHABORT OFF 
GO
ALTER DATABASE [ContractManager] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ContractManager] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ContractManager] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ContractManager] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ContractManager] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ContractManager] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ContractManager] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ContractManager] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ContractManager] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ContractManager] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ContractManager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ContractManager] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ContractManager] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ContractManager] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ContractManager] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ContractManager] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ContractManager] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ContractManager] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ContractManager] SET  MULTI_USER 
GO
ALTER DATABASE [ContractManager] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ContractManager] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ContractManager] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ContractManager] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ContractManager] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ContractManager] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'ContractManager', N'ON'
GO
ALTER DATABASE [ContractManager] SET QUERY_STORE = ON
GO
ALTER DATABASE [ContractManager] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [ContractManager]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[AID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](30) NULL,
	[CID] [varchar](12) NULL,
	[Password] [varchar](30) NULL,
	[Fullname] [nvarchar](50) NULL,
	[Phone] [varchar](30) NULL,
	[Avartar] [varchar](50) NULL,
	[Address] [nvarchar](100) NULL,
	[status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[AID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BoardManager]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BoardManager](
	[BID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](30) NULL,
	[CID] [varchar](12) NULL,
	[Password] [varchar](30) NULL,
	[Fullname] [nvarchar](50) NULL,
	[Phone] [varchar](30) NULL,
	[Avartar] [varchar](50) NULL,
	[Address] [nvarchar](100) NULL,
	[Status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[BID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contract]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contract](
	[CoID] [int] IDENTITY(1,1) NOT NULL,
	[RoID] [int] NULL,
	[UID] [int] NULL,
	[OID] [int] NULL,
	[Status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[CoID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContractInformation]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContractInformation](
	[CoID] [int] NOT NULL,
	[RentalFee] [int] NULL,
	[SystemFee] [int] NULL,
	[CreateDate] [date] NULL,
	[EndDate] [date] NULL,
	[Name] [nvarchar](70) NULL,
	[Description] [nvarchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[CoID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Owner]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Owner](
	[OID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](30) NULL,
	[CID] [varchar](12) NULL,
	[Password] [varchar](30) NULL,
	[DateOfBirth] [date] NULL,
	[Fullname] [nvarchar](50) NULL,
	[Phone] [varchar](30) NULL,
	[Avartar] [varchar](50) NULL,
	[Address] [nvarchar](100) NULL,
	[Status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[OID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Report]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Report](
	[RpID] [int] IDENTITY(1,1) NOT NULL,
	[UID] [int] NULL,
	[OID] [int] NULL,
	[content] [nvarchar](1000) NULL,
	[createDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[RpID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[RoID] [int] IDENTITY(1,1) NOT NULL,
	[UID] [int] NULL,
	[OID] [int] NULL,
	[status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RoID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoomImage]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoomImage](
	[RoID] [int] NOT NULL,
	[ImgPath] [varchar](100) NOT NULL,
 CONSTRAINT [PK_RoomPicture] PRIMARY KEY CLUSTERED 
(
	[RoID] ASC,
	[ImgPath] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 4/8/2023 7:42:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[UID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](30) NULL,
	[CID] [varchar](12) NULL,
	[Password] [varchar](30) NULL,
	[DateOfBirth] [date] NULL,
	[Fullname] [nvarchar](50) NULL,
	[Phone] [varchar](30) NULL,
	[Avartar] [varchar](50) NULL,
	[Address] [nvarchar](100) NULL,
	[Type] [int] NULL,
	[Status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[UID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([AID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [status]) VALUES (1, N'admin@gmail.com', N'095160917912', N'123456', N'Cristiano Ronaldo ABC', N'0396816536', N'1679594636749.jfif', N'215 Nguyễn Hữu Cảnh, Phường 19, Quận 7, TP. Hồ Chí Minh', 1)
INSERT [dbo].[Admin] ([AID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [status]) VALUES (3, N'adminb@gmail.com', N'070989098989', N'123', N'Lionel Messi', N'0080330740', N'linkava', N'165 Trương Định, Phường 6, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Admin] ([AID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [status]) VALUES (10, N'adminh@gmail.com', N'299898989891', N'123', N'NeymarJr', N'0241548684', N'linkava', N'330 Bàu Cát, Phường 14, Quận Tân Bình, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Admin] ([AID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [status]) VALUES (11, N'hungphamphu159@gmail.com', N'298987996612', N'123', N'Kylian Mbappe', N'0208626188', N'linkava', N'1846 Dương Quảng Hàm, Phường 5, Quận Gò Vấp, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Admin] ([AID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [status]) VALUES (12, N'nguyentran@gmail.com', N'298971900154', N'123', N'Trần Nguyễn', N'0660947124', N'linkava', N'1631 Võ Thị Sáu, Phường 6, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Admin] ([AID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [status]) VALUES (13, N'adminmoi@gmail.com', N'123456789123', N'123456', N'Admin Test', N'0782214567', N'default_avatar.png', N'12851 BÃ u CÃ¡t, PhÆ°á»ng 14, Quáº­n TÃ¢n BÃ¬nh, TP. Há» ChÃ­ Minh', 1)
INSERT [dbo].[Admin] ([AID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [status]) VALUES (14, N'adminmoi1@gmail.com', N'123456321223', N'123123', N'Admin Test 2', N'0782214561', N'default_avatar.png', N'12851 BÃ u 1 CÃ¡t, PhÆ°á»ng 14, Quáº­n TÃ¢n BÃ¬nh, TP. Há» ChÃ­ Minh', 1)
INSERT [dbo].[Admin] ([AID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [status]) VALUES (15, N'adminmoi2@gmail.com', N'981769191120', N'123123', N'Admin Test 2', N'0782214561', N'default_avatar.png', N'12851 BÃ u 1 3 CÃ¡t, PhÆ°á»ng 14, Quáº­n TÃ¢n BÃ¬nh, TP. Há» ChÃ­ Minh', 1)
SET IDENTITY_INSERT [dbo].[Admin] OFF
GO
SET IDENTITY_INSERT [dbo].[BoardManager] ON 

INSERT [dbo].[BoardManager] ([BID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (1, N'chutich@gmail.com', N'095204500162', N'123', N'Dương Chủ Tịch', N'0781162351', N'1679356096543.jpg', N'509 Dương Quảng Hàm, Phường 5, Quận Gò Vấp, TP. Hồ Chí Minh', 1)
INSERT [dbo].[BoardManager] ([BID], [Email], [CID], [Password], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (2, N'phochutich@gmail.com', N'095160560631', N'123', N'Minh Phó Chủ Tịch', N'0946614723', NULL, N'1389 Đinh Bộ Lĩnh, Phường 26, Quận Bình Thạnh, TP. Hồ Chí Minh
', 1)
SET IDENTITY_INSERT [dbo].[BoardManager] OFF
GO
SET IDENTITY_INSERT [dbo].[Contract] ON 

INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (1, 8, 3, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (2, 9, 4, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (3, 1, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (4, 2, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (5, 3, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (6, 4, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (7, 5, 5, 1, 0)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (8, 6, 6, 1, 0)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (9, 7, 7, 1, 0)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (10, 10, 8, 4, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (11, 11, 9, 3, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (12, 12, 10, 5, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (13, 1, 2, 1, 0)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (14, 1, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (15, 7, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (17, 17, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (18, 20, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (19, 14, 1, 1, 1)
INSERT [dbo].[Contract] ([CoID], [RoID], [UID], [OID], [Status]) VALUES (20, 15, 1, 1, 1)
SET IDENTITY_INSERT [dbo].[Contract] OFF
GO
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (1, 1200, 12000, CAST(N'2017-10-12' AS Date), CAST(N'2023-10-12' AS Date), N'Hop dong thue nha 1', N'hop dong thue')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (2, 10000, 500000, CAST(N'2023-02-10' AS Date), CAST(N'2025-02-10' AS Date), N'Hop Dong Thue Nha 2', N'Hop Dong thue nha ')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (3, 200, 12000, CAST(N'2022-11-22' AS Date), CAST(N'2023-11-30' AS Date), N'Hop Dong Thue Nha 3', N'hop dong thue nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (4, 1250, 11000, CAST(N'2019-03-07' AS Date), CAST(N'2025-05-05' AS Date), N'Hop Dong Thue Nha 4', N'hop dong thue nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (5, 1250, 12000, CAST(N'2017-11-20' AS Date), CAST(N'2023-10-14' AS Date), N'Hop Dong Thue Nha 5', N'hop dong thue nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (6, 1250, 12000, CAST(N'2016-01-07' AS Date), CAST(N'2025-01-07' AS Date), N' Hop dong thue nha 6', N'Hop Dong Thue Nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (7, 2000, 12000, CAST(N'2018-12-15' AS Date), CAST(N'2025-12-15' AS Date), N'Hop Dong Thue Nha 7', N'Hop Dong Thue Nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (8, 3000, 12000, CAST(N'2017-07-17' AS Date), CAST(N'2025-07-17' AS Date), N'Hop Dong Thue Nha 8', N'Hop Dong Thue Nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (9, 3150, 12000, CAST(N'2017-03-03' AS Date), CAST(N'2026-03-03' AS Date), N'Hop Dong Thue Nha 9', N'Hop Dong Thue Nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (10, 9111, 12000, CAST(N'2016-11-03' AS Date), CAST(N'2026-11-03' AS Date), N'Hop Dong Thue Nha 10', N'Hop Dong Thue Nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (11, 6142, 12000, CAST(N'2018-06-06' AS Date), CAST(N'2026-06-06' AS Date), N'Hop Dong Thue Nha', N'Hop Dong Thue Nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (12, 7776, 12000, CAST(N'2018-03-22' AS Date), CAST(N'2025-03-22' AS Date), N'Hop Dong Thue Nha', N'Hop Dong Thue Nha')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (13, 77777, 0, CAST(N'2023-03-24' AS Date), CAST(N'2025-03-24' AS Date), N'Di Binh Abb', N'777')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (15, 90000, 0, CAST(N'2024-01-01' AS Date), CAST(N'2025-02-02' AS Date), N'dddd', N'Hello')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (17, 100, 0, CAST(N'2023-01-01' AS Date), CAST(N'2025-01-01' AS Date), N'asd', N'asdaa')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (18, 122, 0, CAST(N'2023-03-23' AS Date), CAST(N'2023-09-23' AS Date), N'dddd', N'asdfasf')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (19, 120, 0, CAST(N'2023-03-22' AS Date), CAST(N'2023-06-22' AS Date), N'Hop Dong Thue Nha asdasdasdsa', N'asdasd')
INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [CreateDate], [EndDate], [Name], [Description]) VALUES (20, 123, 0, CAST(N'2024-01-01' AS Date), CAST(N'2025-01-01' AS Date), N'asdas', N'asdf')
GO
SET IDENTITY_INSERT [dbo].[Owner] ON 

INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (1, N'owner@gmail.com', N'194871596479', N'123456', CAST(N'1998-12-28' AS Date), N'Di Bình  AB', N'0965386808', N'1679356296534.jpg', N'174 Lê Quang Định, Phường 14, Quận Bình Thạnh, TP. Hồ Chí Minh', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (2, N'leuhan@gmail.com', N'025717456359', N'123', CAST(N'1993-02-15' AS Date), N'Huỳnh Tiến Võ', N'0443287566', NULL, N'1679 Thống Nhất, Phường 16, Quận Gò Vấp, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (3, N'duongdduong@gmail.com', N'095202500666', N'123', CAST(N'1991-12-12' AS Date), N'Dương Đông Dương', N'0582602202
', NULL, N'687 Trần Quang Khải, Phường Tân Định, Quận 1, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (4, N'ndnminh@gmail.com', N'095090079501', N'123', CAST(N'1992-06-07' AS Date), N'Nguyễn Đỗ Ngọc Minh', N'0582602417
', NULL, N'1283 Nguyễn Thông, Phường 9, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (5, N'thp.phuc@gmail.com', N'599059049196', N'123', CAST(N'1993-05-25' AS Date), N'Trần Hoàng Phúc', N'0582602204
', NULL, N'949 Nguyễn Thông, Phường 9, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (6, N'pphung.1@gmail.com', N'940949560191', N'123', CAST(N'1993-03-27' AS Date), N'Phạm Phú Hưng', N'0582602199
', NULL, N'1194 Nguyễn Thông, Phường 9, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (7, N'RonaldoJr@gmail.com', N'954094954916', N'123', CAST(N'1994-03-17' AS Date), N'Cristiano Ronaldo', N'0582602427
', NULL, N'1924 Lê Trọng Tấn, Phường Tây Thạnh, Quận Tân Phú, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (8, N'hieuthuhai@gmail.com', N'971651641100', N'123', CAST(N'1993-01-13' AS Date), N'Hiếu Thứ Hai', N'0582602252
', NULL, N'1417 Pasteur, Phường 1, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (9, N'hurrykang@gmail.com', N'095001940911', N'123', CAST(N'1995-12-19' AS Date), N'Hurry Kang', N'0582602328
', NULL, N'1425 Hồ Văn Huê, Phường 9, Quận Phú Nhuận, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (10, N'manbo@gmail.com', N'905607907601', N'123', CAST(N'1996-06-12' AS Date), N'Manbo Trần', N'0898024189
', NULL, N'1654 Nam Kỳ Khởi Nghĩa, Phường 3, Quận 1, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (11, N'ldblam@gmail.com', N'290494321967', N'123', CAST(N'2002-05-25' AS Date), N'Lê Dương Bảo Lâm', N'0937701767
', NULL, N'1033 Nguyễn Đình Chiểu, Phường 5, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (12, N'tranthanh@gmail.com', N'907979161641', N'123', CAST(N'2002-03-27' AS Date), N'Trấn Thành', N'0933193891
', NULL, N'1075 Dương Quảng Hàm, Phường 5, Quận Gò Vấp, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (13, N'ninhduonglanngoc@gmail.com', N'719641918918', N'123', CAST(N'2006-09-26' AS Date), N'Ninh Dương Lan Ngọc', N'0933511060
', NULL, N'1930 Nguyễn Thượng Hiền, Phường 5, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (14, N'vukhactiep@gmail.com', N'361118971918', N'123', CAST(N'2010-12-09' AS Date), N'Vũ Khắc Tiệp', N'0783492022
', NULL, N'1224 Nơ Trang Long, Phường 13, Quận Bình Thạnh, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (15, N'ducphuc@gmail.com', N'311848436115', N'123', CAST(N'2005-06-06' AS Date), N'Đức Phúc', N'0933981244
', NULL, N'1462 Lê Quang Định, Phường 14, Quận Bình Thạnh, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (16, N'neymar@gmail.com', N'918790494918', N'123', CAST(N'2006-07-07' AS Date), N'Neymar Junior', N'0937448854
', NULL, N'900 Nguyễn Xí, Phường 26, Quận Bình Thạnh, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (17, N'messi@gmail.com', N'092190194919', N'123', CAST(N'2007-08-08' AS Date), N'Lionel Messi', N'0933981244
', NULL, N'725 Võ Thị Sáu, Phường 6, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (18, N'msuykey@gmail.com', N'659479619419', N'123', CAST(N'1981-03-05' AS Date), N'EM SUY KI', N'0937448854
', NULL, N'312 Nguyễn Đình Chiểu, Phường 5, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (19, N'gerdnang@gmail.com', N'197135614961', N'123', CAST(N'1983-06-17' AS Date), N'GerdNang', N'0346401628
', NULL, N'1944 Lê Văn Sỹ, Phường 12, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (20, N'sontungmtp@gmail.com', N'849391288532', N'123', CAST(N'1922-11-12' AS Date), N'Sếp Tùng', N'0123257432', NULL, N'1292 Hoàng Văn Thụ, Phường 9, Quận Phú Nhuận, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (21, N'lowg@gmail.com', N'295971959413', N'123', CAST(N'1999-09-19' AS Date), N'Low G', N'0325440433
', NULL, N'639 Trương Định, Phường 6, Quận 3, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (22, N'nguyenthao@gmail.com', N'123123123123', N'123', CAST(N'1988-11-12' AS Date), N'TLing', N'0092131231', NULL, N'1294 Lê Quang Định, Phường 14, Quận Bình Thạnh, TP. Hồ Chí Minh
', 1)
INSERT [dbo].[Owner] ([OID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Status]) VALUES (23, N'anhminhng123@gmail.com', N'095090908591', N'123', CAST(N'1999-11-11' AS Date), N'Anh Minh', N'0908908991', NULL, N'1226 Trần Công Minh, Phường 9, Quận Tân Phú, TP. Hồ Chí Minh', 1)
SET IDENTITY_INSERT [dbo].[Owner] OFF
GO
SET IDENTITY_INSERT [dbo].[Room] ON 

INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (1, 1, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (2, 2, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (3, 3, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (4, 1, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (5, 1, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (6, 6, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (7, 1, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (8, 3, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (9, 4, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (10, 8, 4, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (11, 9, 3, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (12, 10, 5, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (13, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (14, 1, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (15, 1, 1, 1)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (16, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (17, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (18, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (19, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (20, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (21, NULL, 2, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (22, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (23, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (24, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (25, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (26, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (27, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (28, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (29, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (30, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (31, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (32, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (33, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (34, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (35, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (36, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (37, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (38, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (39, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (40, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (41, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (42, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (43, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (44, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (45, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (46, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (47, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (48, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (49, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (50, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (51, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (52, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (53, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (54, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (55, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (56, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (57, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (58, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (59, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (60, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (61, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (62, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (63, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (64, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (65, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (66, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (67, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (68, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (69, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (70, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (71, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (72, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (73, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (74, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (75, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (76, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (77, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (78, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (79, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (80, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (81, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (82, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (83, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (84, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (85, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (86, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (87, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (88, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (89, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (90, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (91, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (92, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (93, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (94, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (95, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (96, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (97, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (98, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (99, NULL, NULL, 0)
GO
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (100, NULL, 1, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (101, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (102, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (103, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (104, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (105, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (106, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (107, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (108, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (109, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (110, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (111, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (112, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (113, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (114, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (115, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (116, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (117, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (118, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (119, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (120, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (121, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (122, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (123, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (124, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (125, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (126, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (127, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (128, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (129, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (130, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (131, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (132, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (133, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (134, NULL, NULL, 0)
INSERT [dbo].[Room] ([RoID], [UID], [OID], [status]) VALUES (135, NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[Room] OFF
GO
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (1, N'1679347025888.JPG')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (1, N'1679347037823.JPG')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (2, N'1679348888688.jpg')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (3, N'1679348902674.JPG')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (4, N'1679349235316.JPG')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (5, N'1679352731792.JPG')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (6, N'1679348908040.JPG')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (7, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (8, N'1679352259013.JPG')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (9, N'1679352745994.jpg')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (10, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (11, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (12, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (13, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (14, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (15, N'1679363631713.jpg')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (16, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (17, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (18, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (19, N'home_default.png')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (20, N'1679358698716.jpg')
INSERT [dbo].[RoomImage] ([RoID], [ImgPath]) VALUES (100, N'1679363767015.jpg')
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (1, N'user@gmail.com', N'002574940211', N'123456', CAST(N'2004-11-14' AS Date), N'Lê Hoàng Long', N'0269170153', N'default_avatar.png', N'12851 Bàu Cát, Phường 14, Quận Tân Bình, TP. Hồ Chí Minhh', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (2, N'ngminhtuan@gmail.com', N'806187098593', N'123', CAST(N'2000-10-25' AS Date), N'Nguyễn Minh Tuấn', N'0432832709', NULL, N'1413 Nguyễn Xí, Phường 26, Quận Bình Thạnh, TP. Hồ Chí Minh
', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (3, N'trandinhtu@gmail.com', N'017033282167', N'123', CAST(N'1999-12-02' AS Date), N'Trần Đình Tú', N'0507688538', NULL, N'1925 Nguyễn Công Trứ, Phường Nguyễn Thái BÌnh, Quận 1, TP. Hồ Chí Minh
', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (4, N'ngstung@gmail.com', N'040821712961', N'123', CAST(N'1992-05-24' AS Date), N'Nguyễn Sơn Tùng', N'0562664310
', NULL, N'1186 Hồ Văn Huê, Phường 9, Quận Phú Nhuận, TP. Hồ Chí Minh
', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (5, N'doduykhanh@gmail.com', N'090981945097', N'123', CAST(N'1994-01-18' AS Date), N'Đỗ Duy Khánh', N'0562668443
', NULL, N'1296 Nguyễn Văn Lượng, Phường 17, Quận Gò Vấp, TP. Hồ Chí Minh
', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (6, N'phthanhdo@gmail.com', N'098098409591', N'123', CAST(N'2001-04-24' AS Date), N'Phùng Thanh Độ', N'0562664314
', NULL, N'65 Lý Thái Tăng, Biên Hoà', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (7, N'ngvando123@gmail.com', N'297959165115', N'123', CAST(N'1993-10-25' AS Date), N'Nguyễn Văn Đô', N'0932746010
', NULL, N'849 Đinh Bộ Lĩnh, Phường 26, Quận Bình Thạnh, TP. Hồ Chí Minh
', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (8, N'phminhtuan133@gmail.com', N'265974195911', N'123', CAST(N'1996-05-29' AS Date), N'Phạm Minh Tuấn', N'0907186870
', NULL, N'1846 Bùi Viện, Phường Phạm Ngũ Lão, Quận 1, TP. Hồ Chí Minh
', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (9, N'ddongnam1333@gmail.com', N'095094165156', N'123', CAST(N'1998-07-23' AS Date), N'Dương Đông Nam', N'0939103936
', NULL, N'612 Nguyễn Thiện Thuật, Phường 2, Quận 3, TP. Hồ Chí Minh
', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (10, N'duongdongbac@gmail.com', N'089709085899', N'123', CAST(N'1998-04-06' AS Date), N'Dương Đông Tây', N'0939078408
', NULL, N'1095 Độc Lập, Phường Tân Quý, Quận Tân Phú, TP. Hồ Chí Minh
', 1, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (15, N'nguyenanhminh22@gmail.com', N'079496165497', N'123', CAST(N'1993-07-23' AS Date), N'Dương Đông Bắc', N'0932487200
', NULL, N'67 Lê Trọng Tấn, Phường Tây Thạnh, Quận Tân Phú, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (16, N'nguyenanhminhhyh99@gmail.com', N'071613164910', N'123', CAST(N'1999-01-28' AS Date), N'Nguyễn Anh Minh', N'0934273600
', NULL, N'1698 Nguyễn Trọng Tuyển, Phường 15 , Quận Phú Nhuận, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (17, N'ngducphuc333@gmail.com', N'989781650610', N'123', CAST(N'1995-05-16' AS Date), N'Nguyễn Đỗ Ngọc MInh', N'0932074060
', NULL, N'393 Ngô Quyền, Phường 5, Quận 10, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (18, N'trahoangpsdhuc@gmail.com', N'716598716151', N'123', CAST(N'1995-10-19' AS Date), N'Nguyễn Đức Phúc', N'0932018337
', NULL, N'1880 Đào Duy Anh, Phường 9, Quận Phú Nhuận, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (19, N'trannguyenphuc133@gmail.com', N'365969891166', N'123', CAST(N'1997-07-01' AS Date), N'Trần Hoàng Phúc', N'0934273660
', NULL, N'879 Thích Quảng Đức, Phường 5, Quận Phú Nhuận, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (20, N'eriknguyen@gmail.com', N'065971623101', N'123', CAST(N'1998-06-03' AS Date), N'Erik Nguyễn', N'0934293070
', NULL, N'213 Phan Huy Ích, Phường 12, Quận Gò Vấp, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (21, N'ngtandat22@gmail.com', N'265981998626', N'123', CAST(N'1997-06-04' AS Date), N'Nguyễn Tấn Đạt', N'0933684770
', NULL, N'845 Võ Thị Sáu, Phường 6, Quận 3, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (22, N'daviddegeamu@gmail.com', N'219819711961', N'123', CAST(N'1997-03-05' AS Date), N'David Degea', N'0917152647
', NULL, N'1698 Nguyễn Duy Trinh, Phường Phú Hữu, Quận 9, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (23, N'brunofernades@gmail.com', N'263167891613', N'123', CAST(N'1992-08-03' AS Date), N'Bruno Fernades', N'0947858612
', NULL, N'452 Nơ Trang Long, Phường 13, Quận Bình Thạnh, TP. Hồ Chí Minh
', 0, 1)
INSERT [dbo].[User] ([UID], [Email], [CID], [Password], [DateOfBirth], [Fullname], [Phone], [Avartar], [Address], [Type], [Status]) VALUES (27, N'duong_test1@gmail.com', N'095109510951', N'123456', CAST(N'2002-02-05' AS Date), N'Duong Dong Duong', N'0782214617', N'1679344649515.JPG', N'12851 BÃ u CÃ¡t, PhÆ°á»ng 14, Quáº­n TÃ¢n BÃ¬nh, TP. Há» ChÃ­ Minh', 0, 1)
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD FOREIGN KEY([OID])
REFERENCES [dbo].[Owner] ([OID])
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD FOREIGN KEY([RoID])
REFERENCES [dbo].[Room] ([RoID])
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD FOREIGN KEY([UID])
REFERENCES [dbo].[User] ([UID])
GO
ALTER TABLE [dbo].[ContractInformation]  WITH CHECK ADD FOREIGN KEY([CoID])
REFERENCES [dbo].[Contract] ([CoID])
GO
ALTER TABLE [dbo].[Report]  WITH CHECK ADD FOREIGN KEY([OID])
REFERENCES [dbo].[Owner] ([OID])
GO
ALTER TABLE [dbo].[Report]  WITH CHECK ADD FOREIGN KEY([UID])
REFERENCES [dbo].[User] ([UID])
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD FOREIGN KEY([OID])
REFERENCES [dbo].[Owner] ([OID])
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD FOREIGN KEY([UID])
REFERENCES [dbo].[User] ([UID])
GO
ALTER TABLE [dbo].[RoomImage]  WITH CHECK ADD FOREIGN KEY([RoID])
REFERENCES [dbo].[Room] ([RoID])
GO
USE [master]
GO
ALTER DATABASE [ContractManager] SET  READ_WRITE 
GO
