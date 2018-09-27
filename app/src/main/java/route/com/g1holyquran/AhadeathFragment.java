package route.com.g1holyquran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import route.com.g1holyquran.Adapters.AhadeathRecyclerAdapter;
import route.com.g1holyquran.Base.MyBaseFragment;
import route.com.g1holyquran.DialogeFragments.HadeathDialogFragment;
import route.com.g1holyquran.Model.HadeathItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class AhadeathFragment extends MyBaseFragment {




    public AhadeathFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AhadeathRecyclerAdapter adapter;
    ArrayList<HadeathItem> ahadeath;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_ahadeath, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        ahadeath= ReadAhadethFile();
        adapter  = new AhadeathRecyclerAdapter(ahadeath);
        adapter.setOnItemClickListener(new AhadeathRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                HadeathDialogFragment dialogFragment= new HadeathDialogFragment();
                dialogFragment.setHadeathContent(ahadeath.get(position).getContent());
                dialogFragment.setHadeathTitle(ahadeath.get(position).getTitle());
                dialogFragment.show(getChildFragmentManager(),"dialog");
            }
        });
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }

    public ArrayList<HadeathItem> ReadAhadethFile(){
        ArrayList<HadeathItem> AhadeathList= new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(activity.getAssets().open("ahadith_arabic.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                HadeathItem item= new HadeathItem();
                item.setTitle(mLine);
                while ((mLine = reader.readLine()) != null){
                    if(mLine.equals("#"))break;
                    item.setContent(item.getContent()+"\n"+mLine);
                }
                AhadeathList.add(item);
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
        return AhadeathList;
    }

}
