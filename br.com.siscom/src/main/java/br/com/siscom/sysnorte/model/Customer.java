package br.com.siscom.sysnorte.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.joda.time.DateTime;

@Entity
@Table(name = "PERSONS_CUSTOMERS")
@DiscriminatorValue("2")
public class Customer extends Person {

    private static long serialVersionUID = -4133580183371647600L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 100)
    private String full_name;
    @Column(length = 10)
    private String type_of_document;
    @Column(length = 25)
    private String document;
    @Column(length = 25)
    private String ie;
    @Column(length = 25)
    private String ie_of_SUFRAMA;
    private boolean free_of_ICMS;
    @Column(length = 50)
    private String email_main;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String address;
    @Column(length = 10)
    private String number;
    @Column(length = 20)
    private String complement;
    @Column(length = 20)
    private String district;
    @Column(length = 15)
    private String cep;    
    private int country;
    private int uf;
    @Column(length = 50)
    private String city;
    @Column(length = 20)
    private String phone_main;
    @Column(length = 20)
    private String phone;
    private DateTime created_at;
    private DateTime update_at;
    private boolean inactive;
    private DateTime inactive_at;
    private Double limit_of_credit;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getType_of_document() {
        return type_of_document;
    }

    public void setType_of_document(String type_of_document) {
        this.type_of_document = type_of_document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIe_of_SUFRAMA() {
        return ie_of_SUFRAMA;
    }

    public void setIe_of_SUFRAMA(String ie_of_SUFRAMA) {
        this.ie_of_SUFRAMA = ie_of_SUFRAMA;
    }

    public boolean isFree_of_ICMS() {
        return free_of_ICMS;
    }

    public void setFree_of_ICMS(boolean free_of_ICMS) {
        this.free_of_ICMS = free_of_ICMS;
    }

    public String getEmail_main() {
        return email_main;
    }

    public void setEmail_main(String email_main) {
        this.email_main = email_main;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone_main() {
        return phone_main;
    }

    public void setPhone_main(String phone_main) {
        this.phone_main = phone_main;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(DateTime created_at) {
        this.created_at = created_at;
    }

    public DateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(DateTime update_at) {
        this.update_at = update_at;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public DateTime getInactive_at() {
        return inactive_at;
    }

    public void setInactive_at(DateTime inactive_at) {
        this.inactive_at = inactive_at;
    }

    public Double getLimit_of_credit() {
        return limit_of_credit;
    }

    public void setLimit_of_credit(Double limit_of_credit) {
        this.limit_of_credit = limit_of_credit;
    }
}