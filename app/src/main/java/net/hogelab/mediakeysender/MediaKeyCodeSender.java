package net.hogelab.mediakeysender;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.view.KeyEvent;

/**
 * Created by kobayasi on 2015/12/02.
 */
public class MediaKeyCodeSender {
    public static final String TAG = MediaKeyCodeSender.class.getSimpleName();


    public static void sendClick(Context context, int keyCode) {
        sendKeyCode(context, KeyEvent.ACTION_DOWN, keyCode);
        sendKeyCode(context, KeyEvent.ACTION_UP, keyCode);
    }

    public static void sendKeyCode(Context context, int action, int keyCode) {
        long eventTime = SystemClock.uptimeMillis();

        Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        KeyEvent event = new KeyEvent(eventTime, eventTime, action, keyCode, 0);
        intent.putExtra(Intent.EXTRA_KEY_EVENT, event);
        context.sendBroadcast(intent);
    }
}
