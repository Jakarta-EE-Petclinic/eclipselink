/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     bdoughan - Mar 27/2009 - 2.0 - Initial implementation
package org.eclipse.persistence.testing.sdo.helper.jaxbhelper.changesummary;

public class Child2 {

    private int id;
    private Child1 child1;
    private Child1 child1Attribute;

    public Child2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Child1 getChild1() {
        return child1;
    }

    public void setChild1(Child1 child1) {
        this.child1 = child1;
    }

    public Child1 getChild1Attribute() {
        return child1Attribute;
    }

    public void setChild1Attribute(Child1 child1Attribute) {
        this.child1Attribute = child1Attribute;
    }

}
