package com.webjaguarsage.integration.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created by soujanya
 */
@Getter @Setter
public class Tag {
    private JournalObject Account;
    private Boolean Active;
    private String BaseBudget;
    private Double BaseCredit;
    private Double BaseCreditLimit;
    private Double BaseDebit;
    private JournalObject Company;
    private JournalObject Dimension;
    private String EndDate;
    private Map<String, String> FieldValueMap;
    private Map<String, String> FieldsValueMap;
    private Double ForeignCredit;
    private Double ForeignDebit;
    private Boolean IsPublic;
    private JournalObject LedgerAccount;
    private String Level1;
    private String Level2;
    private String Level3;
    private List<String> Messages;
    private JournalObject Product;
    private JournalObject Reference;
    private String StartDate;
    private JournalObject TagCurrency;
    private JournalObject Unit;
    private Double UnitCredit;
    private Double UnitDebit;
    private Double UnitValue;
}
