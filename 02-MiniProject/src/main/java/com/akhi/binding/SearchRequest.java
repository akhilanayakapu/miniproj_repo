package com.akhi.binding;

import javax.persistence.Entity;

import lombok.Data;


@Data
public class SearchRequest {
             private String planName;
             private String planStatus;
}
