package qrcode.yzw.com.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.but_camrea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), CaptureActivity.class), 0);
            }
        });

        final EditText edit_text = (EditText) findViewById(R.id.edit_text);
        final ImageView iv_camrea = (ImageView) findViewById(R.id.iv_camrea);
        findViewById(R.id.but_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap logoBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                Bitmap bitmap = EncodingUtils.createQRCode(edit_text.getText().toString().trim(), 500, 500, logoBitmap);
                iv_camrea.setImageBitmap(bitmap);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            Toast.makeText(getApplicationContext(), bundle.getString("result"), Toast.LENGTH_SHORT).show();
        }
    }

}
