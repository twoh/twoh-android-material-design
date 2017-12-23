package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

import id.web.twoh.coolandroiddesign.adapter.RecyclerViewAdapter;
import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Herdi_WORK on 15.09.16.
 */
public class RecyclerViewActivity extends BaseAdsActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private ArrayList<String> dataSet;
    private ArrayList<String> addDataSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        setContentView(R.layout.activity_recyclerview);
        super.onCreate(savedInstanceState);
        dataSet = new ArrayList<>();
        addDataSet = new ArrayList<>();

        initDataset();

        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dataSet);
        rvView.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                decideToDisplay();
                // menyiapkan integer random dari 0 - 9
                int i = new Random().nextInt(9 - 0 + 1);

                // mengambil nama pada posisi random 0 - 9
                String additional = addDataSet.get(i);

                // memasukkan nama tersebut ke dalam
                // daftar nama di RecyclerView
                ((RecyclerViewAdapter)adapter).add(dataSet.size(), additional);

                // membuat RecyclerView otomatis
                // scroll ke bawah setelah nama baru ditambahkan
                rvView.scrollToPosition(dataSet.size()-1);
            }
        });

        setupToolbar();

        Button btTutorial = (Button) findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decideToDisplay();
                readTheTutorial(Const.TUTORIAL_RECYCLERVIEW);
            }
        });
        decideToDisplay();
    }

    private void initDataset(){

        /**
         * Tambahkan item ke dataset
         * dalam prakteknya bisa bermacam2
         * tidak hanya String seperti di kasus ini
         */
        dataSet.add("Karin");
        dataSet.add("Ingrid");
        dataSet.add("Helga");
        dataSet.add("Renate");
        dataSet.add("Elke");
        dataSet.add("Ursula");
        dataSet.add("Erika");
        dataSet.add("Christa");
        dataSet.add("Gisela");
        dataSet.add("Monika");

        addDataSet.add("Anna");
        addDataSet.add("Sofia");
        addDataSet.add("Emilia");
        addDataSet.add("Emma");
        addDataSet.add("Neele");
        addDataSet.add("Franziska");
        addDataSet.add("Heike");
        addDataSet.add("Katrin");
        addDataSet.add("Katharina");
        addDataSet.add("Liselotte");
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Recycler View Example");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                break;
        }

        return true;
    }
}
