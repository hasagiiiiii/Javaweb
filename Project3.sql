USE [Project3]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[id_Account] [int] IDENTITY(1,1) NOT NULL,
	[firstName] [nvarchar](100) NULL,
	[lastName] [nvarchar](100) NULL,
	[userName] [nvarchar](255) NULL,
	[password] [nvarchar](255) NULL,
	[ImgUser] [nvarchar](max) NULL,
	[role_id] [nvarchar](244) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_Account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[id_Cart] [int] IDENTITY(1,1) NOT NULL,
	[id_Account] [int] NULL,
	[id_Product] [int] NULL,
	[quantitty] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_Cart] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[idCategory] [int] IDENTITY(1,1) NOT NULL,
	[nameCategory] [nvarchar](254) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCategory] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Color]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Color](
	[id_Color] [int] IDENTITY(1,1) NOT NULL,
	[color] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_Color] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderProduct]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderProduct](
	[id_Order] [int] IDENTITY(1,1) NOT NULL,
	[id_Account] [int] NULL,
	[id_Product] [int] NULL,
	[quantity] [int] NULL,
	[Address] [nvarchar](max) NULL,
	[Zip] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_Order] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id_product] [int] IDENTITY(1,1) NOT NULL,
	[nameProduct] [nvarchar](250) NULL,
	[startProduct] [int] NULL,
	[price] [float] NULL,
	[sale] [int] NULL,
	[description] [nvarchar](max) NULL,
	[trademark] [nvarchar](200) NULL,
	[quantityPro] [int] NULL,
	[imgPro] [nvarchar](max) NULL,
	[colorPro] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_product] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role_manager]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_manager](
	[id_role] [int] NOT NULL,
	[role_name] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_role] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Trademark]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Trademark](
	[id_trademark] [int] IDENTITY(1,1) NOT NULL,
	[name_trademark] [nvarchar](254) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_trademark] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Wishlist]    Script Date: 4/19/2024 9:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Wishlist](
	[id_Wishlist] [int] IDENTITY(1,1) NOT NULL,
	[id_Account] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_Wishlist] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([id_Account], [firstName], [lastName], [userName], [password], [ImgUser], [role_id]) VALUES (1, N'Văn', N'Trung', N'TrungLiver', N'admin', N'229f215ed3f20cac55e3-e1683722764737.jpg', N'admin')
INSERT [dbo].[Account] ([id_Account], [firstName], [lastName], [userName], [password], [ImgUser], [role_id]) VALUES (12, N'do', N'trung', N'Dovantrung', N'123123', N'backstage_carousel_allah-las-1200x1200.jpeg', N'guest')
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Cart] ON 

INSERT [dbo].[Cart] ([id_Cart], [id_Account], [id_Product], [quantitty]) VALUES (1, 1, 4, 2)
INSERT [dbo].[Cart] ([id_Cart], [id_Account], [id_Product], [quantitty]) VALUES (2, 1, 5, 1)
INSERT [dbo].[Cart] ([id_Cart], [id_Account], [id_Product], [quantitty]) VALUES (3, 1, 6, 1)
INSERT [dbo].[Cart] ([id_Cart], [id_Account], [id_Product], [quantitty]) VALUES (9, 12, 4, 1)
SET IDENTITY_INSERT [dbo].[Cart] OFF
GO
SET IDENTITY_INSERT [dbo].[Color] ON 

INSERT [dbo].[Color] ([id_Color], [color]) VALUES (1, N'black')
SET IDENTITY_INSERT [dbo].[Color] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderProduct] ON 

