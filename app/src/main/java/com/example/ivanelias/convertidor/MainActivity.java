package com.example.ivanelias.convertidor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public int potencia;
    public double potencia1;
    public double potencia2;
    public String item2;
    public String item3;
    private EditText editText2;
    private EditText editText1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        button=(Button)findViewById(R.id.btnCalcular);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Double resultado=Double.parseDouble(editText1.getText().toString())*Math.pow(10,potencia1-potencia2);
                Double resultado=Double.parseDouble(editText1.getText().toString())*(potencia1/potencia2);
                String pattern = "##.############";
                DecimalFormat decimalFormat = new DecimalFormat(pattern);
                editText2.setText(decimalFormat.format(resultado));
//                editText2.setText(String.format("%.12f",resultado));
            }
        });

        editText1=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);

        List<String> unidades=new ArrayList<>();
        unidades.add("Resistencia");
        unidades.add("Capacitancia");
        unidades.add("Longitud");
        unidades.add("Tiempo");
        unidades.add("Masa");

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,unidades);

        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        //Log.d("", "");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String item=parent.getItemAtPosition(position).toString();
//        if (item.equals("Resistencias")){
//            resistencias();
//        }
//        Toast.makeText(parent.getContext(),"Selected"+item,Toast.LENGTH_LONG).show();
        if (parent.getId()==R.id.spinner){
            String item=parent.getItemAtPosition(position).toString();
            if (item.equals("Resistencia")){
                resistencias();
            }
            if (item.equals("Capacitancia")){
                capacitancias();
//                Toast.makeText(parent.getContext(),""+item,Toast.LENGTH_LONG).show();
            }
            if (item.equals("Longitud")){
                longitudes();
            }
            if (item.equals("Tiempo")){
                tiempo();
            }
            if (item.equals("Masa")){
                masa();
            }
        }
        if (parent.getId()==R.id.spinner2){
            //obtains item of spinner
            item2=parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(),"Selected"+item2,Toast.LENGTH_LONG).show();
            potencia1=identificaPotencia(item2);
//            Toast.makeText(parent.getContext(),""+potencia1,Toast.LENGTH_LONG).show();





//            double numero=Double.parseDouble(editText1.getText().toString());






            //show identificaPotencia retunr value
//            Toast.makeText(parent.getContext(),""+potenciador,Toast.LENGTH_LONG).show();
//            double resultado=numero*Math.pow(10,identificaPotencia(item2));
//            editText2.setText(Double.toString(resultado));


        }
        if (parent.getId()==R.id.spinner3){
            item3=parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(),"Selected"+item3,Toast.LENGTH_LONG).show();
            potencia2=identificaPotencia(item3);
//            Toast.makeText(parent.getContext(),""+potencia2,Toast.LENGTH_LONG).show();



//            if (item3.contains("nanoohmio nΩ")){
//                potencia2=-9;
//            }
//            if (item3.contains("microohmio µΩ")){
//                potencia2=-6;
//            }
//            if(item3.contains("miliohmio mΩ")){
//                potencia2=-3;
//            }
//            if(item3.contains("ohmio Ω")){
//                potencia2=0;
//            }
//            if(item3.contains("kiloohmio kΩ")){
//                potencia2=3;
//            }
//            if(item3.contains("megaohmio MΩ")){
//                potencia2=6;
//            }
//            if(item3.contains("gigaohmio GΩ")){
//                potencia2=9;
//            }
//            double numero=Double.parseDouble(editText1.getText().toString());
//            double resultado=numero*Math.pow(10,potencia2);
//            editText2.setText(Double.toString(resultado));
        }
//        if (item2.contains("nano")){
//            potencia1=-9;
//        }
//        else{
//
//        }
//        if (item3.contains("micro")){
//            potencia2=-6;
//        }
//        else{
//
//        }
//        double numero1=Double.parseDouble(editText2.getText().toString());
//        double resultado=numero1*Math.pow(10,potencia1-potencia2);
//        editText2.setText(Double.toString(resultado));

