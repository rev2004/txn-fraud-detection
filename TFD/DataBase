USE [FraudDetection]
GO

/****** Object:  Table [dbo].[Account]    Script Date: 04/22/2014 20:33:10 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Account](
	[AccountNum] [int] IDENTITY(100000,1) NOT NULL,
	[CustomerID] [int] NOT NULL,
	[CreditLine] [decimal](10, 2) NULL,
	[OpeningDate] [datetime] NOT NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKAccount] PRIMARY KEY CLUSTERED 
(
	[AccountNum] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [R_2] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO

ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [R_2]
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[CreditCard]    Script Date: 04/22/2014 20:33:21 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[CreditCard](
	[CreditCardNum] [bigint] IDENTITY(1000000,1) NOT NULL,
	[CustomerID] [int] NOT NULL,
	[AccountNum] [int] NOT NULL,
	[CreditCardType] [varchar](50) NOT NULL,
	[CardPin] [int] NOT NULL,
	[CardExpMMYY] [varchar](4) NOT NULL,
	[CurrentBalance] [decimal](8, 2) NULL,
	[LastBalance] [decimal](8, 2) NULL,
	[MinPayment] [decimal](8, 2) NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKCreditCard] PRIMARY KEY CLUSTERED 
(
	[CreditCardNum] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[CreditCard]  WITH CHECK ADD  CONSTRAINT [R_3] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO

ALTER TABLE [dbo].[CreditCard] CHECK CONSTRAINT [R_3]
GO

ALTER TABLE [dbo].[CreditCard]  WITH CHECK ADD  CONSTRAINT [R_8] FOREIGN KEY([AccountNum])
REFERENCES [dbo].[Account] ([AccountNum])
GO

ALTER TABLE [dbo].[CreditCard] CHECK CONSTRAINT [R_8]
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[Customer]    Script Date: 04/22/2014 20:33:45 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Customer](
	[CustomerID] [int] IDENTITY(1000,1) NOT NULL,
	[UserName] [varchar](50) NOT NULL,
	[Password] [varbinary](128) NULL,
	[Status] [varchar](1) NULL,
	[FirstName] [varchar](50) NOT NULL,
	[MiddleName] [varchar](50) NULL,
	[LastName] [varchar](50) NOT NULL,
	[DateOfBirth] [datetime] NOT NULL,
	[SSN] [varchar](11) NOT NULL,
	[Married] [char](1) NOT NULL,
	[Address] [varchar](100) NULL,
	[WorkAddress] [varchar](100) NULL,
	[WorkCity] [varchar](50) NULL,
	[City] [varchar](50) NULL,
	[State] [varchar](2) NULL,
	[ZipCode] [varchar](10) NULL,
	[HomePhone] [varchar](20) NULL,
	[CellPhone] [varchar](20) NULL,
	[Email] [varchar](100) NULL,
	[Text] [varchar](100) NULL,
	[Gender] [char](1) NULL,
	[WorkState] [varchar](2) NULL,
	[WorkZipCode] [varchar](10) NULL,
	[IsEmail] [int] NULL,
	[IsTxt] [int] NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKCustomer] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Customer] ADD  CONSTRAINT [DF_Customer_Married]  DEFAULT ('N') FOR [Married]
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[CustomerNotificationPreference]    Script Date: 04/22/2014 20:33:56 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[CustomerNotificationPreference](
	[CustomerID] [int] NOT NULL,
	[NotificationType] [varchar](100) NOT NULL,
	[Email] [varchar](100) NULL,
	[CellPhone] [varchar](20) NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKCustomerNotificationPreference] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC,
	[NotificationType] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[CustomerNotificationPreference]  WITH CHECK ADD  CONSTRAINT [R_4] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO

ALTER TABLE [dbo].[CustomerNotificationPreference] CHECK CONSTRAINT [R_4]
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[CustomerShoppingProfile]    Script Date: 04/22/2014 20:34:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[CustomerShoppingProfile](
	[CustomerID] [int] NOT NULL,
	[ProfileTypeID] [int] NOT NULL,
	[MinTransactionAmount] [decimal](8, 2) NULL,
	[MaxTransactionAmount] [decimal](8, 2) NULL,
	[NumofTransactionPerHour] [int] NULL,
	[ShoppingRadius] [int] NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKCustomerShoppingProfile] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC,
	[ProfileTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[CustomerShoppingProfile]  WITH CHECK ADD  CONSTRAINT [R_5] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO

ALTER TABLE [dbo].[CustomerShoppingProfile] CHECK CONSTRAINT [R_5]
GO

ALTER TABLE [dbo].[CustomerShoppingProfile]  WITH CHECK ADD  CONSTRAINT [R_6] FOREIGN KEY([ProfileTypeID])
REFERENCES [dbo].[ProfileType] ([ProfileTypeID])
GO

ALTER TABLE [dbo].[CustomerShoppingProfile] CHECK CONSTRAINT [R_6]
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[FraudAlertLog]    Script Date: 04/22/2014 20:34:21 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[FraudAlertLog](
	[AlertID] [int] IDENTITY(100000,1) NOT NULL,
	[TransactionNum] [bigint] NOT NULL,
	[CustomerID] [int] NOT NULL,
	[MailText] [varchar](1000) NULL,
	[Status] [varchar](1) NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [PK_FraudAlertLog] PRIMARY KEY CLUSTERED 
(
	[AlertID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[FraudAlertLog]  WITH CHECK ADD  CONSTRAINT [R_13] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO

ALTER TABLE [dbo].[FraudAlertLog] CHECK CONSTRAINT [R_13]
GO

ALTER TABLE [dbo].[FraudAlertLog]  WITH CHECK ADD  CONSTRAINT [R_15] FOREIGN KEY([TransactionNum])
REFERENCES [dbo].[Transactions] ([TransactionNum])
GO

ALTER TABLE [dbo].[FraudAlertLog] CHECK CONSTRAINT [R_15]
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[FraudTransaction]    Script Date: 04/22/2014 20:34:39 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[FraudTransaction](
	[TransactionNum] [bigint] NOT NULL,
	[FraudTypeID] [int] NOT NULL,
	[Status] [varchar](1) NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKFraudTransaction] PRIMARY KEY CLUSTERED 
(
	[TransactionNum] ASC,
	[FraudTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[FraudType]    Script Date: 04/22/2014 20:34:53 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[FraudType](
	[FraudTypeID] [int] IDENTITY(1,1) NOT NULL,
	[FraudTypeDescription] [varchar](50) NOT NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKFraudType] PRIMARY KEY CLUSTERED 
(
	[FraudTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[ProfileType]    Script Date: 04/22/2014 20:35:05 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[ProfileType](
	[ProfileTypeID] [int] IDENTITY(1,1) NOT NULL,
	[ProfileTypeDescription] [varchar](1000) NOT NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKProfileType] PRIMARY KEY CLUSTERED 
(
	[ProfileTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[Status_Desc]    Script Date: 04/22/2014 20:35:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Status_Desc](
	[Status] [varchar](1) NOT NULL,
	[Description] [varchar](100) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[TFD_Calendar]    Script Date: 04/22/2014 20:35:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[TFD_Calendar](
	[DateKey] [datetime] NOT NULL,
	[BusinessDay_YN] [char](1) NOT NULL,
	[WeekEnd_YN] [char](1) NOT NULL,
	[Holiday_YN] [char](1) NOT NULL,
	[Description] [varchar](30) NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKTFD_Calendar] PRIMARY KEY CLUSTERED 
(
	[DateKey] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[TFD_Calendar] ADD  CONSTRAINT [DF_TFD_Calendar_BusinessDay_YN]  DEFAULT ('Y') FOR [BusinessDay_YN]
GO

ALTER TABLE [dbo].[TFD_Calendar] ADD  CONSTRAINT [DF_TFD_Calendar_WeekEnd_YN]  DEFAULT ('N') FOR [WeekEnd_YN]
GO

ALTER TABLE [dbo].[TFD_Calendar] ADD  CONSTRAINT [DF_TFD_Calendar_Holiday_YN]  DEFAULT ('N') FOR [Holiday_YN]
GO

USE [FraudDetection]
GO

/****** Object:  Table [dbo].[Transactions]    Script Date: 04/22/2014 20:35:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Transactions](
	[TransactionNum] [bigint] IDENTITY(100000,1) NOT NULL,
	[CreditCardNum] [bigint] NOT NULL,
	[TransactionDateTime] [datetime] NOT NULL,
	[Status] [varchar](1) NULL,
	[Amount] [decimal](8, 2) NOT NULL,
	[Description] [varchar](1000) NULL,
	[MerchantName] [varchar](100) NOT NULL,
	[MerchantAddress] [varchar](100) NOT NULL,
	[MerchantCity] [varchar](50) NOT NULL,
	[MerchantState] [varchar](2) NOT NULL,
	[MerchantZipCode] [varchar](10) NOT NULL,
	[MerchantCountry] [varchar](50) NULL,
	[MerchantPhone] [varchar](20) NULL,
	[TransactionRefNum] [varchar](50) NOT NULL,
	[CreatedBy] [varchar](50) NULL,
	[CreatedTstamp] [datetime] NULL,
	[UpdatedBy] [varchar](50) NULL,
	[UpdatedTstamp] [datetime] NULL,
 CONSTRAINT [XPKTransaction] PRIMARY KEY CLUSTERED 
(
	[TransactionNum] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Transactions]  WITH CHECK ADD  CONSTRAINT [R_7] FOREIGN KEY([CreditCardNum])
REFERENCES [dbo].[CreditCard] ([CreditCardNum])
GO

ALTER TABLE [dbo].[Transactions] CHECK CONSTRAINT [R_7]
GO

