package com.kvn.Restaurent.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Embeddable
public class ContactInformation {

    private String email;
    private String mobile;
    private String twitter;
    private String Instagram;

}