//        Toast.makeText(parent.getContext(),item2+""+item3,Toast.LENGTH_LONG).show();

    }
    public double identificaPotencia(String itemsito){
        if (itemsito.contains("nano")){
            return Math.pow(10,-9);
        }
        if (itemsito.contains("micro")){
            return Math.pow(10,-6);
        }
        if(itemsito.contains("mili")){
            return Math.pow(10,-3);
        }
        if(itemsito.contains("centi")){
            return Math.pow(10,-2);
        }
        if(itemsito.contains("kilo")){
            return Math.pow(10,3);
        }
        if(itemsito.contains("mega")){
            return Math.pow(10,6);
        }
        if(itemsito.contains("giga")){
            return Math.pow(10,9);
        }
        if (itemsito.contains("pie")){
            return 1/3.28084;
        }
        if (itemsito.contains("pulgada")){
            return 1/39.3701;
        }
        if (itemsito.contains("minuto")){
            return 60;
        }
        if (itemsito.contains("hora")){
            return 3600;
        }
        if (itemsito.contains("dia")){
            return 3600*24;
        }
        if (itemsito.contains("semana")){
            return 3600*24*7;
        }
        if (itemsito.contains("tonelada")){
            return 1000*1000;
        }
        else{
            return 1;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        resistencias();
    }

//    public void Calcular(String cadena){
//        ArrayList<String> factores=new ArrayList<String>();
//        factores.add(cadena);
//        if (factores.size()==2){
//            factores.clear();
//        }
//        else{
//            editText2.setText(factores.get(1).toString());
//        }
//    }


    public void resistencias(){
        Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3=(Spinner)findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(this);

        List<String> resistencias=new ArrayList<>();
        resistencias.add("nanoohmio nΩ");
        resistencias.add("microohmio µΩ");
        resistencias.add("miliohmio mΩ");
        resistencias.add("ohmio Ω");
        resistencias.add("kiloohmio kΩ");
        resistencias.add("megaohmio MΩ");
        resistencias.add("gigaohmio GΩ");

        ArrayAdapter<String> dataResistencias=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,resistencias);
        dataResistencias.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner2.setAdapter(dataResistencias);
        spinner3.setAdapter(dataResistencias);
    }
    public void capacitancias(){
        Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3=(Spinner)findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(this);

        List<String> resistencias=new ArrayList<>();
        resistencias.add("nanofaradio nF");
        resistencias.add("microfaradio µF");
        resistencias.add("milifaradio mF");
        resistencias.add("faradio F");
        resistencias.add("kilofaradio kF");
        resistencias.add("megafaradio MF");
        resistencias.add("gigafaradio GF");
        ArrayAdapter<String> dataResistencias=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,resistencias);
        dataResistencias.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner2.setAdapter(dataResistencias);
        spinner3.setAdapter(dataResistencias);
    }
    public void masa(){
        Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3=(Spinner)findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(this);

        List<String> resistencias=new ArrayList<>();
        resistencias.add("nanogramo ng");
        resistencias.add("microgramo µg");
        resistencias.add("miligramo mg");
        resistencias.add("centigramo cg");
        resistencias.add("gramo g");
        resistencias.add("kilogramo kg");
        resistencias.add("tonelada ton");
        ArrayAdapter<String> dataResistencias=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,resistencias);
        dataResistencias.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner2.setAdapter(dataResistencias);
        spinner3.setAdapter(dataResistencias);
    }
    public void longitudes(){
        Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3=(Spinner)findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(this);

        List<String> resistencias=new ArrayList<>();
        resistencias.add("nanometro nm");
        resistencias.add("micrometro µm");
        resistencias.add("milimetro mm");
        resistencias.add("centimetro cm");
        resistencias.add("pulgada in");
        resistencias.add("metro m");
        resistencias.add("pie ft");
        resistencias.add("kilometro km");
        ArrayAdapter<String> dataResistencias=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,resistencias);
        dataResistencias.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner2.setAdapter(dataResistencias);
        spinner3.setAdapter(dataResistencias);
    }
    public void tiempo(){
        Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3=(Spinner)findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(this);

        List<String> resistencias=new ArrayList<>();
        resistencias.add("nanosegundo ns");
        resistencias.add("microsegundo µs");
        resistencias.add("milisegundo ms");
        resistencias.add("segundo s");
        resistencias.add("minuto min");
        resistencias.add("hora h");
        resistencias.add("dia d");
        resistencias.add("semana week");
        ArrayAdapter<String> dataResistencias=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,resistencias);
        dataResistencias.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner2.setAdapter(dataResistencias);
        spinner3.setAdapter(dataResistencias);
    }
}