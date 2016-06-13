package com.webjaguarsage.integration.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created by soujanya
 */
@Getter @Setter
public class Item {
    private Double amount;
    private Map<String, String> fieldValueMap;
    private Map<String, String> fieldsValueMap;
    private Boolean isCredit;
    private String itemDate;
    private JournalObject itemTaxCode;
    private String itemTextualReference;
    private List<Item> items;
    private List<String> messages;
    private JournalObject reference;
    private List<Tag> tags;
    private String type;

}
