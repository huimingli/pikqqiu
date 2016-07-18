package com.celt.estation.template.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.celt.estation.template.AppVariable;

/**
 * 处理从网络上得到输入流的方法，如获得网络图片
 * @author Administrator
 *
 */
public class IOUtil {

	// tag for log
	private static String TAG = IOUtil.class.getSimpleName();
	
	// Load image from local
	public static Bitmap getBitmapLocal(String url) {
		try {
			FileInputStream fis = new FileInputStream(url);
			return BitmapFactory.decodeStream(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Load image from network
	public static Bitmap getBitmapRemote(Context ctx, String url) {
		URL myFileUrl = null;
		Bitmap bitmap = null;
		try {
			url = AppVariable.api.base +"/upload/"+ url;
			Log.w(TAG, url);
			myFileUrl = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			HttpURLConnection conn = null;
//			if (HttpUtil.WAP_INT == HttpUtil.getNetType(ctx)) {
//				Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)); 
//				conn = (HttpURLConnection) myFileUrl.openConnection(proxy);
//			} else {
//				conn = (HttpURLConnection) myFileUrl.openConnection();
//			}
			conn = (HttpURLConnection) myFileUrl.openConnection();
			conn.setConnectTimeout(10000);
			conn.setDoInput(true);
			conn.connect();
			InputStream is = conn.getInputStream();
			bitmap = BitmapFactory.decodeStream(is);
			Log.w(TAG, "远程得到的图片："+bitmap);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}
}