package mk.ukim.finki.tires.models.jpa;

import javax.persistence.*;

/**
 * Created by user on 31.5.2017.
 */
@Entity
@Table(name="tire")
public class Tire extends BaseEntity{

    private double width;

    private double height;

    private double inches;

    private double price;

    private double priceOnSale;

    private boolean onSale;

    private boolean onStock;

    private int stockNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brandName_id")
    private Brand brandName;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="seasonType_id")
    private SeasonType seasonType;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vehicleType_id")
    private VehicleType vehicleType;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getInches() {
        return inches;
    }

    public void setInches(double inches) {
        this.inches = inches;
    }

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
}
