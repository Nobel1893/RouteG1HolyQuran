package route.com.g1holyquran;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import route.com.g1holyquran.Adapters.VersesRecyclerAdapter;
import route.com.g1holyquran.Base.MyBaseActivity;

public class SuraContent extends MyBaseActivity {

    VersesRecyclerAdapter adapter ;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String fileName= getIntent().getStringExtra("fileName");
        ArrayList<String> verses= ReadSuraFromAsset(fileName);
        layoutManager = new LinearLayoutManager(activity);
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new VersesRecyclerAdapter(verses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }



    public ArrayList<String> ReadSuraFromAsset(String fileName){

        ArrayList<String> lines=new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                lines.add(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return lines;


    }
}
