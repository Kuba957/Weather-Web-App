package weather_package.Model;

import javax.persistence.*;

@Entity
@Table(name = "weather")
public class Database {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "temp_low")
    private Integer temp_low;

    @Column(name = "temp_high")
    private Integer temp_high;

    @Column(name = "date")
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTemp_low() {
        return temp_low;
    }

    public void setTemp_low(Integer temp_low) {
        this.temp_low = temp_low;
    }

    public Integer getTemp_high() {
        return temp_high;
    }

    public void setTemp_high(Integer temp_high) {
        this.temp_high = temp_high;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
