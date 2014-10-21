package com.bensapps.astblaster;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

public class MyGLRenderer implements GLSurfaceView.Renderer{
    Context mContext;
    public static float ratio;
    private float mWidth;
    private float mHeight;

public MyGLRenderer(Context c, float r)
{
	mContext = c;
	ratio=r;
}

@Override
public void onSurfaceCreated(GL10 unused, EGLConfig config) {
	GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
}

@Override
public void onDrawFrame(GL10 unused) {   
	GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
	
}

@Override
public void onSurfaceChanged(GL10 unused, int width, int height) {
	//riGraphicTools.doShaders(mContext);//load all the shaders
    
	GLES20.glViewport(0, 0, width, height);//set the viewport to the whole screen
    mWidth=width;
    mHeight=height;
    MyGLRenderer.ratio = (float) width / height;
}

}
