
package com.example.weekend3homeassignment.model.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherResponse implements Parcelable
{

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("cnt")
    @Expose
    private String cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = null;
    @SerializedName("city")
    @Expose
    private City city;
    public final static Creator<WeatherResponse> CREATOR = new Creator<WeatherResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WeatherResponse createFromParcel(Parcel in) {
            return new WeatherResponse(in);
        }

        public WeatherResponse[] newArray(int size) {
            return (new WeatherResponse[size]);
        }

    }
    ;

    protected WeatherResponse(Parcel in) {
        this.cod = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.cnt = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.list, (List.class.getClassLoader()));
        this.city = ((City) in.readValue((City.class.getClassLoader())));
    }

    public WeatherResponse() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);
        dest.writeValue(city);
    }

    public int describeContents() {
        return  0;
    }

}
