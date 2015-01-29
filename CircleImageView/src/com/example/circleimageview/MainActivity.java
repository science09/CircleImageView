package com.example.circleimageview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;

public class MainActivity extends ActionBarActivity {
	private CircleImageView mCircleImage;
	private RequestQueue mQueue;
	private String url = "http://b.hiphotos.baidu.com/image/pic/item/63d0f703918fa0ec3958aa0b259759ee3d6ddb1d.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCircleImage = (CircleImageView) findViewById(R.id.netImage);
		mQueue = Volley.newRequestQueue(getApplicationContext());
		ImageLoader imageLoader = new ImageLoader(mQueue, new ImageCache() {
			
			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				
			}
			
			@Override
			public Bitmap getBitmap(String url) {
				return null;
			}
		});
		ImageListener listener = ImageLoader.getImageListener(mCircleImage, R.drawable.mm, R.drawable.mm);
		imageLoader.get(url, listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
