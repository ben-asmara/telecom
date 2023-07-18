/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ylong
 */
public class Product {
   
    private StringProperty validity;
    private StringProperty bundleName;
    private DoubleProperty price;
    private StringProperty description;
    private StringProperty ussdCode;

    public Product(String validity, String bundleName, double price, String description, String ussdCode) {
        this.validity = new SimpleStringProperty(validity);
        this.bundleName = new SimpleStringProperty(bundleName);
        this.price = new SimpleDoubleProperty(price);
        this.description = new SimpleStringProperty(description);
        this.ussdCode = new SimpleStringProperty(ussdCode);
    }

    public StringProperty validityProperty() {
        return validity;
    }

    public String getValidity() {
        return validity.get();
    }

    public void setValidity(String validity) {
        this.validity.set(validity);
    }

    public StringProperty bundleNameProperty() {
        return bundleName;
    }

    public String getBundleName() {
        return bundleName.get();
    }

    public void setBundleName(String bundleName) {
        this.bundleName.set(bundleName);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty ussdCodeProperty() {
        return ussdCode;
    }

    public String getUssdCode() {
        return ussdCode.get();
    }

    public void setUssdCode(String ussdCode) {
        this.ussdCode.set(ussdCode);
    }
}

