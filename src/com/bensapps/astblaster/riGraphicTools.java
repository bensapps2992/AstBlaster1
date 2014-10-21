package com.bensapps.astblaster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.bensapps.astblaster.R;

import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;

public class riGraphicTools {

	// Program variables
	public static int sp_SolidColor;
	private static Context mContext;
	

	public static int loadShader(int type, String shaderCode){


	    // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
	    // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
	    int shader = GLES20.glCreateShader(type);

	    // add the source code to the shader and compile it
	    GLES20.glShaderSource(shader, shaderCode);
	    GLES20.glCompileShader(shader);
	    
	    // return the shader
	    return shader;
	}
	
	private static String readFromFile(int id) {

	    String ret = "";

	    try {
	        InputStream inputStream = mContext.getResources().openRawResource(id);

	        if ( inputStream != null ) {
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	            String receiveString = "";
	            StringBuilder stringBuilder = new StringBuilder();

	            while ( (receiveString = bufferedReader.readLine()) != null ) {
	                stringBuilder.append(receiveString);
	            }

	            inputStream.close();
	            ret = stringBuilder.toString();
	        }
	    }
	    catch (FileNotFoundException e) {
	        Log.e("login activity", "File not found: " + e.toString());
	    } catch (IOException e) {
	        Log.e("login activity", "Can not read file: " + e.toString());
	    }

	    return ret;
	}
	
	public static void doShaders(Context context){
		
		mContext=context;
		/* SHADER Solid
		 * 
		 * This shader is for rendering a colored primitive.
		 * 
		 */
		String vs_SolidColor=readFromFile(R.raw.vs_solidcolor);
		String fs_SolidColor=readFromFile(R.raw.fs_solidcolor);
		
		// Create the shaders, solid color
	    int vertexShader = riGraphicTools.loadShader(GLES20.GL_VERTEX_SHADER,vs_SolidColor);
	    int fragmentShader = riGraphicTools.loadShader(GLES20.GL_FRAGMENT_SHADER,fs_SolidColor);

	    riGraphicTools.sp_SolidColor = GLES20.glCreateProgram();             // create empty OpenGL ES Program
	    GLES20.glAttachShader(riGraphicTools.sp_SolidColor, vertexShader);   // add the vertex shader to program
	    GLES20.glAttachShader(riGraphicTools.sp_SolidColor, fragmentShader); // add the fragment shader to program
	    GLES20.glLinkProgram(riGraphicTools.sp_SolidColor);                  // creates OpenGL ES program executables
	    
	    // Set our shader programm
		GLES20.glUseProgram(riGraphicTools.sp_SolidColor);
	}
}
