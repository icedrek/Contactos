package net.gbs.contactos;

import java.io.IOException;
import java.io.OutputStreamWriter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText et_Nombre, et_Email, et_Telefono;
	private OutputStreamWriter archivo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et_Nombre   = (EditText) findViewById(R.id.ET_Nombre);
		et_Email    = (EditText) findViewById(R.id.ET_Email);
		et_Telefono = (EditText) findViewById(R.id.ET_Telefono);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//metodo para insertar registros en el fichero "contactos.txt"
	public void insertar(View v){
		try {
			archivo = new OutputStreamWriter(openFileOutput("contactos.txt",Activity.MODE_APPEND));
			
			String contacto = (et_Nombre.getText().toString() + ";" +
					           et_Email.getText().toString()  + ";" +
					           et_Telefono.getText().toString())+"\n";
			
			archivo.write(contacto);
			archivo.flush();
			archivo.close();
			//Borrado de los datos de pantalla
			et_Nombre.setText(null);
			et_Email.setText(null);
			et_Telefono.setText(null);
		} catch (IOException e) {
			Toast.makeText(this,"Error al escribir datos", Toast.LENGTH_LONG).show();
		} finally {
			try {
	            if(archivo!=null)
	                archivo.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		Toast.makeText(this,"Los datos fueron grabados", Toast.LENGTH_SHORT).show();
	}
	
	public void consultar(View v){	
		Intent listado = new Intent(this, ListActivity.class );
		startActivity(listado);
	}
}
