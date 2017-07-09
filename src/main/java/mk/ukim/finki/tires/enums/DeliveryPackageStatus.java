package mk.ukim.finki.tires.enums;

/**
 * Created by Simona on 7/9/2017.
 */
public enum DeliveryPackageStatus {
    /**
     * Payed invoice. The tires should be packed for delivery.
     */
    PENDING_PACKAGE_CREATION,
    /**
     * Tires packed. Shipment company called.
     */
    PACKAGE_READY_FOR_SHIPMENT,
    SHIPMENT_IN_PROGRESS,
    CONFIRMED_DELIVERY,
    CLOSED_UNCONFIRMED_DELIVERY
}
