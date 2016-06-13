package com.webjaguarsage.integration.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by soujanya
 */
public class JournalPostTOTest {
    @Test
    public void jsonTest1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JournalPostTO JournalPostTO = getTestObject();
        System.out.println(mapper.writeValueAsString(JournalPostTO));
    }

    public static JournalPostTO getTestObject() {
        JournalPostTO journalPostTO = new JournalPostTO();
        journalPostTO.setDescription(null);
        journalPostTO.setFieldValueMap(new HashMap<String, String>());
        journalPostTO.setItems(new ArrayList<Item>());
        journalPostTO.setJournalCompany(new JournalObject());
        journalPostTO.setJournalCurrency(new JournalObject());
        journalPostTO.setJournalDate("2015-11-19T00:00:00.000Z");
        journalPostTO.setJournalExchangeRate(1.0);
        journalPostTO.setJournalTaxTreatment(new JournalObject());
        journalPostTO.setJournalTextualReference(null);
        journalPostTO.setJournalType(new JournalObject());
        journalPostTO.setMessages(new ArrayList<String>());
        journalPostTO.setOperation(null);
        journalPostTO.setReference(new JournalObject());
        journalPostTO.setTag(new ArrayList<Object>());
        journalPostTO.setTotalAmount(40.00);
        journalPostTO.setTotalCredit(null);
        journalPostTO.setTotalDebit(null);
        return journalPostTO;
    }


}