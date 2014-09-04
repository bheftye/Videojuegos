package test.android.testandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.Menu;
import android.view.View;

public class ShapeTest extends Activity {
	
	class RenderView extends View{
		Paint paint;
		
		public RenderView(Context context){
			super(context);
			paint = new Paint();
		}
		
		protected void onDraw(Canvas canvas){
			canvas.drawRGB(255,255,255);
			paint.setColor(Color.RED);
			canvas.drawLine(0,0, canvas.getWidth()-1, canvas.getHeight()-1,paint);
			
			paint.setStyle(Style.STROKE);
			paint.setColor(0xff00ff00);
			canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 40, paint);
			
			paint.setStyle(Style.FILL);
			paint.setColor(0x770000ff);
			canvas.drawRect(100,100,200,200, paint);
			invalidate();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shape_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shape_test, menu);
		return true;
	}

}
