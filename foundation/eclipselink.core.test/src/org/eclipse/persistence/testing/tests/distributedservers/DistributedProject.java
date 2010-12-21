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
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.tests.distributedservers;

import org.eclipse.persistence.descriptors.RelationalDescriptor;
import org.eclipse.persistence.mappings.DirectToFieldMapping;
import org.eclipse.persistence.mappings.OneToManyMapping;
import org.eclipse.persistence.mappings.OneToOneMapping;
import org.eclipse.persistence.sessions.DatabaseLogin;

/**
 * This class was generated by the TopLink project class generator.
 * It stores the meta-data (descriptors) that define the TopLink mappings.
 * @see org.eclipse.persistence.sessions.factories.ProjectClassGenerator
 */
public class DistributedProject extends org.eclipse.persistence.sessions.Project {

    public DistributedProject() {
        setName("DistributedProject");
        applyLogin();

        addDescriptor(buildCompanyDescriptor());
        addDescriptor(buildDist_EmployeeDescriptor());
        addDescriptor(buildItemDescriptor());
    }

    public void applyLogin() {
        DatabaseLogin login = new DatabaseLogin();
        setLogin(login);
    }

    public RelationalDescriptor buildCompanyDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.tests.distributedservers.Company.class);
        descriptor.addTableName("DIST_COMPANY");
        descriptor.addPrimaryKeyFieldName("DIST_COMPANY.ID");

        // Descriptor properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.useRemoteSoftCacheWeakIdentityMap();
        descriptor.setRemoteIdentityMapSize(100);
        descriptor.setSequenceNumberFieldName("DIST_COMPANY.ID");
        descriptor.setSequenceNumberName("COMAPNY_SEQ");
        descriptor.setAlias("Company");

        // Query manager.
        descriptor.getQueryManager().checkCacheForDoesExist();
        //Named Queries

        // Event manager.

        // Mappings.
        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("DIST_COMPANY.ID");
        descriptor.addMapping(idMapping);

        DirectToFieldMapping nameMapping = new DirectToFieldMapping();
        nameMapping.setAttributeName("name");
        nameMapping.setFieldName("DIST_COMPANY.NAME");
        descriptor.addMapping(nameMapping);

        OneToManyMapping ownedItemsMapping = new OneToManyMapping();
        ownedItemsMapping.setAttributeName("ownedItems");
        ownedItemsMapping.setReferenceClass(org.eclipse.persistence.testing.tests.distributedservers.Item.class);
        ownedItemsMapping.dontUseIndirection();
        ownedItemsMapping.useCollectionClass(java.util.Vector.class);
        ownedItemsMapping.addTargetForeignKeyFieldName("DIST_ITEM.COMPANYOWNER", "DIST_COMPANY.ID");
        descriptor.addMapping(ownedItemsMapping);

        return descriptor;
    }

    public RelationalDescriptor buildDist_EmployeeDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.tests.distributedservers.Dist_Employee.class);
        descriptor.addTableName("DIST_EMPLOYEE");
        descriptor.addPrimaryKeyFieldName("DIST_EMPLOYEE.ID");

        // Descriptor properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.useRemoteSoftCacheWeakIdentityMap();
        descriptor.setRemoteIdentityMapSize(100);
        descriptor.setSequenceNumberFieldName("DIST_EMPLOYEE.ID");
        descriptor.setSequenceNumberName("EMPLOYEE_SEQ");
        descriptor.setAlias("Dist_Employee");

        // Query manager.
        descriptor.getQueryManager().checkCacheForDoesExist();
        //Named Queries

        // Event manager.

        // Mappings.
        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("DIST_EMPLOYEE.ID");
        descriptor.addMapping(idMapping);

        DirectToFieldMapping nameMapping = new DirectToFieldMapping();
        nameMapping.setAttributeName("name");
        nameMapping.setFieldName("DIST_EMPLOYEE.NAME");
        descriptor.addMapping(nameMapping);

        OneToManyMapping heldItemsMapping = new OneToManyMapping();
        heldItemsMapping.setAttributeName("heldItems");
        heldItemsMapping.setReferenceClass(org.eclipse.persistence.testing.tests.distributedservers.Item.class);
        heldItemsMapping.dontUseIndirection();
        heldItemsMapping.useCollectionClass(java.util.Vector.class);
        heldItemsMapping.addTargetForeignKeyFieldName("DIST_ITEM.EMPLOYEEHOLDER", "DIST_EMPLOYEE.ID");
        descriptor.addMapping(heldItemsMapping);

        return descriptor;
    }

    public RelationalDescriptor buildItemDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.tests.distributedservers.Item.class);
        descriptor.addTableName("DIST_ITEM");
        descriptor.addPrimaryKeyFieldName("DIST_ITEM.ID");

        // Descriptor properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.useRemoteSoftCacheWeakIdentityMap();
        descriptor.setRemoteIdentityMapSize(100);
        descriptor.setSequenceNumberFieldName("DIST_ITEM.ID");
        descriptor.setSequenceNumberName("ITEM_SEQ");
        descriptor.setAlias("Item");

        // Query manager.
        descriptor.getQueryManager().checkCacheForDoesExist();
        //Named Queries

        // Event manager.

        // Mappings.
        DirectToFieldMapping descriptionMapping = new DirectToFieldMapping();
        descriptionMapping.setAttributeName("description");
        descriptionMapping.setFieldName("DIST_ITEM.DESCRIPTION");
        descriptor.addMapping(descriptionMapping);

        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("DIST_ITEM.ID");
        descriptor.addMapping(idMapping);

        OneToOneMapping companyOwnerMapping = new OneToOneMapping();
        companyOwnerMapping.setAttributeName("companyOwner");
        companyOwnerMapping.setReferenceClass(org.eclipse.persistence.testing.tests.distributedservers.Company.class);
        companyOwnerMapping.dontUseIndirection();
        companyOwnerMapping.addForeignKeyFieldName("DIST_ITEM.COMPANYOWNER", "DIST_COMPANY.ID");
        descriptor.addMapping(companyOwnerMapping);

        OneToOneMapping employeeHolderMapping = new OneToOneMapping();
        employeeHolderMapping.setAttributeName("employeeHolder");
        employeeHolderMapping.setReferenceClass(org.eclipse.persistence.testing.tests.distributedservers.Dist_Employee.class);
        employeeHolderMapping.dontUseIndirection();
        employeeHolderMapping.addForeignKeyFieldName("DIST_ITEM.EMPLOYEEHOLDER", "DIST_EMPLOYEE.ID");
        descriptor.addMapping(employeeHolderMapping);

        return descriptor;
    }

}
