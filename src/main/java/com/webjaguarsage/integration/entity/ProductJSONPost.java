package com.webjaguarsage.integration.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created by soujanya
 */
@Getter @Setter
public class ProductJSONPost {
    private Map<String, String> fieldValueMap;
    private Map<String, String> fieldsValueMap;
    private List<String> Messages;
    private JournalObject Reference;
    private List<Tag> Tags;

}
