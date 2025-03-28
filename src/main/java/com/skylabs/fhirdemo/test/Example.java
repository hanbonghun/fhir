package com.skylabs.fhirdemo.test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;

@Slf4j
public class Example {
    
    public static void main(String[] args) {
        // HAPI 사용의 시작점이자 필요한 정보의 런타임 캐시 역할
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
        
        String xml = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(patient);
        String json = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
        
//        System.out.println("json = " + json);
//        System.out.println();
//        System.out.println("xml = " + xml);
        IParser parser = ctx.newJsonParser();

// Instruct the parser to only include summary elements
        parser.setSummaryMode(true);

// If you need to, you can instruct the parser to override
// the default summary elements by adding and/or removing
// elements from the list of elements it will include. This
// is typically not needed, but it's shown here in case you
// need to do this:
// Include a non-summary element in the summary view.
        parser.setEncodeElements("Patient.maritalStatus");
// Exclude a summary element even though it would normally
// be included.
        parser.setDontEncodeElements("Patient.name");

// Serialize it
        String serialized = parser.encodeResourceToString(patient);
        System.out.println(serialized);
    }
}
