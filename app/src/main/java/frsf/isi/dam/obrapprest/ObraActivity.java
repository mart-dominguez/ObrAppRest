package frsf.isi.dam.obrapprest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import frsf.isi.dam.obrapprest.modelo.Obra;
import frsf.isi.dam.obrapprest.dao.ObraRepository;

public class ObraActivity extends AppCompatActivity {


    Button btnGuardarObra;
    EditText etNombre;
    Obra obraActual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obra);
        etNombre= (EditText) findViewById(R.id.obraNombre);
        if(getIntent().getExtras()!=null){
            int indice = getIntent().getExtras().getInt("indiceObraActual",-1);
            if( indice >=0){
                obraActual = ObraRepository.getInstance().getListaObras().get(indice);
                etNombre.setText(obraActual.getDescripcion());
            }
        }
        btnGuardarObra = (Button) findViewById(R.id.btnGuardarObra);
        btnGuardarObra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(obraActual==null){
                    obraActual= new Obra();
                    obraActual.setDescripcion(etNombre.getText().toString());
                    ObraRepository.getInstance().crearObra(obraActual,miHandler);
                } else{
                    obraActual.setDescripcion(etNombre.getText().toString());
                    ObraRepository.getInstance().actualizarObra(obraActual,miHandler);
                }
            }
        });
    }

    Handler miHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(Message msg) {
            Log.d("APP_2","Vuelve al handler"+msg.arg1);

            switch (msg.arg1 ){
                case ObraRepository._ALTA_OBRA:
                case ObraRepository._UPDATE_OBRA:
                    Intent i = new Intent(ObraActivity.this,ObraListActivity.class);
                    startActivity(i);
                    break;
            }
        }
    };
}

