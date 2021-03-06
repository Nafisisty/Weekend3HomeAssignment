
package com.example.weekend3homeassignment.model.currentweather;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.example.weekend3homeassignment.model.weather.Clouds;
import com.example.weekend3homeassignment.model.weather.Coord;
import com.example.weekend3homeassignment.model.weather.Main;
import com.example.weekend3homeassignment.model.weather.Sys;
import com.example.weekend3homeassignment.model.weather.Weather;
import com.example.weekend3homeassignment.model.weather.Wind;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeather implements Parcelable
{

    @SerializedName("coord")
    @Expose
    private com.example.weekend3homeassignment.model.weather.Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private com.example.weekend3homeassignment.model.weather.Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;
    public final static Creator<CurrentWeather> CREATOR = new Creator<CurrentWeather>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CurrentWeather createFromParcel(Parcel in) {
            return new CurrentWeather(in);
        }

        public CurrentWeather[] newArray(int size) {
            return (new CurrentWeather[size]);
        }

    }
    ;

    protected CurrentWeather(Parcel in) {
        this.coord = ((com.example.weekend3homeassignment.model.weather.Coord) in.readValue((com.example.weekend3homeassignment.model.weather.Coord.class.getClassLoader())));
        in.readList(this.weather, (Weather.class.getClassLoader()));
        this.base = ((String) in.readValue((String.class.getClassLoader())));
        this.main = ((Main) in.readValue((Main.class.getClassLoader())));
        this.visibility = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
        this.clouds = ((com.example.weekend3homeassignment.model.weather.Clouds) in.readValue((com.example.weekend3homeassignment.model.weather.Clouds.class.getClassLoader())));
        this.dt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sys = ((Sys) in.readValue((Sys.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.cod = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public CurrentWeather() {
    }

    public com.example.weekend3homeassignment.model.weather.Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public com.example.weekend3homeassignment.model.weather.Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(coord);
        dest.writeList(weather);
        dest.writeValue(base);
        dest.writeValue(main);
        dest.writeValue(visibility);
        dest.writeValue(wind);
        dest.writeValue(clouds);
        dest.writeValue(dt);
        dest.writeValue(sys);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(cod);
    }

    public int describeContents() {
        return  0;
    }

}
