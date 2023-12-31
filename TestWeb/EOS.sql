USE [EOS]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[userName] [nvarchar](100) NOT NULL,
	[password] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[examCode]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[examCode](
	[examCode] [nvarchar](50) NOT NULL,
	[subjectId] [nvarchar](15) NULL,
	[examingTime] [int] NULL,
	[isStatus] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[examCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Grade]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Grade](
	[SubjectID] [nvarchar](15) NOT NULL,
	[StudentID] [nvarchar](10) NOT NULL,
	[TeacherID] [nvarchar](10) NULL,
	[Mark] [int] NOT NULL,
	[time] [date] NULL,
 CONSTRAINT [PK_Grade] PRIMARY KEY CLUSTERED 
(
	[SubjectID] ASC,
	[StudentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Learning]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Learning](
	[SubjectID] [nvarchar](15) NOT NULL,
	[StudentID] [nvarchar](10) NOT NULL,
	[Semester] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SubjectID] ASC,
	[StudentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Questions]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Questions](
	[QuestionID] [nvarchar](10) NOT NULL,
	[SubjectID] [nvarchar](15) NOT NULL,
	[descirption] [text] NOT NULL,
	[answer] [text] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[QuestionID] ASC,
	[SubjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
	[StudentAccount] [nvarchar](50) NOT NULL,
	[StudentID] [nvarchar](10) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[StudentName] [nvarchar](50) NOT NULL,
	[StudentEmail] [nvarchar](50) NOT NULL,
	[StudentPhone] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[StudentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subjects]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subjects](
	[SubjectID] [nvarchar](15) NOT NULL,
	[SubjectName] [nvarchar](50) NOT NULL,
	[Semester] [int] NOT NULL,
 CONSTRAINT [PK__Subjects__AC1BA388EC28454D] PRIMARY KEY CLUSTERED 
(
	[SubjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teachers]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teachers](
	[TeacherAccount] [nvarchar](50) NOT NULL,
	[TeacherID] [nvarchar](10) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[TeacherName] [nvarchar](50) NOT NULL,
	[TeacherEmail] [nvarchar](50) NOT NULL,
	[TeacherPhone] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TeacherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teaching]    Script Date: 3/22/2023 2:51:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teaching](
	[SubjectID] [nvarchar](15) NOT NULL,
	[TeacherID] [nvarchar](10) NOT NULL,
	[Semester] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SubjectID] ASC,
	[TeacherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([userName], [password]) VALUES (N'admin', N'123')
INSERT [dbo].[Account] ([userName], [password]) VALUES (N'nghia', N'123')
INSERT [dbo].[Account] ([userName], [password]) VALUES (N'quang', N'123')
GO
INSERT [dbo].[examCode] ([examCode], [subjectId], [examingTime], [isStatus]) VALUES (N'MAS291_Sp23', N'mas', 60, 1)
INSERT [dbo].[examCode] ([examCode], [subjectId], [examingTime], [isStatus]) VALUES (N'prj301_Sp23', N'PRJ', 60, 0)
GO
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'CSD', N'he162849', NULL, 8, CAST(N'2023-03-01' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'CSD', N'he163052', NULL, 8, CAST(N'2023-03-02' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'CSD', N'he163932', NULL, 8, CAST(N'2023-03-02' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'CSD', N'he172848', NULL, 5, CAST(N'2023-03-09' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'DBI', N'he162849', NULL, 9, CAST(N'2023-03-03' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'DBI', N'he163052', NULL, 9, CAST(N'2023-03-03' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'DBI', N'he163932', NULL, 9, CAST(N'2023-03-02' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'DBI', N'he172848', NULL, 6, CAST(N'2023-03-03' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'iot', N'he162849', NULL, 9, CAST(N'2022-11-03' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'iot', N'he163052', NULL, 9, CAST(N'2023-03-10' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'iot', N'he163932', NULL, 7, CAST(N'2023-03-04' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'jpd', N'he163932', NULL, 8, CAST(N'2023-03-04' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'jpd', N'he172848', NULL, 8, CAST(N'2023-03-02' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'mas', N'he163052', NULL, 9, CAST(N'2023-03-03' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'mas', N'he163932', NULL, 9, CAST(N'2023-03-03' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'prj', N'he163052', NULL, 8, CAST(N'2023-03-08' AS Date))
INSERT [dbo].[Grade] ([SubjectID], [StudentID], [TeacherID], [Mark], [time]) VALUES (N'prj', N'he163932', NULL, 8, CAST(N'2023-03-01' AS Date))
GO
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'1', N'iot', N'IoT gateways perform several critical functions such as: (Which one is wrong).', N' Improving networks')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'1', N'mas', N'Find the standard deviation for the given sample data: 2 6 2 2 1 4 4 2 4 2 3 8 4 2 2 7 7 2 3 11', N'2.6')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'1', N'prj', N'A JSP page called test.jsp is passed a parameter name in the URL using http://localhost/Final/test.jsp?name=John. The test.jsp contains the following code. <% String myName=request.getParameter("name");%> <% String test= "Welcome " + myName; %> <%=test%> What is the output? Select one:', N'The page display "Welcome John"')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'2', N'iot', N'An IoT gateway device bridges the communication gap between: (Which one is wrong).', N' end users')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'2', N'mas', N'Survey responses of " good, better, best". which type of data is?', N'Ordinal')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'2', N'prj', N'Which scripting element lets you define methods or fields that get inserted into the main body of the servlet class (outside of the _jspService method that is called by service to process the request)? Select one:', N'declaration e. comment')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'3', N'prj', N'Which method returns the actual length of the request sent by the client? Select one:', N'getContentLength()')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'4', N'mas', N'Find the mean for the binomial distribution which has the stated values of n and p. Round answer to the nearest tenth. n = 20; p = 3/5', N'12.0')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'4', N'prj', N'Which of the followings is a correct syntax of the method that is used to get the initialized parameter in ServletContext or ServletConfig? Select one:', N'String getInitParameter(String name);')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'5', N'DBI', N'select * from account', N'account')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'5', N'iot', N'Before purchasing one gateway device you should consider: (Which one is wrong).', N'Uptime')
INSERT [dbo].[Questions] ([QuestionID], [SubjectID], [descirption], [answer]) VALUES (N'5', N'prj', N'To send text outptut in a response, the following method of HttpServletResponse may be used to get the appropriate Writer/Stream object. Select one or more:', N'getOutputStream and  getWrite')
GO
INSERT [dbo].[Students] ([StudentAccount], [StudentID], [Password], [StudentName], [StudentEmail], [StudentPhone]) VALUES (N'namhe172349', N'he162849', N'nam234', N'dao ngoc nam', N'namdnhe162849@fpt.edu.vn', N'0937638593')
INSERT [dbo].[Students] ([StudentAccount], [StudentID], [Password], [StudentName], [StudentEmail], [StudentPhone]) VALUES (N'manh', N'he162939', N'123', N'Vu van manh', N'manhVvhe162939@fpt.edu.vn', N'0923742743')
INSERT [dbo].[Students] ([StudentAccount], [StudentID], [Password], [StudentName], [StudentEmail], [StudentPhone]) VALUES (N'giang123774', N'he163052', N'gaing123', N'nguyen truong giang', N'giangnthe163052@fpt.edu.vn', N'093475753')
INSERT [dbo].[Students] ([StudentAccount], [StudentID], [Password], [StudentName], [StudentEmail], [StudentPhone]) VALUES (N'quangcdhe163932', N'HE163932', N'quang123', N'cao dang quang', N'quangcdhe163932@fpt.edu.vn', N'07992364628')
INSERT [dbo].[Students] ([StudentAccount], [StudentID], [Password], [StudentName], [StudentEmail], [StudentPhone]) VALUES (N'hung', N'he172848', N'hung123', N'ngo van hung', N'hungnvhe172848@fpt.edu.vn', N'0926464325')
INSERT [dbo].[Students] ([StudentAccount], [StudentID], [Password], [StudentName], [StudentEmail], [StudentPhone]) VALUES (N'hongAnh', N'he172937', N'123', N'Le Quang Hong Anh', N'AnhLQHhe172937@fpt.edu.vn', N'01924727467')
GO
INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Semester]) VALUES (N'CSD', N'Cau truc du lieu va giai thuat', 3)
INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Semester]) VALUES (N'DBI', N'cau lenh sql', 3)
INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Semester]) VALUES (N'iot', N'internet of things', 4)
INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Semester]) VALUES (N'jpd', N'Nhat', 4)
INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Semester]) VALUES (N'mas', N'toan cao cap', 4)
INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Semester]) VALUES (N'prj', N'Java web', 4)
GO
ALTER TABLE [dbo].[examCode]  WITH CHECK ADD FOREIGN KEY([subjectId])
REFERENCES [dbo].[Subjects] ([SubjectID])
GO
ALTER TABLE [dbo].[Grade]  WITH CHECK ADD  CONSTRAINT [FK__Grade__StudentID__35BCFE0A] FOREIGN KEY([StudentID])
REFERENCES [dbo].[Students] ([StudentID])
GO
ALTER TABLE [dbo].[Grade] CHECK CONSTRAINT [FK__Grade__StudentID__35BCFE0A]
GO
ALTER TABLE [dbo].[Grade]  WITH CHECK ADD  CONSTRAINT [FK__Grade__SubjectID__34C8D9D1] FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subjects] ([SubjectID])
GO
ALTER TABLE [dbo].[Grade] CHECK CONSTRAINT [FK__Grade__SubjectID__34C8D9D1]
GO
ALTER TABLE [dbo].[Grade]  WITH CHECK ADD  CONSTRAINT [FK__Grade__TeacherID__36B12243] FOREIGN KEY([TeacherID])
REFERENCES [dbo].[Teachers] ([TeacherID])
GO
ALTER TABLE [dbo].[Grade] CHECK CONSTRAINT [FK__Grade__TeacherID__36B12243]
GO
ALTER TABLE [dbo].[Learning]  WITH CHECK ADD FOREIGN KEY([StudentID])
REFERENCES [dbo].[Students] ([StudentID])
GO
ALTER TABLE [dbo].[Learning]  WITH CHECK ADD  CONSTRAINT [FK__Learning__Subjec__30F848ED] FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subjects] ([SubjectID])
GO
ALTER TABLE [dbo].[Learning] CHECK CONSTRAINT [FK__Learning__Subjec__30F848ED]
GO
ALTER TABLE [dbo].[Questions]  WITH CHECK ADD  CONSTRAINT [FK__Questions__Subje__267ABA7A] FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subjects] ([SubjectID])
GO
ALTER TABLE [dbo].[Questions] CHECK CONSTRAINT [FK__Questions__Subje__267ABA7A]
GO
ALTER TABLE [dbo].[Teaching]  WITH CHECK ADD  CONSTRAINT [FK__Teaching__Subjec__2D27B809] FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subjects] ([SubjectID])
GO
ALTER TABLE [dbo].[Teaching] CHECK CONSTRAINT [FK__Teaching__Subjec__2D27B809]
GO
ALTER TABLE [dbo].[Teaching]  WITH CHECK ADD FOREIGN KEY([TeacherID])
REFERENCES [dbo].[Teachers] ([TeacherID])
GO
