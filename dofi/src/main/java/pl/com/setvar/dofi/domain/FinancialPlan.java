/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.domain;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marta
 */
@ManagedBean(name = "editedFinancialPlan")
@SessionScoped
public class FinancialPlan implements Serializable {

    private Short feed = 1;
    private Short savings = 2;
    private Short specifications = 3;
    private Short billsTaxes = 4;
    private Short food = 5;
    private Short home = 6;
    private Short cosmetics = 7;
    private Short hobby = 8;
    private Short gift = 9;
    private Short transportation = 10;
    private Short health = 11;
    private Short office = 12;
    private Short theft = 13;
    private Short science = 14;
    private Short clothing = 15;
    private Short candy = 16;
    private Short enterainment = 17;
    private Short other = 18;
    private String category = "łoś";
    private Short weSpend = 20;
    private Short released = 21;
    private Short difference = 22;

    /**
     * @return the feed
     */
    public Short getFeed() {
        return feed;
    }

    /**
     * @param feed the feed to set
     */
    public void setFeed(Short feed) {
        this.feed = feed;
    }

    /**
     * @return the savings
     */
    public Short getSavings() {
        return savings;
    }

    /**
     * @param savings the savings to set
     */
    public void setSavings(Short savings) {
        this.savings = savings;
    }

    /**
     * @return the specifications
     */
    public Short getSpecifications() {
        return specifications;
    }

    /**
     * @param specifications the specifications to set
     */
    public void setSpecifications(Short specifications) {
        this.specifications = specifications;
    }

    /**
     * @return the billsTaxes
     */
    public Short getBillsTaxes() {
        return billsTaxes;
    }

    /**
     * @param billsTaxes the billsTaxes to set
     */
    public void setBillsTaxes(Short billsTaxes) {
        this.billsTaxes = billsTaxes;
    }

    /**
     * @return the food
     */
    public Short getFood() {
        return food;
    }

    /**
     * @param food the food to set
     */
    public void setFood(Short food) {
        this.food = food;
    }

    /**
     * @return the home
     */
    public Short getHome() {
        return home;
    }

    /**
     * @param home the home to set
     */
    public void setHome(Short home) {
        this.home = home;
    }

    /**
     * @return the cosmetics
     */
    public Short getCosmetics() {
        return cosmetics;
    }

    /**
     * @param cosmetics the cosmetics to set
     */
    public void setCosmetics(Short cosmetics) {
        this.cosmetics = cosmetics;
    }

    /**
     * @return the hobby
     */
    public Short getHobby() {
        return hobby;
    }

    /**
     * @param hobby the hobby to set
     */
    public void setHobby(Short hobby) {
        this.hobby = hobby;
    }

    /**
     * @return the gift
     */
    public Short getGift() {
        return gift;
    }

    /**
     * @param gift the gift to set
     */
    public void setGift(Short gift) {
        this.gift = gift;
    }

    /**
     * @return the transportation
     */
    public Short getTransportation() {
        return transportation;
    }

    /**
     * @param transportation the transportation to set
     */
    public void setTransportation(Short transportation) {
        this.transportation = transportation;
    }

    /**
     * @return the health
     */
    public Short getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(Short health) {
        this.health = health;
    }

    /**
     * @return the office
     */
    public Short getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(Short office) {
        this.office = office;
    }

    /**
     * @return the theft
     */
    public Short getTheft() {
        return theft;
    }

    /**
     * @param theft the theft to set
     */
    public void setTheft(Short theft) {
        this.theft = theft;
    }

    /**
     * @return the science
     */
    public Short getScience() {
        return science;
    }

    /**
     * @param science the science to set
     */
    public void setScience(Short science) {
        this.science = science;
    }

    /**
     * @return the clothing
     */
    public Short getClothing() {
        return clothing;
    }

    /**
     * @param clothing the clothing to set
     */
    public void setClothing(Short clothing) {
        this.clothing = clothing;
    }

    /**
     * @return the candy
     */
    public Short getCandy() {
        return candy;
    }

    /**
     * @param candy the candy to set
     */
    public void setCandy(Short candy) {
        this.candy = candy;
    }

    /**
     * @return the enterainment
     */
    public Short getEnterainment() {
        return enterainment;
    }

    /**
     * @param enterainment the enterainment to set
     */
    public void setEnterainment(Short enterainment) {
        this.enterainment = enterainment;
    }

    /**
     * @return the other
     */
    public Short getOther() {
        return other;
    }

    /**
     * @param other the other to set
     */
    public void setOther(Short other) {
        this.other = other;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the weSpend
     */
    public Short getWeSpend() {
        return weSpend;
    }

    /**
     * @param weSpend the weSpend to set
     */
    public void setWeSpend(Short weSpend) {
        this.weSpend = weSpend;
    }

    /**
     * @return the released
     */
    public Short getReleased() {
        return released;
    }

    /**
     * @param released the released to set
     */
    public void setReleased(Short released) {
        this.released = released;
    }

    /**
     * @return the difference
     */
    public Short getDifference() {
        return difference;
    }

    /**
     * @param difference the difference to set
     */
    public void setDifference(Short difference) {
        this.difference = difference;
    }
}
   