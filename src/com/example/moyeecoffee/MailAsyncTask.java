package com.example.moyeecoffee;

import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

public class MailAsyncTask extends AsyncTask<URL, Integer, Long> {
	private String[] to;
	private String from;
	private String subject;
	private String body;
	
	MailAsyncTask(String[] to, String from, String subject, String body){
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.body = body;
	}
	
	protected Long doInBackground(URL... urls) {
		// int count = urls.length;
		// long totalSize = 0;
		// for (int i = 0; i < count; i++) {
		// totalSize += Downloader.downloadFile(urls[i]);
		// publishProgress((int) ((i / (float) count) * 100));
		// // Escape early if cancel() is called
		// if (isCancelled()) break;
		// }
		// return totalSize
		Mail m = new Mail("moyee.app@gmail.com", "moyee187");
		
		m.setTo(to);
		m.setFrom(from);
		m.setSubject(subject);
		m.setBody(body);

		try {
			// m.addAttachment("/sdcard/filelocation");

			if (m.send()) {
				// Toast.makeText(MailApp.this, "Email was sent successfully.",
				// Toast.LENGTH_LONG).show();
			}

			else {
				// Toast.makeText(MailApp.this, "Email was not sent.",
				// Toast.LENGTH_LONG).show();
			}
		}

		catch (Exception e) {
			// Toast.makeText(MailApp.this,
			// "There was a problem sending the email.",
			// Toast.LENGTH_LONG).show();
			Log.e("MailApp", "Could not send email", e);
		}
		return (long)0;
	}

	protected void onProgressUpdate(Integer... progress) {
		// setProgressPercent(progress[0]);
	}

	protected void onPostExecute(Long result) {
		// showDialog("Downloaded " + result + " bytes");
	}
}