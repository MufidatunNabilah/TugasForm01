package id.sch.smktelkom_mlg.tugas01.xirpl3019.form;


import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.EditText;

import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {
    EditText NamaAnak, NamaOrtu, Email;
    RadioGroup kelamin;
    RadioButton laki, perempuan;
    Spinner asal;
    CheckBox membaca, berenang, menulis, bersepeda;
    Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NamaAnak = (EditText) findViewById(R.id.editnamaanak);
        NamaOrtu = (EditText) findViewById(R.id.editNamaOrtu);
        Email = (EditText) findViewById(R.id.editEmail);
        kelamin = (RadioGroup) findViewById(R.id.rgKelamin);
        laki = (RadioButton) findViewById(R.id.radioLaki);
        perempuan = (RadioButton) findViewById(R.id.radioPerempuan);
        asal = (Spinner) findViewById(R.id.spnrasal);
        membaca = (CheckBox) findViewById(R.id.cbMembaca);
        berenang = (CheckBox) findViewById(R.id.cbBerenang);
        menulis = (CheckBox) findViewById(R.id.cbMenulis);
        bersepeda = (CheckBox) findViewById(R.id.cbBersepeda);
        send = (Button) findViewById(R.id.sebarkan);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify();
            }
        });


    }

    private void verify() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Peringatan!");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        if (NamaAnak.getText().length() == 0) {
            dialog.setMessage("Nama Anak belum di isi");
            dialog.create().show();
        }else if (NamaOrtu.getText().length() == 0) {
            dialog.setMessage("Nama Orang Tua belum  di isi");
            dialog.create().show();
        }else if (Email.getText().length() == 0) {
            dialog.setMessage("E-mail belum  di isi");
            dialog.create().show();
        } else if (kelamin.getCheckedRadioButtonId() == -1) {
            dialog.setMessage("Jenis Kelamin belum dipilih");
            dialog.create().show();
        } else if (!membaca.isChecked() || !berenang.isChecked() || !menulis.isChecked() || !bersepeda.isChecked()) {
            dialog.setMessage("Hobi belum dipilih");
            dialog.create().show();
        } else if (asal.getSelectedItemId() == 0) {
            dialog.setMessage("Pilih asal Anda");
            dialog.create().show();
        } else {
            dialog.setTitle("Trimakasih");
            dialog.setMessage("Terima kasih telah mengisi");
            dialog.create().show();
        }
    }
}
