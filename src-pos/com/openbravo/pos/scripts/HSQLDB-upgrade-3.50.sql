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

-- Database upgrade script for HSQLDB
-- v3.50 - v3.55

--
-- UPDATE existing tables
--
UPDATE ROLES SET PERMISSIONS = $FILE{/com/openbravo/pos/templates/Role.Administrator.xml} WHERE ID = '0';

UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Menu.Root.txt} WHERE ID = '0';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.CloseCash.xml} WHERE ID = '25';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.CustomerPaid.XML} WHERE ID = '26';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.CustomerPaid2.xml} WHERE ID = '27';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.PartialCash.xml} WHERE ID = '31';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.Ticket.xml} WHERE ID = '33';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.Ticket2.xml} WHERE ID = '34';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.TicketPreview.xml} WHERE ID = '37';

--
-- ALTER existing tables
--
ALTER TABLE CSVIMPORT ALTER COLUMN PRICEBUY SET DEFAULT NULL;
ALTER TABLE CSVIMPORT ALTER COLUMN PRICESELL SET DEFAULT NULL;
ALTER TABLE CSVIMPORT ALTER COLUMN PREVIOUSBUY SET DEFAULT NULL;
ALTER TABLE CSVIMPORT ALTER COLUMN PREVIOUSSELL SET DEFAULT NULL;

ALTER TABLE PAYMENTS ALTER COLUMN TENDERED SET DEFAULT NULL;
ALTER TABLE PAYMENTS ADD COLUMN CARDNAME VARCHAR(255);
UPDATE PAYMENTS SET TENDERED = TOTAL WHERE TENDERED = 0;

ALTER TABLE PRODUCTS ALTER COLUMN STOCKCOST SET DEFAULT NULL;
ALTER TABLE PRODUCTS ALTER COLUMN STOCKVOLUME SET DEFAULT NULL;

ALTER TABLE STOCKCURRENT ALTER COLUMN UNITS SET DEFAULT NULL;

ALTER TABLE STOCKDIARY ALTER COLUMN UNITS SET DEFAULT NULL;
ALTER TABLE STOCKDIARY ALTER COLUMN PRICE SET DEFAULT NULL;

ALTER TABLE STOCKLEVEL ALTER COLUMN STOCKSECURITY SET DEFAULT NULL;
ALTER TABLE STOCKLEVEL ALTER COLUMN STOCKMAXIMUM SET DEFAULT NULL;

ALTER TABLE TICKETLINES ALTER COLUMN UNITS SET DEFAULT NULL;
ALTER TABLE TICKETLINES ALTER COLUMN PRICE SET DEFAULT NULL;

-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;