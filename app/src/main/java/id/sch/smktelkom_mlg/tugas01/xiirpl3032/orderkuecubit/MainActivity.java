package id.sch.smktelkom_mlg.tugas01.xiirpl3032.orderkuecubit;

import android.provider.MediaStore;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText isinama;
    TextView tvHasil;
    Button bOk;
    RadioButton RB6,RB12,RB20,RBCod,RBTrf;
    CheckBox CBCklt, CBRed, CBGreen, CBMes, CBNut, CBOreo, CBMas;
    Spinner spJumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isinama = (EditText) findViewById(R.id.EtNama);
        tvHasil = (TextView) findViewById(R.id.TvPesanan);
        bOk = (Button) findViewById(R.id.ButtonPesan);
        RB6 = (RadioButton) findViewById(R.id.RBIsi6);
        RB12 = (RadioButton) findViewById(R.id.RBIsi12);
        RB20 = (RadioButton) findViewById(R.id.RBIsi20);
        RBCod = (RadioButton) findViewById(R.id.RBCod);
        RBTrf = (RadioButton) findViewById(R.id.RBTrf);
        CBCklt = (CheckBox) findViewById(R.id.CBCoklat);
        CBRed = (CheckBox) findViewById(R.id.CBRedVelvet);
        CBGreen = (CheckBox) findViewById(R.id.CBGreen);
        CBMes = (CheckBox) findViewById(R.id.CBMeses);
        CBNut = (CheckBox) findViewById(R.id.CBNutella);
        CBOreo = (CheckBox) findViewById(R.id.CBOreo);
        CBMas = (CheckBox) findViewById(R.id.CBMars);
        spJumlah = (Spinner) findViewById(R.id.SpinnerJumlah);

        findViewById(R.id.ButtonPesan).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                doClick();
            }

            private void doClick() {
                if(isValid()) {
                    String nama = isinama.getText().toString();

                    String isi = "(Not choosen)";

                    if (RB6.isChecked()){
                        isi = RB6.getText().toString();
                    } else if (RB12.isChecked()) {
                        isi = RB12.getText().toString();
                    } else if (RB20.isChecked()){
                        isi = RB20.getText().toString();
                    }


                    String pay = "(Not choosen)";

                    if (RBCod.isChecked()) {
                        pay = RBCod.getText().toString();
                    } else if (RBTrf.isChecked()) {
                        pay = RBTrf.getText().toString();
                    }

                    String jumlah = spJumlah.getSelectedItem().toString();

                    String rasa = "Rasa pilihan :\n";
                    int startlen = rasa.length();
                    if (CBCklt.isChecked()) rasa += CBCklt.getText() + "\n";
                    if (CBRed.isChecked()) rasa += CBRed.getText() + "\n";
                    if (CBGreen.isChecked()) rasa += CBGreen.getText() + "\n";

                    if(rasa.length() == startlen) rasa += "(No object was choosen)";

                    String topping = "Topping pilihan :\n";
                    int starttop = topping.length();
                    if (CBMes.isChecked()) topping += CBMes.getText() + "\n";
                    if (CBNut.isChecked()) topping += CBNut.getText() + "\n";
                    if (CBOreo.isChecked()) topping += CBOreo.getText() + "\n";
                    if (CBMas.isChecked()) topping += CBMas.getText() + "\n";

                    if(topping.length() == starttop) topping += "(No object was choosen)";

                    tvHasil.setText("Nama Pemesan   : " + nama + "\n" + "Jumlah Pesan    : " + jumlah + "\n" + "Pembayaran    : " + pay + "\n" + "Isi   : " + isi + "\n"
                            + rasa + "\n" + topping );
                }
            }
        });

    }

    private boolean isValid() {
        boolean valid = true;

        String nama = isinama.getText().toString();
        String pay = "";
        String isi = "";

        if(nama.isEmpty()) {
            isinama.setError("Name must be filled!");
            valid = false;
        } else if (nama.length() <3){
            isinama.setError("Name min have 3 characters");
            valid = false;
        } else {
            isinama.setError(null);
        }
        return valid;
    }

}
