package it.playfellas.hicaptain.sounds;

import android.content.Context;
import android.media.MediaPlayer;

import it.playfellas.hicaptain.R;

/**
 * Created by affo on 21/09/15.
 */
public class Baraldi {
    private static MediaPlayer player = null;
    private static Runnable cb = null;

    private static MediaPlayer getPlayer(Context ctxt, int soundID, final Runnable onComplete) {
        shutUp(false);
        player = MediaPlayer.create(ctxt, soundID);
        if (onComplete != null) {
            cb = onComplete;
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    onComplete.run();
                }
            });
        }
        return player;
    }

    public static void shutUp(boolean runCBs) {
        if (player != null) {
            player.stop();
            player.release();
            if (runCBs && cb != null) {
                cb.run();
            }
        }
        player = null;
        cb = null;
    }

    /**
     * @param ctxt
     * @param onComplete can be `null` if no callback is required
     */
    public static void welcome(Context ctxt, final Runnable onComplete) {
        getPlayer(ctxt, R.raw.welcome, onComplete).start();
    }

    public static void askHelp(Context ctxt, final Runnable onComplete) {
        getPlayer(ctxt, R.raw.help, onComplete).start();
    }

    public static void greet(Context ctxt, final Runnable onComplete) {
        getPlayer(ctxt, R.raw.greetings, onComplete).start();
    }
}
