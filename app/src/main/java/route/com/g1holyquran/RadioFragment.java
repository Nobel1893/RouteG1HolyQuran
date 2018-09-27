package route.com.g1holyquran;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import route.com.g1holyquran.API.ApiManager;
import route.com.g1holyquran.API.Model.RadioResponse;
import route.com.g1holyquran.API.Model.RadiosItem;
import route.com.g1holyquran.Adapters.RadioRecyclerAdapter;
import route.com.g1holyquran.Base.MyBaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends MyBaseFragment {



    public RadioFragment() {
        // Required empty public constructor
    }

    RadioRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;
    List<RadiosItem> channels;
    RecyclerView recyclerView;
    ImageButton play,stop;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=  inflater.inflate(R.layout.fragment_radio, container, false);
         recyclerView = view.findViewById(R.id.recycler_view);
         play = view.findViewById(R.id.play);
         stop= view.findViewById(R.id.stop);
         getRadioChannels();
         return view;

    }
    SnapHelper snapHelper;
    public void setAdapter(){
        adapter= new RadioRecyclerAdapter(channels);
         layoutManager = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setAdapter(adapter);
         snapHelper= new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        //recyclerView.setOnFlingListener(snapHelper);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view =  snapHelper.findSnapView(layoutManager);
                int pos= recyclerView.getChildAdapterPosition(view);
                Log.e("pos",pos+"");
                playChannel(channels.get(pos).getURL());
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               stopMediaPlayer();
            }
        });

    }


    public void stopMediaPlayer(){
        if(mediaPlayer!=null&&mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }
    MediaPlayer mediaPlayer;
    public void playChannel(String url){
        stopMediaPlayer();

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void getRadioChannels(){
        ShowProgressBar();
        ApiManager.getServices().getRadioChannels()
                .enqueue(new Callback<RadioResponse>() {
                    @Override
                    public void onResponse(Call<RadioResponse> call, Response<RadioResponse> response) {
                        HideProgressBar();
                        channels = response.body().getRadios();
                        setAdapter();

                    }

                    @Override
                    public void onFailure(Call<RadioResponse> call, Throwable t) {
                        HideProgressBar();
                        ShowMessage("error",t.getLocalizedMessage());
                    }
                });

    }

}
