--    PDS oPos - Touch Friendly Point Of Sale
--    Copyright (C) 2009-2014 uniCenta
--    http://www.unicenta.net
--
--    This file is part of PDS oPos.
--
--    PDS oPos is free software: you can redistribute it and/or modify
--    it under the terms of the GNU General Public License as published by
--    the Free Software Foundation, either version 3 of the License, or
--    (at your option) any later version.
--
--    PDS oPos is distributed in the hope that it will be useful,
--    but WITHOUT ANY WARRANTY; without even the implied warranty of
--    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--    GNU General Public License for more details.
--
--    You should have received a copy of the GNU General Public License
--    along with PDS oPos.  If not, see <http://www.gnu.org/licenses/>.

-- Database updater
-- JDL 
-- Add new column to places table
ALTER TABLE PLACES ADD COLUMN CUSTOMER VARCHAR(256);
ALTER TABLE PLACES ADD COLUMN WAITER VARCHAR(256);
ALTER TABLE PLACES ADD COLUMN TICKETID VARCHAR(256);
ALTER TABLE PLACES ADD COLUMN TABLEMOVED  NUMERIC(1) DEFAULT 0 NOT NULL;
ALTER TABLE PRODUCTS ADD COLUMN WARRANTY  NUMERIC(1) DEFAULT 0 NOT NULL;
ALTER TABLE SHAREDTICKETS ADD COLUMN PICKUPID INTEGER DEFAULT 0 NOT NULL;
CREATE SEQUENCE PICKUP_NUMBER START WITH 1;
ALTER TABLE STOCKDIARY ADD COLUMN AppUser VARCHAR(256);

UPDATE APPJL SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};
