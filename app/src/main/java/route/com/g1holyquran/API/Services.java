package route.com.g1holyquran.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import route.com.g1holyquran.API.Model.RadioResponse;
import route.com.g1holyquran.Model.Sura;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/27/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public interface Services {


    @GET("radio/radio_ar.json")
    Call <RadioResponse> getRadioChannels();


    @POST("radio/xyz")
    Call <Sura> getSuras();


}
