package com.example.apprenti.blablawild;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class SearchRequestModel implements Parcelable {
    private String departureCity;
    private String destinationCity;
    private Date dateOfDepature;

    public SearchRequestModel(String departureCity, String destinationCity, Date dateOfDepature) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.dateOfDepature = dateOfDepature;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getDateOfDepature() {
        return dateOfDepature;
    }

    public void setDateOfDepature(Date dateOfDepature) {
        this.dateOfDepature = dateOfDepature;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.departureCity);
        dest.writeString(this.destinationCity);
        dest.writeLong(this.dateOfDepature.getTime());
    }

    public static final Parcelable.Creator<SearchRequestModel> CREATOR
            = new Parcelable.Creator<SearchRequestModel>() {
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };

    private SearchRequestModel(Parcel in) {
        this.departureCity = in.readString();
        this.destinationCity = in.readString();
        this.dateOfDepature = new Date(in.readLong());
    }
}
