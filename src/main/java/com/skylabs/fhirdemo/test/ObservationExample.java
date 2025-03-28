package com.skylabs.fhirdemo.test;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.SimpleQuantity;

public class ObservationExample {
    
    public static void main(String[] args) {
        // Create an Observation instance
        Observation observation = new Observation();

// Give the observation a status
        observation.setStatus(Observation.ObservationStatus.FINAL);

// Give the observation a code (what kind of observation is this)
        Coding coding = observation.getCode().addCoding();
        coding.setCode("29463-7").setSystem("http://loinc.org").setDisplay("Body Weight");

// Create a quantity datatype
        Quantity value = new Quantity();
        value.setValue(83.9).setSystem("http://unitsofmeasure.org").setCode("kg");
        observation.setValue(value);

// Set the reference range
        SimpleQuantity low = new SimpleQuantity();
        low.setValue(45).setSystem("http://unitsofmeasure.org").setCode("kg");
        observation.getReferenceRangeFirstRep().setLow(low);
        SimpleQuantity high = new SimpleQuantity();
        low.setValue(90).setSystem("http://unitsofmeasure.org").setCode("kg");
        observation.getReferenceRangeFirstRep().setHigh(high);
        
    }
}
