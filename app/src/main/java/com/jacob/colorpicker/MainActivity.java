package com.jacob.colorpicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ColorPickerView colorPickerDisk=null;
    private TextView text_ColorDisk=null;
    private TextView color_bg;
    private SeekBar seek_bar;
    private String colorstring,transparence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorPickerDisk=new ColorPickerView(this);
        colorstring = "FF3030";
        //find the ID of View
        colorPickerDisk=(ColorPickerView)findViewById(R.id.colorPickerDisk);
        text_ColorDisk=(TextView)findViewById(R.id.text_ColorDisk);
        color_bg = (TextView) findViewById(R.id.color_bg);
        seek_bar = (SeekBar) findViewById(R.id.seek_bar);
        colorPickerDisk.setOnColorChangedListennerD(new ColorPickerView.OnColorChangedListenerD() {
            //获取颜色值和RGB值（六位16进制数）
            @Override
            public void onColorChanged(int color, String hexStrColor) {
                // TODO Auto-generated method stub
                text_ColorDisk.setBackgroundColor(color);
                color_bg.setBackgroundColor(color);
                text_ColorDisk.setText("Color is "+hexStrColor);
                colorstring = hexStrColor;
                seek_bar.setProgress(0xff);
            }
        });
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }
            //触发操作，拖动
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // 将十进制转为十六进制
                if (progress>15) {
                    transparence = Integer.toHexString(progress);
                }else {
                    transparence = "0"+Integer.toHexString(progress);
                }
                text_ColorDisk.setText("transparency is ："+transparence);
                String color = "#"+transparence+colorstring;
                if (color.length() == 9) {
                    text_ColorDisk.setBackgroundColor(Color.parseColor(color));
                }
            }
        });
    }

}
