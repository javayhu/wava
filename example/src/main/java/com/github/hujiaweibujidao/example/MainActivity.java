package com.github.hujiaweibujidao.example;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.hujiaweibujidao.wava.Techniques;
import com.github.hujiaweibujidao.wava.YoYo;

public class MainActivity extends AppCompatActivity {

    private View mTarget;
    private ListView mListView;
    private EffectAdapter mAdapter;
    private YoYo.YoYoString rope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTarget = findViewById(R.id.hello_world);
        mListView = (ListView)findViewById(R.id.list);
        mAdapter = new EffectAdapter(this);
        mListView.setAdapter(mAdapter);

        rope = YoYo.with(Techniques.FadeIn).duration(1000).playOn(mTarget);// after start,just click mTarget view, rope is not init

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Techniques technique = (Techniques)view.getTag();
                rope =  YoYo.with(technique).duration(1200)
                        .interpolate(new AccelerateDecelerateInterpolator())
                        .listen(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationCancel(Animator animation) {
                                Toast.makeText(MainActivity.this, "canceled", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .playOn(mTarget);
            }
        });

        mTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rope != null) {
                    rope.stop(true);
                }
            }
        });
    }

}
