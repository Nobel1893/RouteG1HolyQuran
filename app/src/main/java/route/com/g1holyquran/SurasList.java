package route.com.g1holyquran;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import route.com.g1holyquran.Adapters.SurasRecyclerAdapter;
import route.com.g1holyquran.Base.MyBaseActivity;
import route.com.g1holyquran.Model.Sura;

public class SurasList extends MyBaseActivity {

    RecyclerView suraListRecyclerView;
    SurasRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<Sura> suras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras_list);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        suraListRecyclerView = findViewById(R.id.suraListRecyclerView);
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

    }

}
