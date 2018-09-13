package route.com.g1holyquran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import route.com.g1holyquran.Adapters.SurasRecyclerAdapter;
import route.com.g1holyquran.Base.MyBaseFragment;
import route.com.g1holyquran.Model.Sura;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends MyBaseFragment {


    RecyclerView suraListRecyclerView;
    SurasRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<Sura> suras;

    public QuranFragment() {
        // Required empty public constructor
    }


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_quran, container, false);

        suraListRecyclerView = view.findViewById(R.id.suraListRecyclerView);
        layoutManager = new
                LinearLayoutManager(activity);
        suras= new ArrayList<>();

        for(String s:DataHolder.ArSuras)
            suras.add(new Sura(s));

        adapter = new SurasRecyclerAdapter(suras);

        suraListRecyclerView.setAdapter(adapter);
        suraListRecyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

            }
        });



        return view;
    }

    //Fragment LifeCycle
    @Override
    public void onResume() {
        super.onResume();
    }
}
