/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.javahw2;

/**
 *
 * @author rachelqiuyue
 */
public class Gps {

    private final double latitude;

    private final double longitude;

    public Gps(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Gps gps = (Gps) o;
        if (Double.compare(gps.latitude, latitude) != 0) {
            return false;
        }
        return (Double.compare(gps.longitude, longitude) == 0);
    }

    @Override public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        return 31 * result + (int) (temp ^ (temp >>> 32));
    }
}