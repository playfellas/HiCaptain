package it.playfellas.hicaptain.sounds;

import android.content.Context;
import android.media.MediaPlayer;

import it.playfellas.hicaptain.R;

/**
 * Created by affo on 21/09/15.
 */
public class Baraldi {
    private static MediaPlayer player = null;

    private static MediaPlayer getPlayer(Context ctxt, int soundID) {
        shutUp();
        player = MediaPlayer.create(ctxt, soundID);
        return player;
    }

    private static MediaPlayer setListener(MediaPlayer p, final Runnable onComplete) {
        if (onComplete != null) {
            p.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    onComplete.run();
                }
            });
        }
        return p;
    }

    public static void shutUp() {
        if (player != null) {
            player.stop();
            player.release();
        }
        player = null;
    }

    /**
     * @param ctxt
     * @param onComplete can be `null` if no callback is required
     */
    public static void welcome(Context ctxt, final Runnable onComplete) {
        setListener(getPlayer(ctxt, R.raw.welcome), onComplete).start();
    }

    public static void askHelp(Context ctxt, final Runnable onComplete) {
        setListener(getPlayer(ctxt, R.raw.help), onComplete).start();
    }

    public static void greet(Context ctxt, final Runnable onComplete) {
        setListener(getPlayer(ctxt, R.raw.greetings), onComplete).start();
    }
}
