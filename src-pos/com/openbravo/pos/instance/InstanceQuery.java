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

package com.openbravo.pos.instance;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author adrianromero
 */
public class InstanceQuery {
    
    private final AppMessage m_appstub;
    
    /** Creates a new instance of InstanceQuery
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException */
    public InstanceQuery() throws RemoteException, NotBoundException {
        
        Registry registry = LocateRegistry.getRegistry();           
        m_appstub = (AppMessage) registry.lookup("AppMessage");
    }
    
    /**
     *
     * @return
     */
    public AppMessage getAppMessage() {
        return m_appstub;
    }
}
