package com.example.sales;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Settings extends AppCompatActivity{

    Button changeSizeBtn,coin,help,about,activate;
    EditText editText;
    TextView textView;
    SeekBar seekBar;

    int seekBar_value;
    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;
    private TextView textViewUsername;
    private TextView textViewPassword;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        changeSizeBtn = (Button)findViewById(R.id.button2);
        //coin = (Button)findViewById(R.id.button5);
        help = (Button)findViewById(R.id.button2);
        about = (Button)findViewById(R.id.button);
        activate = (Button)findViewById(R.id.button3);
        changeSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.dialog_change_size, null);
                final  EditText editText= alertLayout.findViewById(R.id.editText);
                final TextView textView = alertLayout.findViewById(R.id.textview);
                final TextView textView2 = alertLayout.findViewById(R.id.textView2);
                final SeekBar seekBar=alertLayout.findViewById(R.id.seekBar);

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBar_value = progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        String temp = "processing.......";
                        textView2.setText(temp);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textView2.setText(editText.getText().toString());
                        textView2.setTextSize(seekBar_value);
                    }
                });


                //openDialog();
                //  AlertDialog.Builder a = new AlertDialog.Builder()
                AlertDialog.Builder alert = new AlertDialog.Builder(Settings.this);
                alert.setTitle("Info");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // String user = etUsername.getText().toString();
                        // String pass = etEmail.getText().toString();
                        //Toast.makeText(getBaseContext(), "Username: " + user + " Email: " + pass, Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();

            }
        });
        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.layout_dialog, null);
                final  EditText editText= alertLayout.findViewById(R.id.edit_username);
                final  EditText editText2= alertLayout.findViewById(R.id.edit_password);

                AlertDialog.Builder alert = new AlertDialog.Builder(Settings.this);
                alert.setTitle("Info");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // String user = etUsername.getText().toString();
                        // String pass = etEmail.getText().toString();
                        //Toast.makeText(getBaseContext(), "Username: " + user + " Email: " + pass, Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
        /////////////////
        initList();

        Spinner spinnerCountries = findViewById(R.id.spinner);

        mAdapter = new CountryAdapter(this, mCountryList);
        spinnerCountries.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                String clickedCountryName = clickedItem.getCountryName();
                Toast.makeText(Settings.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /////////
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this,About.class));
            }
        });

        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this,Help.class));
            }
        });

    }

    private void initList() {
        mCountryList = new ArrayList<>();
        mCountryList.add(new CountryItem("Shekel", R.drawable.jordan));
        mCountryList.add(new CountryItem("Dinar", R.drawable.jordan));
        mCountryList.add(new CountryItem("USA", R.drawable.jordan));
        mCountryList.add(new CountryItem("Germany", R.drawable.jordan));
    }


}