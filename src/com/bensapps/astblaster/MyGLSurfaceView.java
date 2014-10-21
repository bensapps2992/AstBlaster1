package com.bensapps.astblaster;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {
	public MyGLRenderer mRenderer;
	Context mcontext;
	
	public MyGLSurfaceView(Context context) {
        super(context);
        mcontext = context;

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        //float ratio = getWidth()/getHeight();
        mRenderer = new MyGLRenderer(context, 2f);
        //mRenderer.ratio=getWidth()/getHeight();
        setRenderer(mRenderer);
        

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    
}
