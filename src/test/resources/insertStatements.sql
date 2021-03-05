
Truncate table [Booking].[Availability];
Truncate table [Booking].[VisitorBookingData];

--Insert statements in Availability for testing

INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate(), 10, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');

INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+1, 10, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');


INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+2, 20, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');



INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+3, 20, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');


INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+5, 20, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');


INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+6, 20, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');



INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+30, 20, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');


INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+31, 20, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');




INSERT INTO [Booking].[Availability] ([AvailableDate]
, [AllowedNumberOfVisitors]
, [BookedNumberOfVisitors]
, [CreateDate]
, [UpdateDate]
, [CreatedBy]
, [UpdatedBy])
  VALUES (getDate()+32, 20, 0, GETDATE(), GETDATE(), 'Insert', 'Insert');

