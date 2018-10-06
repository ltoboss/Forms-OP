package com.losuna.luisosuna.forms;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText nombre;
    EditText apellido;
    EditText edad;
    EditText u_email;
    EditText u_telefono;
    EditText cc;
    EditText cvv_cc;
    DatePicker u_fecha;
    TimePicker u_hora;
    Spinner spHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txtName);
        apellido = findViewById(R.id.txtSurname);
        edad = findViewById(R.id.txtAge);
        u_email= findViewById(R.id.txtEmail);
        u_telefono= findViewById(R.id.txtTelefono);
        cc= findViewById(R.id.txtNumberCC);
        cvv_cc= findViewById(R.id.txtCVV);
        u_fecha= findViewById(R.id.txtFecha);
        u_hora= findViewById(R.id.txtHora);

        spHora = findViewById(R.id.spHora);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spHora.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

               

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Datos");
                builder1.setMessage("Nombre: "+ nombre.getText() + "\n"+
                                    "Apellido: "+apellido.getText()+ "\n"+
                                    "Edad: "+edad.getText()+ "\n"+
                                    "Email: "+u_email.getText()+ "\n"+
                                    "Telefono: "+u_telefono.getText()+ "\n"+
                                    "Tipo de sangre : "+spHora.getSelectedItem().toString() + "\n"+
                                    "Fecha: "+u_fecha.getDayOfMonth() + " de "+ u_fecha.getMonth()+ " del "+u_fecha.getYear()+ "\n"+
                                    "Hora: "+u_hora.getHour() + ":"+ u_hora.getMinute() + "\n"
                );
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                nombre.setText("");
                                apellido.setText("");
                                edad.setText("");
                                u_email.setText("");
                                u_telefono.setText("");
                                cc.setText("");
                                cvv_cc.setText("");
                                Toast.makeText(MainActivity.this, "Cambios guardados.", Toast.LENGTH_SHORT).show();
                                nombre.requestFocus();
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();


            }
        });

    }


}
