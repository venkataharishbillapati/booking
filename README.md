**Tables Description:**
As The users will need to find out when the campsite availability, I created a table ([Booking].[Availability]) to fetch available dates and the number of available visitor slots.  
[Booking].[VisitorBookingData] table will provide information regarding the visitor's demographic data and booking information.

**Working:**
1. When a user searches for the campsite availability, please call **/V1/Availability** GET endpoint, the number of available slots will be returned back based on each date.
2. For making a reservation, please call **/V1/Reserve** POST endpoint, which will validate the available slots by fetching data from the table([Booking].[Availability]). And if slots are available, it will confirm the reservation and save it in table([Booking].[VisitorBookingData]) and update the [BookedNumberOfVisitors] in ([Booking].[Availability]) table. 
3. Once the reservation is confirmed, I return a unique Confirmation Code for future use.
4. By using confirmation code, we can update the user demographic data (Full name or email) using **V1/Reserve/{{ConfirmationCode}}** PATCH endpoint.
5. For cancellation, please pass the confirmation code using **V1/Reserve/{{ConfirmationCode}}/Cancel** PATCH endpoint.
6. To check the status of the confirmed reservation, please use **V1/Reserve/{{ConfirmationCode}}** GET endpoint.

**NOTE:** 
1. This project uses Microsoft SQL Server.
2. localhost port number available at 1234, if it needs to be changed, please update it in application.yml in the classpath of the project.
3. I am attaching the postman collection in the project for easy testing.


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


**Insert statements in Availability table for testing.**


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


