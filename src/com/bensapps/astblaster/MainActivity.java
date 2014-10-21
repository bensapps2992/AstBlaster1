	package com.bensapps.astblaster;
	
	import android.app.Activity;
	import android.os.Bundle;
	
	public class MainActivity extends Activity {
	
		public MyGLSurfaceView mGLView;
		
		@Override
	    public void onCreate(Bundle savedInstanceState) { 
			super.onCreate(savedInstanceState);
	        mGLView = new MyGLSurfaceView(this);
	        setContentView(mGLView);
		}
		
		@Override
	    protected void onPause() {
	        super.onPause();
	        // The following call pauses the rendering thread.
	        // If your OpenGL application is memory intensive,
	        // you should consider de-allocating objects that
	        // consume significant memory here.
	        mGLView.onPause();
	    }
		
		 @Override
		 protected void onResume() {
		    super.onResume();
		    mGLView.onResume();
	    }
	}
