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

-- Database upgrade script for MySQL
-- v3.55 - v3.56

--
-- UPDATE existing tables
--

--
-- ALTER existing tables
--
DROP TABLE TICKETSNUM_PAYMENT;
CREATE TABLE TICKETSNUM_PAYMENT (
    ID INTEGER not null AUTO_INCREMENT,
PRIMARY KEY(ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO TICKETSNUM_PAYMENT VALUES (DEFAULT);

-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;