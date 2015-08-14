package com.example.jarek.stratcaller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class ChooseMapActivity extends Activity {

    private Intent intent;
    private Intent map;
    private DatabaseLoader databaseLoaderTask;
    public TacticsEntity[] actualMapTactics;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        databaseLoaderTask = new DatabaseLoader();
        intent = new Intent(this, ChooseSideActivity.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_map);

        //Settings of map buttons
        Map<Integer, String> maps = new HashMap<>();
        maps.put(R.id.dust2_button, "de_dust2");
        maps.put(R.id.cache_button, "de_cache");
        maps.put(R.id.mirage_button, "de_mirage");
        maps.put(R.id.inferno_buton, "de_inferno");
        maps.put(R.id.nuke_button, "de_nuke");
        maps.put(R.id.train_button, "de_train");
        maps.put(R.id.cobblestone_button, "de_cobblestone");
        maps.put(R.id.overpass_button, "de_overpass");

        for (int resource : maps.keySet()) {
            prepareButton(resource, maps.get(resource));
        }

    }
    private void prepareButton(final int resource, final String mapChoice) {
        Button button = (Button) findViewById(resource);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("current map from ChooseMapActivity", mapChoice.toString());
//              databaseLoaderTask.execute(mapChoice);
                startActivity(intent);
            }
        });
    }
//        databaseLoaderTask.delegate=this;
}

//    @Override
//    public void processFinish(TacticsEntity[] output) {
//        actualMapTactics=output;
//    }
