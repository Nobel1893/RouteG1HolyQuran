package route.com.g1holyquran.API.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RadioResponse {


    @SerializedName("Radios")
    @Expose
    private List<RadiosItem> radios = null;

    public List<RadiosItem> getRadios() {
        return radios;
    }

    public void setRadios(List<RadiosItem> radios) {
        this.radios = radios;
    }
}
