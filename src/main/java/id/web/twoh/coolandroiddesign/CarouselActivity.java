package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.web.twoh.coolandroiddesign.adapter.CarouselAdapter;
import id.web.twoh.coolandroiddesign.utils.Factory;

public class CarouselActivity extends BaseAdsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_carousel);
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        ArrayList<Integer> arrayList = new ArrayList<>();

        //Add multiple images to arraylist.
        arrayList.add(R.drawable.bg_draw_palette);
        arrayList.add(R.drawable.bg_bawah);
        arrayList.add(R.drawable.bg_switch);
        arrayList.add(R.drawable.bg_navview);
        arrayList.add(R.drawable.bg_face);
        arrayList.add(R.drawable.bg_lena);
        arrayList.add(R.drawable.bg_sheryl);
        arrayList.add(R.drawable.bg_switch2);
        arrayList.add(R.drawable.bg_yellow);

        CarouselAdapter adapter = new CarouselAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new CarouselAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, Integer path) {
                Factory.DialogImageView(path,CarouselActivity.this).show();
            }
        });
        setupToolbar();

    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Carousel View Example");
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