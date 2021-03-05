

DROP TABLE IF EXISTS [Booking].[VisitorBookingData];

DROP TABLE IF EXISTS [Booking].[Availability];

IF NOT EXISTS ( SELECT  *
                FROM    sys.schemas
                WHERE   name = N'Booking' )
    EXEC('CREATE SCHEMA [Booking]');

