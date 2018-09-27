package route.com.g1holyquran.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/27/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class ApiManager {


    private static Retrofit retrofitInstance;

    private static Retrofit getInstance(){
        if(retrofitInstance==null){
             retrofitInstance = new Retrofit.Builder()
                    .baseUrl("http://mp3quran.net/api/")
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
        }

        return retrofitInstance;
    }

    public static Services getServices(){
        return getInstance().create(Services.class);
    }
}
