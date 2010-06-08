/*******************************************************************************
 * Copyright (c) 2005, 2009 SAP. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     SAP - initial API and implementation
 ******************************************************************************/

package org.eclipse.persistence.testing.models.wdf.jpa1.fancy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TMP_PLANT")
@SequenceGenerator(name = "SequenceGeneratorInc3", sequenceName = "testSequenceInc3", allocationSize = 3)
public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;

    public Plant(String aName) {
        name = aName;
    }

    private Integer id;
    private String name;

    public Plant() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceGeneratorInc3")
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    protected void setId(Integer aId) {
        id = aId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Plant) {
            Plant other = (Plant) obj;
            return other.name.equals(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (name == null) {
            return 0;
        }
        return name.hashCode();
    }
}
