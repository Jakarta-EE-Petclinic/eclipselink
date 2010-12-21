/*******************************************************************************
 * Copyright (c) 2010 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Vikram Bhatia - initial API and implementation
 ******************************************************************************/  
package org.eclipse.persistence.testing.models.vehicle;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.RelationalDescriptor;
import org.eclipse.persistence.mappings.DirectToFieldMapping;
import org.eclipse.persistence.mappings.OneToOneMapping;


/**
 * This class was generated by the TopLink project class generator.
 * It stores the meta-data (descriptors) that define the TopLink mappings.
 * ## Eclipse Persistence Services - 2.1.0.qualifier ##
 * @see org.eclipse.persistence.sessions.factories.ProjectClassGenerator
 */

public class VehicleProject extends org.eclipse.persistence.sessions.Project {

    public VehicleProject() {
        setName("Vehicle");
        applyLogin();
        
        addDescriptor(buildCarOwnerClassDescriptor());
        addDescriptor(buildEngineTypeClassDescriptor());
        addDescriptor(buildFuelTypeClassDescriptor());
        addDescriptor(buildSportsCarClassDescriptor());
    }

    public ClassDescriptor buildCarOwnerClassDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.vehicle.CarOwner.class);
        descriptor.addTableName("CAROWNER");
        descriptor.addPrimaryKeyFieldName("CAROWNER.ID");
        
        // ClassDescriptor Properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.useRemoteSoftCacheWeakIdentityMap();
        descriptor.setRemoteIdentityMapSize(100);
        descriptor.setAlias("CarOwner");
        
        
        // Query Manager.
        descriptor.getQueryManager().checkCacheForDoesExist();
        
        
        // Event Manager.
        
        // Mappings.
        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("CAROWNER.ID");
        descriptor.addMapping(idMapping);
        
        DirectToFieldMapping nameMapping = new DirectToFieldMapping();
        nameMapping.setAttributeName("name");
        nameMapping.setFieldName("CAROWNER.NAME");
        descriptor.addMapping(nameMapping);
        
        OneToOneMapping carMapping = new OneToOneMapping();
        carMapping.setAttributeName("car");
        carMapping.setReferenceClass(org.eclipse.persistence.testing.models.vehicle.SportsCar.class);
        carMapping.dontUseIndirection();
        carMapping.addForeignKeyFieldName("CAROWNER.CARID", "SPORTSCAR.ID");
        descriptor.addMapping(carMapping);
        
        OneToOneMapping lastCarMapping = new OneToOneMapping();
        lastCarMapping.setAttributeName("lastCar");
        lastCarMapping.setReferenceClass(org.eclipse.persistence.testing.models.vehicle.SportsCar.class);
        lastCarMapping.dontUseIndirection();
        lastCarMapping.addForeignKeyFieldName("CAROWNER.LASTCARID", "SPORTSCAR.ID");
        descriptor.addMapping(lastCarMapping);
        
        return descriptor;
    }

    public ClassDescriptor buildEngineTypeClassDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.vehicle.EngineType.class);
        descriptor.addTableName("ENGINETYPE");
        descriptor.addPrimaryKeyFieldName("ENGINETYPE.ID");
        
        // ClassDescriptor Properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.useRemoteSoftCacheWeakIdentityMap();
        descriptor.setRemoteIdentityMapSize(100);
        descriptor.setAlias("EngineType");
        
        
        // Query Manager.
        descriptor.getQueryManager().checkCacheForDoesExist();
        
        
        // Event Manager.
        
        // Mappings.
        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("ENGINETYPE.ID");
        descriptor.addMapping(idMapping);
        
        DirectToFieldMapping typeMapping = new DirectToFieldMapping();
        typeMapping.setAttributeName("type");
        typeMapping.setFieldName("ENGINETYPE.TYPE");
        descriptor.addMapping(typeMapping);
        
        return descriptor;
    }

    public ClassDescriptor buildFuelTypeClassDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.vehicle.FuelType.class);
        descriptor.addTableName("FUELTYPE");
        descriptor.addPrimaryKeyFieldName("FUELTYPE.ID");
        
        // ClassDescriptor Properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.useRemoteSoftCacheWeakIdentityMap();
        descriptor.setRemoteIdentityMapSize(100);
        descriptor.setAlias("FuelType");
        
        
        // Query Manager.
        descriptor.getQueryManager().checkCacheForDoesExist();
        
        
        // Event Manager.
        
        // Mappings.
        DirectToFieldMapping fuelDescriptionMapping = new DirectToFieldMapping();
        fuelDescriptionMapping.setAttributeName("fuelDescription");
        fuelDescriptionMapping.setFieldName("FUELTYPE.DESCRIPTION");
        descriptor.addMapping(fuelDescriptionMapping);
        
        DirectToFieldMapping fuelIdMapping = new DirectToFieldMapping();
        fuelIdMapping.setAttributeName("fuelId");
        fuelIdMapping.setFieldName("FUELTYPE.ID");
        descriptor.addMapping(fuelIdMapping);
        
        return descriptor;
    }

    public ClassDescriptor buildSportsCarClassDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.vehicle.SportsCar.class);
        descriptor.addTableName("SPORTSCAR");
        descriptor.addPrimaryKeyFieldName("SPORTSCAR.ID");
        
        // ClassDescriptor Properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.useRemoteSoftCacheWeakIdentityMap();
        descriptor.setRemoteIdentityMapSize(100);
        descriptor.setAlias("SportsCar");
        
        
        // Query Manager.
        descriptor.getQueryManager().checkCacheForDoesExist();
        
        
        // Event Manager.
        
        // Mappings.
        DirectToFieldMapping descriptionMapping = new DirectToFieldMapping();
        descriptionMapping.setAttributeName("description");
        descriptionMapping.setFieldName("SPORTSCAR.DESCRIPTION");
        descriptor.addMapping(descriptionMapping);
        
        DirectToFieldMapping fuelCapacityMapping = new DirectToFieldMapping();
        fuelCapacityMapping.setAttributeName("fuelCapacity");
        fuelCapacityMapping.setFieldName("SPORTSCAR.FUELCAPACITY");
        descriptor.addMapping(fuelCapacityMapping);
        
        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("SPORTSCAR.ID");
        descriptor.addMapping(idMapping);
        
        OneToOneMapping engineTypeMapping = new OneToOneMapping();
        engineTypeMapping.setAttributeName("engineType");
        engineTypeMapping.setReferenceClass(org.eclipse.persistence.testing.models.vehicle.EngineType.class);
        engineTypeMapping.dontUseIndirection();
        engineTypeMapping.addForeignKeyFieldName("SPORTSCAR.ENGINEID", "ENGINETYPE.ID");
        descriptor.addMapping(engineTypeMapping);
        
        OneToOneMapping fuelTypeMapping = new OneToOneMapping();
        fuelTypeMapping.setAttributeName("fuelType");
        fuelTypeMapping.setReferenceClass(org.eclipse.persistence.testing.models.vehicle.FuelType.class);
        fuelTypeMapping.dontUseIndirection();
        fuelTypeMapping.addForeignKeyFieldName("SPORTSCAR.FUELID", "FUELTYPE.ID");
        descriptor.addMapping(fuelTypeMapping);
        
        return descriptor;
    }

}
