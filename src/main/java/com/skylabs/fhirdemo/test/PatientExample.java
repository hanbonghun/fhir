package com.skylabs.fhirdemo.test;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;

public class PatientExample {
    
    public static void main(String[] args) {
        FhirContext ctx = FhirContext.forR4();
        Patient patient = new Patient();
        
        patient.addIdentifier()
            .setSystem("urn:system")
            .setValue("123456");
        
        patient.addName()
            .setUse(HumanName.NameUse.OFFICIAL)
            .setFamily("Doe")
            .addGiven("John")
            .addGiven("Q");
        
        patient.addCommunication()
            .setPreferred(true);
        
        patient.setManagingOrganization(new Reference("Organization/1"));
        
        String json = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
        
        System.out.println(patient.getManagingOrganization().getReference());
//        System.out.println("json = " + json);
    }
    
}
