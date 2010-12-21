/*******************************************************************************
 * Copyright (c) 1998, 2010 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     05/29/2008-1.0M8 Andrei Ilitchev. 
 *       - New file introduced to consolidate Oracle-specific JPA tests.
 ******************************************************************************/  
package org.eclipse.persistence.testing.tests;

import junit.framework.TestSuite;
import junit.framework.Test;

import org.eclipse.persistence.testing.tests.jpa.customfeatures.CustomFeaturesJUnitTestSuite;

public class OracleJPACustomFeaturesTestSuite extends TestSuite{
    
    public static Test suite() {
        TestSuite fullSuite = new TestSuite();
        fullSuite.setName("OracleJPACustomFeaturesTestSuite");

        fullSuite.addTest(CustomFeaturesJUnitTestSuite.suite());
        
        return fullSuite;
    }
}
