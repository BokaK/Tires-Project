package mk.ukim.finki.tires.models.jpa;

import javax.persistence.*;

/**
 * Created by user on 31.5.2017.
 */
@Entity
@Table(name="tire")
public class Tire extends BaseEntity{

    private String name;

    private String description;

    private double price;

    private double priceOnSale;

    private boolean onSale;

    private boolean onStock;

    private int stockNumber;

    private String slipping;

    private String fuel;

    private int decibels;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brandName_id")
    private Brand brandName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="width_id")
    private Width width;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="height_id")
    private Height height;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="inches_id")
    private Inches inches;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="seasonType_id")
    private SeasonType seasonType;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vehicleType_id")
    private VehicleType vehicleType;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceOnSale() {
        return priceOnSale;
    }

    public void setPriceOnSale(double priceOnSale) {
        this.priceOnSale = priceOnSale;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean isOnStock() {
        return onStock;
    }

    public void setOnStock(boolean onStock) {
        this.onStock = onStock;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Brand getBrandName() {
        return brandName;
    }

    public void setBrandName(Brand brandName) {
        this.brandName = brandName;
    }

    public SeasonType getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(SeasonType seasonType) {
        this.seasonType = seasonType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Width getWidth() {
        return width;
    }

    public void setWidth(Width width) {
        this.width = width;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Inches getInches() {
        return inches;
    }

    public void setInches(Inches inches) {
        this.inches = inches;
    }

    public String getSlipping() {
        return slipping;
    }

    public void setSlipping(String slipping) {
        this.slipping = slipping;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getDecibels() {
        return decibels;
    }

    public void setDecibels(int decibels) {
        this.decibels = decibels;
    }
}
