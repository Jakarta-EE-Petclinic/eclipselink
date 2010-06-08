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
package org.eclipse.persistence.testing.tests.sessionbroker;

import java.util.Vector;

/**
 * TopLink generated Project class. 
 * <b>WARNING</b>: This code was generated by an automated tool.
 * Any changes will be lost when the code is re-generated
 */
public class EmployeeProject1 extends org.eclipse.persistence.sessions.Project {

    /**
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    public EmployeeProject1() {
        applyPROJECT();
        applyLOGIN();
        buildEmployeeDescriptor();
        buildEmploymentPeriodDescriptor();
    }

    /**
     * TopLink generated method. 
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void applyLOGIN() {
        org.eclipse.persistence.sessions.DatabaseLogin login = new org.eclipse.persistence.sessions.DatabaseLogin();

        login.setDriverClassName("sun.jdbc.odbc.JdbcOdbcDriver");
        login.setConnectionString("jdbc:odbc:MSACCESS");
        login.setPlatformClassName("org.eclipse.persistence.platform.database.AccessPlatform");
        setLogin(login);
    }

    /**
     * TopLink generated method. 
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void applyPROJECT() {
        setName("Employee");
    }

    /**
     * TopLink generated method. 
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildEmployeeDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = 
            new org.eclipse.persistence.descriptors.RelationalDescriptor();


        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.employee.domain.Employee.class);
        Vector vector = new Vector();
        vector.addElement("EMPLOYEE");
        vector.addElement("SALARY");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("EMPLOYEE.EMP_ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setSequenceNumberName("EMP_SEQ");
        descriptor.setSequenceNumberFieldName("EMP_ID");
        descriptor.useVersionLocking("VERSION");
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);

        // SECTION: AGGREGATEOBJECTMAPPING
        org.eclipse.persistence.mappings.AggregateObjectMapping aggregateobjectmapping = 
            new org.eclipse.persistence.mappings.AggregateObjectMapping();
        aggregateobjectmapping.setAttributeName("period");
        aggregateobjectmapping.setIsReadOnly(false);
        aggregateobjectmapping.setReferenceClass(org.eclipse.persistence.testing.models.employee.domain.EmploymentPeriod.class);
        aggregateobjectmapping.setIsNullAllowed(true);
        descriptor.addMapping(aggregateobjectmapping);

        // SECTION: DIRECTCOLLECTIONMAPPING
        org.eclipse.persistence.mappings.DirectCollectionMapping directcollectionmapping = 
            new org.eclipse.persistence.mappings.DirectCollectionMapping();
        directcollectionmapping.setAttributeName("responsibilitiesList");
        directcollectionmapping.setIsReadOnly(false);
        directcollectionmapping.setUsesIndirection(true);
        directcollectionmapping.setIsPrivateOwned(true);
        directcollectionmapping.setDirectFieldName("RESPONS.DESCRIP");
        directcollectionmapping.setReferenceTableName("RESPONS");
        directcollectionmapping.addReferenceKeyFieldName("RESPONS.EMP_ID", "EMPLOYEE.EMP_ID");
        descriptor.addMapping(directcollectionmapping);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = 
            new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("firstName");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("EMPLOYEE.F_NAME");
        descriptor.addMapping(directtofieldmapping);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping1 = 
            new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping1.setAttributeName("id");
        directtofieldmapping1.setIsReadOnly(false);
        directtofieldmapping1.setFieldName("EMPLOYEE.EMP_ID");
        descriptor.addMapping(directtofieldmapping1);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping2 = 
            new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping2.setAttributeName("lastName");
        directtofieldmapping2.setIsReadOnly(false);
        directtofieldmapping2.setFieldName("EMPLOYEE.L_NAME");
        descriptor.addMapping(directtofieldmapping2);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping3 = 
            new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping3.setAttributeName("salary");
        directtofieldmapping3.setIsReadOnly(false);
        directtofieldmapping3.setFieldName("SALARY.SALARY");
        descriptor.addMapping(directtofieldmapping3);

        // SECTION: MANYTOMANYMAPPING
        org.eclipse.persistence.mappings.ManyToManyMapping manytomanymapping = 
            new org.eclipse.persistence.mappings.ManyToManyMapping();
        manytomanymapping.setAttributeName("projects");
        manytomanymapping.setIsReadOnly(false);
        manytomanymapping.setUsesIndirection(true);
        manytomanymapping.setReferenceClass(org.eclipse.persistence.testing.models.employee.domain.Project.class);
        manytomanymapping.setIsPrivateOwned(false);
        manytomanymapping.setRelationTableName("PROJ_EMP");
        manytomanymapping.addSourceRelationKeyFieldName("PROJ_EMP.EMP_ID", "EMPLOYEE.EMP_ID");
        manytomanymapping.addTargetRelationKeyFieldName("PROJ_EMP.PROJ_ID", "PROJECT.PROJ_ID");
        descriptor.addMapping(manytomanymapping);

        // SECTION: OBJECTTYPEMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping objecttypemapping = 
            new org.eclipse.persistence.mappings.DirectToFieldMapping();
        objecttypemapping.setAttributeName("gender");
        objecttypemapping.setIsReadOnly(false);
        objecttypemapping.setFieldName("EMPLOYEE.GENDER");
        org.eclipse.persistence.mappings.converters.ObjectTypeConverter objecttypeconverter = 
            new org.eclipse.persistence.mappings.converters.ObjectTypeConverter();
        objecttypeconverter.addConversionValue("F", "Female");
        objecttypeconverter.addConversionValue("M", "Male");
        objecttypemapping.setConverter(objecttypeconverter);
        descriptor.addMapping(objecttypemapping);

        // SECTION: ONETOMANYMAPPING
        org.eclipse.persistence.mappings.OneToManyMapping onetomanymapping = new org.eclipse.persistence.mappings.OneToManyMapping();
        onetomanymapping.setAttributeName("managedEmployees");
        onetomanymapping.setIsReadOnly(false);
        onetomanymapping.setUsesIndirection(true);
        onetomanymapping.setReferenceClass(org.eclipse.persistence.testing.models.employee.domain.Employee.class);
        onetomanymapping.setIsPrivateOwned(false);
        onetomanymapping.addTargetForeignKeyFieldName("EMPLOYEE.MANAGER_ID", "EMPLOYEE.EMP_ID");
        descriptor.addMapping(onetomanymapping);

        // SECTION: ONETOMANYMAPPING
        org.eclipse.persistence.mappings.OneToManyMapping onetomanymapping1 = 
            new org.eclipse.persistence.mappings.OneToManyMapping();
        onetomanymapping1.setAttributeName("phoneNumbers");
        onetomanymapping1.setIsReadOnly(false);
        onetomanymapping1.setUsesIndirection(true);
        onetomanymapping1.setReferenceClass(org.eclipse.persistence.testing.models.employee.domain.PhoneNumber.class);
        onetomanymapping1.setIsPrivateOwned(true);
        onetomanymapping1.addTargetForeignKeyFieldName("PHONE.EMP_ID", "EMPLOYEE.EMP_ID");
        descriptor.addMapping(onetomanymapping1);

        // SECTION: ONETOONEMAPPING
        org.eclipse.persistence.mappings.OneToOneMapping onetoonemapping = new org.eclipse.persistence.mappings.OneToOneMapping();
        onetoonemapping.setAttributeName("address");
        onetoonemapping.setIsReadOnly(false);
        onetoonemapping.setUsesIndirection(true);
        onetoonemapping.setReferenceClass(org.eclipse.persistence.testing.models.employee.domain.Address.class);
        onetoonemapping.setIsPrivateOwned(true);
        onetoonemapping.addForeignKeyFieldName("EMPLOYEE.ADDR_ID", "ADDRESS.ADDRESS_ID");
        descriptor.addMapping(onetoonemapping);

        // SECTION: ONETOONEMAPPING
        org.eclipse.persistence.mappings.OneToOneMapping onetoonemapping1 = new org.eclipse.persistence.mappings.OneToOneMapping();
        onetoonemapping1.setAttributeName("manager");
        onetoonemapping1.setIsReadOnly(false);
        onetoonemapping1.setUsesIndirection(true);
        onetoonemapping1.setReferenceClass(org.eclipse.persistence.testing.models.employee.domain.Employee.class);
        onetoonemapping1.setIsPrivateOwned(false);
        onetoonemapping1.addForeignKeyFieldName("EMPLOYEE.MANAGER_ID", "EMPLOYEE.EMP_ID");
        descriptor.addMapping(onetoonemapping1);

        // SECTION: TRANSFORMATIONMAPPING
        org.eclipse.persistence.mappings.TransformationMapping transformationmapping = 
            new org.eclipse.persistence.mappings.TransformationMapping();
        transformationmapping.setAttributeName("normalHours");
        transformationmapping.setIsReadOnly(false);
        transformationmapping.setUsesIndirection(false);
        transformationmapping.setAttributeTransformation("buildNormalHours");
        transformationmapping.addFieldTransformation("EMPLOYEE.END_TIME", "getEndTime");
        transformationmapping.addFieldTransformation("EMPLOYEE.START_TIME", "getStartTime");
        descriptor.addMapping(transformationmapping);
        addDescriptor(descriptor);
    }

    /**
     * TopLink generated method. 
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildEmploymentPeriodDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = 
            new org.eclipse.persistence.descriptors.RelationalDescriptor();


        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.employee.domain.EmploymentPeriod.class);
        Vector vector = new Vector();
        vector.addElement("EMPLOYEE");
        descriptor.setTableNames(vector);

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);
        descriptor.descriptorIsAggregate();

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = 
            new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("endDate");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("EMPLOYEE.END_DATE");
        descriptor.addMapping(directtofieldmapping);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping1 = 
            new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping1.setAttributeName("startDate");
        directtofieldmapping1.setIsReadOnly(false);
        directtofieldmapping1.setFieldName("EMPLOYEE.START_DATE");
        descriptor.addMapping(directtofieldmapping1);
        addDescriptor(descriptor);
    }
}
