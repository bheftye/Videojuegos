package test.android.testandroid;

import java.io.File;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ExternalStorageTest extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		
		String state = Environment.getExternalStorageState();
		if(!state.equals(Environment.MEDIA_MOUNTED)){
			textView.setText("No external storage mounted");
		}
		else{
			File externalDir = Environment.getExternalStorageDirectory();
			File textFile = new File(externalDir.getAbsolutePath()+ File.separator + "text.txt");
			try{
				writeTextFile(textFile, "This is a test. Roger");
				String text = readTextFile(textFile);
				textView.setText(text);
				if(!textFile.delete()){
					textView.setText("Couldn't remove temporary file");
				}
			}catch(IOException e){
				textView.setText("something went wrong!" + e.getMessage());
			}
		}
	}
	
	private void writeTextFile(File file, String text)throws IOException{
		//BufferedWriter 
	}
	
	private String readTextFile(File textFile){
		return "";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.external_storage_test, menu);
		return true;
	}

}
