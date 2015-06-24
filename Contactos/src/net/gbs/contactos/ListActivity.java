package net.gbs.contactos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import net.gbs.contactos.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		InputStreamReader flujo=null;
	    BufferedReader lector=null;
	    TextView tvTexto = (TextView)findViewById(R.id.TV_Contactos);
	    try {
	        flujo= new InputStreamReader(openFileInput("contactos.txt"));
	        lector= new BufferedReader(flujo);
	        String texto = lector.readLine();
	        while(texto!=null) {
	        	tvTexto.append(texto+"\n");
	           // tbTexto.setText(texto);
	            texto=lector.readLine();
	        }
	    } catch (Exception ex) {
	    	Toast.makeText(this,"Error al leer fichero desde memoria interna", Toast.LENGTH_SHORT).show();
	    } finally {
	        try {
	                if(flujo!=null)
	                    flujo.close();
	            } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}
	
	
}
