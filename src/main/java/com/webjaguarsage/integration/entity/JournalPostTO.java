package com.webjaguarsage.integration.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created by soujanya
 */
@Getter @Setter
public class JournalPostTO {
    private String Description;
    private Map<String, String> FieldValueMap;
    private List<Item> items;
    private JournalObject JournalCompany;
    private JournalObject JournalCurrency;
    private String JournalDate;
    private Double JournalExchangeRate;
    private JournalObject JournalTaxTreatment;
    private String JournalTextualReference;
    private JournalObject JournalType;
    private List<String> Messages;
    private String Operation;
    private JournalObject Reference;
    private Double TotalAmount;
    private Double TotalCredit;
    private Double TotalDebit;
    private List<Object> Tag;
}
