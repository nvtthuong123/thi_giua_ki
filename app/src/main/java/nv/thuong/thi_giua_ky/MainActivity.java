package nv.thuong.thi_giua_ky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import nv.thuong.adapter.PhepChiaAdapter;
import nv.thuong.model.CacSo;

public class MainActivity extends AppCompatActivity {
    EditText txtA, txtB;
    TextView txtKetQua;
    Button btnChia;
    ListView lvKetQua;
    ArrayList<CacSo> dsCacso;
    PhepChiaAdapter dsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {

        lvKetQua.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dsCacso.remove(position);
                dsAdapter.notifyDataSetChanged();

            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            CacSo cacSo = new CacSo(
                    txtA.getText().toString(),
                    txtB.getText().toString(),
                    txtKetQua.getText().toString()
            );
            dsCacso.add(cacSo);
            dsAdapter.notifyDataSetChanged();

                if(
                        !TextUtils.isEmpty(txtA.getText().toString() ) && !TextUtils.isEmpty(txtB.getText().toString() )
                ){
                    if( !TextUtils.isDigitsOnly(txtA.getText().toString()) || !TextUtils.isDigitsOnly(txtB.getText().toString()) ) {
                            Toast.makeText(MainActivity.this, "Vui lòng nhập số ! ",Toast.LENGTH_LONG).show();
                    }else{
                        int a = Integer.parseInt(txtA.getText().toString());
                        int b = Integer.parseInt(txtB.getText().toString());
                        int kq = a / b;
                        txtKetQua.setText(String.valueOf(a) + "/" + String.valueOf(b) + "=" + String.valueOf(kq));
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Không được để trống",Toast.LENGTH_LONG).show();
                }

            }
        });
    }



    private void addControls() {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        btnChia = (Button) findViewById(R.id.btnChia);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
        lvKetQua = (ListView) findViewById(R.id.lvKetQua);
        dsCacso = new ArrayList<>();
        dsAdapter = new PhepChiaAdapter(MainActivity.this, R.layout.item, dsCacso);
        lvKetQua.setAdapter(dsAdapter);
    }
}