INSERT [dbo].[OrderProduct] ([id_Order], [id_Account], [id_Product], [quantity], [Address], [Zip]) VALUES (1, 12, 4, 1, N'Nguyễn Trãi', N'1900')
INSERT [dbo].[OrderProduct] ([id_Order], [id_Account], [id_Product], [quantity], [Address], [Zip]) VALUES (2, 12, 4, 1, N'Nguyễn Trãi', N'1900')
INSERT [dbo].[OrderProduct] ([id_Order], [id_Account], [id_Product], [quantity], [Address], [Zip]) VALUES (3, 12, 4, 1, N'Nguyễn Trãi', N'1900')
INSERT [dbo].[OrderProduct] ([id_Order], [id_Account], [id_Product], [quantity], [Address], [Zip]) VALUES (4, 12, 5, 1, N'Nguyễn Trãi', N'1900')
SET IDENTITY_INSERT [dbo].[OrderProduct] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([id_product], [nameProduct], [startProduct], [price], [sale], [description], [trademark], [quantityPro], [imgPro], [colorPro]) VALUES (4, N'MARSHALL MAJOR 4', 0, 2990000, 10, N'Tai nghe Marshall Major 4 mang thiết kế đặc trưng của Marshall cho khả năng chơi nhạc không dây lên đến 80 giờ liên tục, bổ sung thêm tính năng sạc không dây và thiết kế được cải tiến đem đến sự thoải mái vượt trội và tiện dụng hơn. Các dải âm được bổ sung tạo ra âm trầm mạnh mẽ, âm trung mượt mà và âm bổng tuyệt vời khiến cho khoảnh khắc thưởng nhạc trở nên trọn vẹn hơn bao giờ hết.', N'Marshall', 10, N'Marshall-Major4.png', N'black')
INSERT [dbo].[Product] ([id_product], [nameProduct], [startProduct], [price], [sale], [description], [trademark], [quantityPro], [imgPro], [colorPro]) VALUES (5, N'MARSHALL EMBERTON', 0, 4390000, 10, N'Loa Marshall Emberton DIAMOND JUBILEE là chiếc loa di động nhỏ gọn với âm thanh mạnh mẽ và sống động mà chỉ Marshall có thể đem lại. Marshall Emberton sử dụng công nghệ True Stereophonic, một dạng âm thanh đa hướng độc đáo từ Marshall giúp bạn trải nghiệm âm thanh 360° t tuyệt vời dù ở bất kì vị trí nào trong hơn 20 giờ chơi nhạc.', N'Marshall', 20, N'Chuan-frame-website-10.png', N'black')
INSERT [dbo].[Product] ([id_product], [nameProduct], [startProduct], [price], [sale], [description], [trademark], [quantityPro], [imgPro], [colorPro]) VALUES (6, N'MARSHALL WOBURN 3', 0, 11390000, 20, N'Loa Marshall Woburn 3 là loa lớn nhất trong dòng sản phẩm âm thanh dành cho gia đình. Marshall đã đưa dòng loa gia đình mang đặc trưng của tinh thần rock ‘n’ roll với diện mạo hoàn mỹ hơn tạo nên một hiện tượng trong giới điệu mộ âm thanh. Thiết kế mang tính biểu tượng đặc trưng của nó đánh bật tất cả các loa khác khỏi thị trường', N'Marshall', 10, N'marshall-woburn-iii-black-01.webp', N'black')
INSERT [dbo].[Product] ([id_product], [nameProduct], [startProduct], [price], [sale], [description], [trademark], [quantityPro], [imgPro], [colorPro]) VALUES (7, N'MARSHALL STANMORE 3', 0, 7890000, 5, N'', N'Marshall', 10, N'marshall-kilburn-ii-black-brass-01.png', N'black')
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
INSERT [dbo].[Role_manager] ([id_role], [role_name]) VALUES (1, N'admin')
INSERT [dbo].[Role_manager] ([id_role], [role_name]) VALUES (2, N'guest')
GO
SET IDENTITY_INSERT [dbo].[Trademark] ON 

INSERT [dbo].[Trademark] ([id_trademark], [name_trademark]) VALUES (1, N'Marshall')
SET IDENTITY_INSERT [dbo].[Trademark] OFF
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([id_Product])
REFERENCES [dbo].[Product] ([id_product])
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([id_Account])
REFERENCES [dbo].[Account] ([id_Account])
GO
ALTER TABLE [dbo].[Wishlist]  WITH CHECK ADD FOREIGN KEY([id_Account])
REFERENCES [dbo].[Account] ([id_Account])
GO
