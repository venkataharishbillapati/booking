
I created a table called Availability, where based on the date, we can insert the number of visitors allowed per day.
Using that information, I validated the input of consumer who tries to book and I update the BookedNumberOfVisitors column with number of people booked.
I developed this project using Microsoft SQL Server.

I used port number 1234 for the project, if it needs to be changed, please update it in application.yml in the classpath of the project.

I am attaching the postman collection into the project which will be helpful for testing.


Please create a database with name Upgrade and run the below sqls for creating tables:
--------------------------------------------------------------------------------------


CREATE SCHEMA [Booking];

CREATE TABLE [Booking].[VisitorBookingData] (
  [Id] [bigint] IDENTITY (1, 1) NOT NULL,
  [Email] varchar(512) NOT NULL,
  [FullName] varchar(512) NOT NULL,
  [BookedCheckInDate] date NOT NULL,
  [BookedCheckOutDate] date NOT NULL,
  [ConfirmationCode] varchar(256) NOT NULL,
  [NumberOfVisitors] int NOT NULL,
  [Status] varchar(55) NOT NULL,
  [CreateDate] [datetime] NOT NULL,
  [CreatedBy] [varchar](55) NOT NULL,
  [UpdateDate] [datetime] NOT NULL,
  [UpdatedBy] [varchar](55) NOT NULL,
  CONSTRAINT PK_VisitorBookingData_Id PRIMARY KEY ([Id]),
  CONSTRAINT UK_VisitorBookingData_ConfirmationCode UNIQUE ([ConfirmationCode]),
  CONSTRAINT CHK_VisitorBookingData_Status CHECK (Status IN ('Confirmed', 'Cancelled'))
)


CREATE TABLE [Booking].[Availability] (
  [Id] [bigint] IDENTITY (1, 1) NOT NULL,
  [AvailableDate] [date] NOT NULL,
  [AllowedNumberOfVisitors] [int] NOT NULL,
  [BookedNumberOfVisitors] [int] NOT NULL DEFAULT (0),
  [CreateDate] [datetime] NOT NULL,
  [UpdateDate] [datetime] NOT NULL,
  [CreatedBy] [varchar](55) NOT NULL,
  [UpdatedBy] [varchar](55) NOT NULL,
  CONSTRAINT PK_Availability_Id PRIMARY KEY ([Id]),
  CONSTRAINT UK_Availability_Date UNIQUE ([AvailableDate])
)





=========================================================


Insert statements in Availability table for testing.


USE [Upgrade]
GO

INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate(), 10, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');

INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+1, 10, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');


INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+2, 20, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');



INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+3, 20, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');


INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+5, 20, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');


INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+6, 20, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');



INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+30, 20, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');


INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+31, 20, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');




INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+32, 20, 0, GETDATE(), GETDATE(), 'Manual Insert', 'Manual Insert');


