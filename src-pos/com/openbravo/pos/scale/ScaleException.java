//    PDS oPos  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2014 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of PDS oPos
//
//    PDS oPos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   PDS oPos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with PDS oPos.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.scale;

/**
 *
 * @author JG uniCenta
 */
public class ScaleException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>ScaleException</code> without detail message.
     */
    public ScaleException() {
    }
     
    /**
     * Constructs an instance of <code>ScaleException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ScaleException(String msg) {
        super(msg);
    }
}
