package com.billing.web.model;

/**
 * Created by zhangkai on 2014/8/19.
 */
public class Customer {
    private String id;
    private String customer_name;
    private String email;
    private String phone;
    private String password_hint;
    private String status_id;
    private String last_currency_uom;
    private String last_locale;
    private String last_time_zone;
    private String disabled_date_time;
    private String first_party_id;
    private String last_updated_stamp;
    private String created_stamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword_hint() {
        return password_hint;
    }

    public void setPassword_hint(String password_hint) {
        this.password_hint = password_hint;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getLast_currency_uom() {
        return last_currency_uom;
    }

    public void setLast_currency_uom(String last_currency_uom) {
        this.last_currency_uom = last_currency_uom;
    }

    public String getLast_locale() {
        return last_locale;
    }

    public void setLast_locale(String last_locale) {
        this.last_locale = last_locale;
    }

    public String getLast_time_zone() {
        return last_time_zone;
    }

    public void setLast_time_zone(String last_time_zone) {
        this.last_time_zone = last_time_zone;
    }

    public String getDisabled_date_time() {
        return disabled_date_time;
    }

    public void setDisabled_date_time(String disabled_date_time) {
        this.disabled_date_time = disabled_date_time;
    }

    public String getFirst_party_id() {
        return first_party_id;
    }

    public void setFirst_party_id(String first_party_id) {
        this.first_party_id = first_party_id;
    }

    public String getLast_updated_stamp() {
        return last_updated_stamp;
    }

    public void setLast_updated_stamp(String last_updated_stamp) {
        this.last_updated_stamp = last_updated_stamp;
    }

    public String getCreated_stamp() {
        return created_stamp;
    }

    public void setCreated_stamp(String created_stamp) {
        this.created_stamp = created_stamp;
    }
}
